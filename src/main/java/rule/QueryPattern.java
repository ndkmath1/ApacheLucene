package rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by khanh on 05/04/2018.
 */
public class QueryPattern {

    // mua chung cư giá 1 tỷ tại linh đàm
    private static final String SINGLE_PRICE = "(?i)(.*)^(([\\d.,]+)(\\s*)([\\s-,_])(\\s*)([\\d.,]+))(\\d{1,2})(\\s*)t[yỷ](.*)";
    private static final Pattern SINGLE_PRICE_PATTERN = Pattern.compile(SINGLE_PRICE);
    // mua chung cư giá 1-2 tỷ tại linh đàm, 1 2 tỷ, 1 - 2 t, 1.5 - 2.5 ty
    private static final String RANGE_PRICE = "(?i)(.*)(\\d*\\.?\\d+)(\\s*)([\\s-,_])(\\s*)([\\d.,]+)(\\s*)t[yỷ](.*)";
    private static final Pattern RANGE_PRICE_PATTERN = Pattern.compile(RANGE_PRICE);

    private static final Pattern SINGLE_AREA_PATTERN = Pattern.compile("");
    private static final Pattern RANGE_AREA_PATTERN = Pattern.compile("");
    String areaPattern = "m2";

    private static String singlePrice = "mua chung cư giá 1 tỷ tại linh đàm";
    private static String rangePrice = "mua chung cư giá 1.5-2.25 tỷ tại linh đàm";

    public static void main(String[] args) {
        System.out.println(isMatch(RANGE_PRICE, rangePrice));
        matchRange(rangePrice);
        match(rangePrice);
    }

    private static boolean isMatch(String regex, String s) {
        return s.matches(regex);
    }

    private static void matchRange(String s) {
        Matcher m = RANGE_PRICE_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group());
            int count = m.groupCount();
            for (int i = 0; i < count; ++i) {
                System.out.println(i + ", " + m.group(i));
            }
//            System.out.println(m.group(2));
//            System.out.println(m.group(6));
        }
    }

    private static void match(String s) {
        Matcher m = SINGLE_PRICE_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group(2));
        }
    }

}
