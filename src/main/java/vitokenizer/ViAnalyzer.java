package vitokenizer;

import ai.vitk.tok.*;
import ai.vitk.type.Token;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopwordAnalyzerBase;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.Tokenizer;

import java.io.Reader;
import java.util.List;

public class ViAnalyzer extends StopwordAnalyzerBase {

    public static void main(String[] args) {
        ai.vitk.tok.Tokenizer tokenizer = new ai.vitk.tok.Tokenizer();
        String text = "Đội tuyển U23 Việt Nam vô địch.";
        List<Token> words = tokenizer.tokenize(text);
        for (Token t: words) {
            System.out.println(t.getWord());
        }
    }


    private byte typeSaving = 0;

    public ViAnalyzer(CharArraySet stopwords) {
        super(stopwords);
    }

    @Override
    protected TokenStreamComponents createComponents(final String fieldName) {
        final Tokenizer src = new ViTokenizer();
        TokenStream tok = new StandardFilter(src);
        tok = new LowerCaseFilter(tok);
        tok = new StopFilter(tok, stopwords);
        return new TokenStreamComponents(src, tok);
    }

//    protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
//        final Tokenizer src = new ViTokenizer(reader);
//        TokenStream tok = new StandardFilter(src);
//        tok = new LowerCaseFilter(tok);
//        tok = new StopFilter(tok, stopwords);
//        return new TokenStreamComponents(src, tok);
//    }

}