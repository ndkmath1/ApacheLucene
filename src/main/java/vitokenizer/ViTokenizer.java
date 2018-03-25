package vitokenizer;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;
import java.util.List;

import ai.vitk.tok.Tokenizer;
import ai.vitk.type.Keyword;
import ai.vitk.type.Token;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;

/**
 * Created by khanh on 24/03/2018.
 */
public class ViTokenizer extends org.apache.lucene.analysis.Tokenizer {

    String[] taggedWords;
    private int numWord;
    private String text;

    private int index = 0;
    private int offset = 0;
    private final CharTermAttribute termAttr;
    private final PositionIncrementAttribute posAttr;
    private final OffsetAttribute offsetAttr;
    private String lastContent;

    public ViTokenizer() {
        this.termAttr = addAttribute(CharTermAttribute.class);
        this.posAttr = addAttribute(PositionIncrementAttribute.class);
        this.offsetAttr = addAttribute(OffsetAttribute.class);
    }

    public ViTokenizer(String text) {
        this.text = text;
        lastContent = text;
        this.termAttr = addAttribute(CharTermAttribute.class);
        this.posAttr = addAttribute(PositionIncrementAttribute.class);
        this.offsetAttr = addAttribute(OffsetAttribute.class);
    }

    private void getTaggedWords(String text) {
        Tokenizer tokenizer = ViTokenizerFactory.getViTokenizer();
        List<Token> words = tokenizer.tokenize(text);
        taggedWords  = new String[words.size()];
        int i = 0;
        for (Token t: words) {
            taggedWords[i] = t.getWord();
            ++i;
        }
        numWord = taggedWords.length;
        offset = 0;
        index = 0;
    }


    @Override
    public final boolean incrementToken() throws IOException {
        System.out.println("increment token");
        clearAttributes();
        if (index == numWord)
            return false;
        String wordTag = taggedWords[index];
        String nextWordTag = null;
        try {
            nextWordTag = taggedWords[index + 1];
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        if (wordTag.equalsIgnoreCase("")) {

        } else {
            termAttr.copyBuffer(wordTag.toCharArray(), 0, wordTag.length());
            posAttr.setPositionIncrement(1);
            offsetAttr.setOffset(offset, offset + wordTag.length());
        }


        offset += wordTag.length();

        // Correct offset for two words
        if (index != numWord) {
            if (nextWordTag == null || lastContent.indexOf(nextWordTag, offset) == offset) {

            } else {
                offset++;
            }
        }
        index++;
        return true;
    }

    @Override
    public final void end() {
        try {
            super.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // set final offset
        int finalOffset = correctOffset(offset);
        offsetAttr.setOffset(finalOffset, finalOffset);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        getTaggedWords(text);
    }

}
