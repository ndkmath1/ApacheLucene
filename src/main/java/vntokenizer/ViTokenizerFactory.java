package vntokenizer;

import ai.vitk.tok.Tokenizer;

/**
 * Created by khanh on 24/03/2018.
 */
public class ViTokenizerFactory {

    private static Tokenizer tokenizer = null;

    public static Tokenizer getViTokenizer() {
        if (tokenizer == null) {
            tokenizer = new Tokenizer();
        }
        return tokenizer;
    }

}
