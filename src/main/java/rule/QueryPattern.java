package rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by khanh on 05/04/2018.
 */
public class QueryPattern {

    // mua chung cư giá 1 tỷ tại linh đàm
    private static final String SINGLE_PRICE = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(t[yỷ]?)";
    private static final Pattern SINGLE_PRICE_PATTERN = Pattern.compile(SINGLE_PRICE);
    // mua chung cư giá 1-2 tỷ tại linh đàm, 1 2 tỷ, 1 - 2 t, 1.5 - 2.5 ty
    private static final String RANGE_PRICE = "(?i)((?:\\d*\\.)?\\d+)(\\s*)([\\s-,_])(\\s*)((?:\\d*\\.)?\\d+)(\\s*)(t[yỷ]?)";
    private static final Pattern RANGE_PRICE_PATTERN = Pattern.compile(RANGE_PRICE);

    private static final String LESS_THAN_PRICE = "";
    private static final String GREATER_THAN_PRICE = "";

    private static final Pattern SINGLE_AREA_PATTERN = Pattern.compile("");
    private static final Pattern RANGE_AREA_PATTERN = Pattern.compile("");
    String areaPattern = "m2";

    // test single Price
    private static String[] singlePrices = {
            "mua chung cư giá 1 tỷ tại linh đàm",
            "1.334 ty",
            "1.22 t",
            "1.22ty",
            ".484t",
            "3.2d",
            "mua nha rieng 5.3 ty"
    };

    // test range Price
    private static String rangePrice = "mua chung cư giá 1.5-2.25 tỷ tại linh đàm";
    private static String[] rangePrices = {
            "1-2ty",
            "1-2tỷ",
            "1-2t",
            "1 - 2 ty",
            " 1 -  2  tỷ",
            "12.232 - 40.34 ty",
            ".666 - 3.33 tỷ",
            " .22 - .33 ty",
            "mua chung cu .2 , .3 t",
            "mua chung cu 2.2 .4 ty",
            "mua chung cư giá 1.5-2.25 tỷ tại linh đàm",
    };


    public static void main(String[] args) {
        for (int i = 0; i < rangePrices.length; ++i) {
            System.out.println(i + " -----------------");
            matchRangePrice(rangePrices[i]);
        }
        for (int i = 0; i < singlePrices.length; ++i) {
            System.out.println(i + " -----------------");
            matchSinglePrice(singlePrices[i]);
        }
    }

    private static boolean isMatch(String regex, String s) {
        return s.matches(regex);
    }

    private static void matchRangePrice(String s) {
        Matcher m = RANGE_PRICE_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(5));
        }
    }

    private static void matchSinglePrice(String s) {
        Matcher m = SINGLE_PRICE_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

}
