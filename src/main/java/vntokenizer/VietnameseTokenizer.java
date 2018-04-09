package vntokenizer;

import ai.vitk.type.Token;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;


/**
 * Vietnamese Tokenizer.
 *
 * @author duydo
 */
public class VietnameseTokenizer extends Tokenizer {

//    private Iterator<TaggedWord> taggedWords;

    private List<Token> tokens;
    Iterator<Token> taggedWords;

    private int offset = 0;
    private int skippedPositions;


    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
    private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);
    private final PositionIncrementAttribute posIncrAtt = addAttribute(PositionIncrementAttribute.class);

//    private vn.hus.nlp.tokenizer.Tokenizer tokenizer;
//    private SentenceDetector sentenceDetector;
//
//    private boolean sentenceDetectorEnabled;
//    private boolean ambiguitiesResolved;
//
//    public VietnameseTokenizer() {
//        this(true, false);
//    }
//
//    public VietnameseTokenizer(boolean sentenceDetectorEnabled, boolean ambiguitiesResolved) {
//        super();
//        this.sentenceDetectorEnabled = sentenceDetectorEnabled;
//        this.ambiguitiesResolved = ambiguitiesResolved;
//
//        if (this.sentenceDetectorEnabled) {
//            sentenceDetector = SentenceDetectorFactory.create(IConstants.LANG_VIETNAMESE);
//        }
//        tokenizer = AccessController.doPrivileged(new PrivilegedAction<vn.hus.nlp.tokenizer.Tokenizer>() {
//            @Override
//            public vn.hus.nlp.tokenizer.Tokenizer run() {
//                vn.hus.nlp.tokenizer.Tokenizer vnTokenizer = TokenizerProvider.getInstance().getTokenizer();
//                vnTokenizer.setAmbiguitiesResolved(ambiguitiesResolved);
//                return vnTokenizer;
//            }
//        });
//    }
//
//    private void tokenize(Reader input) throws IOException {
//        if (isSentenceDetectorEnabled()) {
//            final List<TaggedWord> words = new ArrayList<TaggedWord>();
//            final String[] sentences = sentenceDetector.detectSentences(input);
//            for (String s : sentences) {
//                tokenizer.tokenize(new StringReader(s));
//                words.addAll(tokenizer.getResult());
//            }
//            taggedWords = words.iterator();
//        } else {
//            tokenizer.tokenize(input);
//            taggedWords = tokenizer.getResult().iterator();
//        }
//    }

    @Override
    public final boolean incrementToken() throws IOException {
        clearAttributes();

//        while (taggedWords.hasNext()) {
//            System.out.println("first iterator");
//            Token t = taggedWords.next();
//            System.out.println(t.getWord());
//        }

        while (taggedWords.hasNext()) {



//            while (taggedWords.hasNext()) {
//                Token t = taggedWords.next();
//                String word = t.getWord();
//                System.out.println("token : " + word);
//            }


//            final TaggedWord word = taggedWords.next();
            Token t = taggedWords.next();
            String word = t.getWord();
            if (accept(word)) {
                posIncrAtt.setPositionIncrement(skippedPositions + 1);
                typeAtt.setType(TypeAttribute.DEFAULT_TYPE);
                final int length = word.length();
                termAtt.copyBuffer(word.toCharArray(), 0, length);
//                System.out.println("offset = " + offset);
//                int start = correctOffset(offset);
//                System.out.println("start = " + start);
                offsetAtt.setOffset(correctOffset(offset), offset = correctOffset(offset + length));
                offset++;
                return true;
            }
            skippedPositions++;
        }
        return false;
    }

    /**
     * Only accept the word characters.
     */
    private final boolean accept(String token) {
        if (token.length() == 1) {
            return Character.isLetterOrDigit(token.charAt(0));
        }
        return true;
    }

    @Override
    public final void end() throws IOException {
        super.end();
        final int finalOffset = correctOffset(offset);
        offsetAtt.setOffset(finalOffset, finalOffset);
        posIncrAtt.setPositionIncrement(posIncrAtt.getPositionIncrement() + skippedPositions);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        offset = 0;
        skippedPositions = 0;
        tokenize(input);
    }

    private void tokenize(Reader input) {
        int numChars;
        char[] buffer = new char[1024];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((numChars =
                    input.read(buffer, 0, buffer.length)) != -1) {
                stringBuilder.append(buffer, 0, numChars);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        String stringToTokenize = stringBuilder.toString();
        this.tokens = ViTokenizerFactory.getViTokenizer().tokenize(stringToTokenize);
        taggedWords = tokens.iterator();
    }

//    public boolean isSentenceDetectorEnabled() {
//        return sentenceDetectorEnabled;
//    }
//
//    public boolean isAmbiguitiesResolved() {
//        return ambiguitiesResolved;
//    }
}
