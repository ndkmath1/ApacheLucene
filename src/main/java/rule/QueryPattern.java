package rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by khanh on 05/04/2018.
 */
public class QueryPattern {

    // mua chung cư giá 1 tỷ tại linh đàm
    private static final String SINGLE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(t[yỷ]?)";
    private static final Pattern SINGLE_PRICE_BI_PATTERN = Pattern.compile(SINGLE_PRICE_BI);

    // mua chung cư giá 1-2 tỷ tại linh đàm, 1 2 tỷ, 1 - 2 t, 1.5 - 2.5 ty
//    private static final String RANGE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final String RANGE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern RANGE_PRICE_BI_PATTERN = Pattern.compile(RANGE_PRICE_BI);

    // mua nha rieng gia 500 trieu
    private static final String SINGLE_PRICE_MI = "(?i)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    private static final Pattern SINGLE_PRICE_MI_PATTERN = Pattern.compile(SINGLE_PRICE_MI);

    // mua nha rieng gia 500 - 900 trieu
    private static final String RANGE_PRICE_MI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(tr(i[eêệ]u)?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    private static final Pattern RANGE_PRICE_MI_PATTERN = Pattern.compile(RANGE_PRICE_MI);

    // mua nha rieng gia 900 trieu - 2 ty
    private static final String RANGE_PRICE_MI_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(tr(i[eêệ]u)?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern RANGE_PRICE_MI_BI_PATTERN = Pattern.compile(RANGE_PRICE_MI_BI);

    // many cases
    private static final String RANGE_PRICE_BMB_1 = ""; // 1 ty 2 den 2 ty
    private static final String RANGE_PRICE_BMB_2 = ""; // 1 ty 200 trieu den 2
    private static final String RANGE_PRICE_BMB_3 = ""; // 1 ty 200 trieu den 2 ty 2
    private static final String RANGE_PRICE_BMB_4 = ""; // 1 ty 2 den 2 ty 200 trieu
    private static final String RANGE_PRICE_BMBM_1 = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern RANGE_PRICE_BMBM_PATTERN_1 = Pattern.compile(RANGE_PRICE_BMBM_1);
    private static final String RANGE_PRICE_BMBM_2 = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern RANGE_PRICE_BMBM_PATTERN_2 = Pattern.compile(RANGE_PRICE_BMBM_2);

    // < or dưới, nhỏ hơn
    private static final String LESS_THAN_PRICE_BI = "(?i)(\\s*(<|(nh[oỏ]\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern LESS_THAN_PRICE_BI_PATTERN = Pattern.compile(LESS_THAN_PRICE_BI);
    private static final String LESS_THAN_PRICE_MI = "(?i)(\\s*(<|(nh[oỏ]\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    private static final Pattern LESS_THAN_PRICE_MI_PATTERN = Pattern.compile(LESS_THAN_PRICE_MI);

    // > or trên, lớn hơn
    private static final String GREATER_THAN_PRICE_BI = "(?i)(\\s*(>|(l[oơớ]n\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    private static final Pattern GREATER_THAN_PRICE_BI_PATTERN = Pattern.compile(GREATER_THAN_PRICE_BI);
    private static final String GREATER_THAN_PRICE_MI = "(?i)(\\s*(>|(l[oơớ]n\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    private static final Pattern GREATER_THAN_PRICE_MI_PATTERN = Pattern.compile(GREATER_THAN_PRICE_MI);

    private static final String SINGLE_AREA = "";
    private static final Pattern SINGLE_AREA_PATTERN = Pattern.compile("");
    private static final String RANGE_AREA = "";
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
            "mua nha rieng 5.3 ty",
            "mua nha rieng gia khoang 7 ty",
            "mua chung cu gia khoang 2.5 ty"
    };

    private static String rangePrice = "mua chung cư giá 1.5-2.25 tỷ tại linh đàm";
    // test range price billion
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
            "mua chung cu gia .25t-.3t tai linh dam",
            "mua chung cu gia 1t-2t",
            "mua chung cu gia 1.2tỷ-2.8tỷ",
            "1.2 tỷ 2.8 tỷ",
            "1.2 ty 2.3 ty",
            "1.2 ty , 2.4 t",
            "2.3 tỷ đến 3.0 tỷ",
            "2.3 tỷ den 4.5 ty",
            ".5 t dến 3t",
            "1 ty den 2 tỷ",
            "1 ty 2 den 2 ty 3",
            "1 tỷ  200 triệu đến  2 tỷ 200 triệu",
            "2 tỷ 2 đến 2 tỷ 4"
    };
    // test range price million
    private static String[] rangesMi = {
            "100-200trieu",
            "100-200.5tr",
            "100.33-300triệu",
            "mua căn hộ 500 - 900 trieu",
            "mua can ho 400- 900 tr",
            "mua chung cư 550 - 999.99 triệu",
            "500 trieu - 800 trieu"
    };

    //test range price from million to billion
    private static String[] rangeMiBi = {
            "500 trieu - 1 ty"
    };

    // test range price less than
    private static String[] lessThanBi = {
            " < 100 t",
            " < 10 ty",
            " < 10.1 tỷ",
            " dưới 5.5 tỷ",
            " nhỏ hơn .89 tỷ",
            "  nho hon 34 t",
            " nho hon 23 ty"
    };

    private static String[] greaterThanBi = {
            " > 100 t jfjfjfjg",
            " > 10 ty",
            " > 10.1 tỷ",
            " trên 5.5 tỷ",
            " lớn hơn .89 tỷ",
            "  lon hon 34 t",
            " lon hon 23 ty"
    };

    public static void main(String[] args) {
//        for (int i = 0; i < rangePrices.length; ++i) {
//            System.out.println(i + " -----------------");
//            matchRangePriceBi(rangePrices[i]);
//        }
//        for (int i = 0; i < singlePrices.length; ++i) {
//            System.out.println(i + " -----------------");
//            matchSinglePrice(singlePrices[i]);
//        }
//        for (int i = 0; i < rangesMi.length; ++i) {
//            System.out.println(i + " -----------------Mi");
//            matchRangePriceMi(rangesMi[i]);
//        }
//        for (int i = 0; i < lessThanBi.length; ++i) {
//            System.out.println(i + " -------------------");
//            lessThanBi(lessThanBi[i]);
//        }
        for (int i = 0; i < greaterThanBi.length; ++i) {
            System.out.println(i + " ---------------------");
            greaterThanBi(greaterThanBi[i]);
        }
    }

    private static boolean isMatch(String regex, String s) {
        return s.matches(regex);
    }

    private static void matchRangePriceBi(String s) {
        Matcher m = RANGE_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(count - 1));
        }
    }

    private static void matchSinglePriceBi(String s) {
        Matcher m = SINGLE_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

    private static void matchSinglePriceMi(String s) {

    }

    private static void matchRangePriceMi(String s) {
        Matcher m = RANGE_PRICE_MI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(count - 1));
        }
    }

    private static void lessThanBi(String s) {
        Matcher m = LESS_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

    private static void greaterThanBi(String s) {
        Matcher m = GREATER_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

}
