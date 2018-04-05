package vitokenizer;

import ai.vitk.tok.Tokenizer;
import ai.vitk.type.Token;

import java.util.List;

/**
 * Created by khanh on 24/03/2018.
 */
public class TestToken {

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        String str = "mua nhà riêng giá khoảng 1-2 tỷ khu vực hai bà trưng hà nội";
//        String str = "mua nhà ở quận hai bà trưng hà nội";
//        String str = "viện công nghệ thông tin đại học bách khoa hà nội";
        List<Token> words = tokenizer.tokenize(str);
        for (Token t: words) {
            System.out.println(t.getWord());
        }
    }

}
