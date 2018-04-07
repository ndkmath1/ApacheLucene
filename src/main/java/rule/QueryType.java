package rule;

/**
 * Created by khanh on 07/04/2018.
 */
public enum QueryType {

    OK(4000, "test");

    int v;
    String s;

    QueryType(int v, String s) {
        this.v = v;
        this.s = s;
    }

}
