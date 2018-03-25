package vitokenizer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.standard.StandardFilter;

/**
 * Created by khanh on 24/03/2018.
 */
public class CustomAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String s) {
        final Tokenizer src = new CustomTokenizer();
        TokenStream tok = new StandardFilter(src);
        tok = new LowerCaseFilter(tok);
        tok = new StopFilter(tok, ViStopWordsProvider.getStopWords());
        return new TokenStreamComponents(src, tok);
    }

}
