package rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by khanh on 05/04/2018.
 */
public final class QueryPattern {

    public QueryPattern() {}

    // mua chung cư giá 1 tỷ tại linh đàm
    public static final String SINGLE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(t[yỷ]?)";
    public static final Pattern SINGLE_PRICE_BI_PATTERN = Pattern.compile(SINGLE_PRICE_BI);

    // mua chung cư giá 1-2 tỷ tại linh đàm, 1 2 tỷ, 1 - 2 t, 1.5 - 2.5 ty
//    public static final String RANGE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final String RANGE_PRICE_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern RANGE_PRICE_BI_PATTERN = Pattern.compile(RANGE_PRICE_BI);

    // mua nha rieng gia 500 trieu
    public static final String SINGLE_PRICE_MI = "(?i)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    public static final Pattern SINGLE_PRICE_MI_PATTERN = Pattern.compile(SINGLE_PRICE_MI);

    // mua nha rieng gia 500 - 900 trieu
    public static final String RANGE_PRICE_MI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(tr(i[eêệ]u)?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    public static final Pattern RANGE_PRICE_MI_PATTERN = Pattern.compile(RANGE_PRICE_MI);

    // mua nha rieng gia 900 trieu - 2 ty
    public static final String RANGE_PRICE_MI_BI = "(?i)((?:\\d*\\.)?\\d+)(\\s*(tr(i[eêệ]u)?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern RANGE_PRICE_MI_BI_PATTERN = Pattern.compile(RANGE_PRICE_MI_BI);

    // many cases
    public static final String RANGE_PRICE_BMB_1 = ""; // 1 ty 2 den 2 ty
    public static final String RANGE_PRICE_BMB_2 = ""; // 1 ty 200 trieu den 2
    public static final String RANGE_PRICE_BMB_3 = ""; // 1 ty 200 trieu den 2 ty 2
    public static final String RANGE_PRICE_BMB_4 = ""; // 1 ty 2 den 2 ty 200 trieu
    public static final String RANGE_PRICE_BMBM_1 = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern RANGE_PRICE_BMBM_PATTERN_1 = Pattern.compile(RANGE_PRICE_BMBM_1);
    public static final String RANGE_PRICE_BMBM_2 = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[yỷ]?)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern RANGE_PRICE_BMBM_PATTERN_2 = Pattern.compile(RANGE_PRICE_BMBM_2);

    // < , dưới, nhỏ hơn
    public static final String LESS_THAN_PRICE_BI = "(?i)(\\s*(<|((nh[oỏ]|th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern LESS_THAN_PRICE_BI_PATTERN = Pattern.compile(LESS_THAN_PRICE_BI);
    public static final String LESS_THAN_PRICE_MI = "(?i)(\\s*(<|((nh[oỏ]||th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    public static final Pattern LESS_THAN_PRICE_MI_PATTERN = Pattern.compile(LESS_THAN_PRICE_MI);

    // > , trên, lớn hơn
    public static final String GREATER_THAN_PRICE_BI = "(?i)(\\s*(>|((l[oơớ]n|cao)\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(\\s*t[yỷ]?)";
    public static final Pattern GREATER_THAN_PRICE_BI_PATTERN = Pattern.compile(GREATER_THAN_PRICE_BI);
    public static final String GREATER_THAN_PRICE_MI = "(?i)(\\s*(>|(l[oơớ]n|cao\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(\\s*tr(?:i[eêệ]u)?)";
    public static final Pattern GREATER_THAN_PRICE_MI_PATTERN = Pattern.compile(GREATER_THAN_PRICE_MI);

    public static final String SINGLE_AREA = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(m2|m\\^2)";
    public static final Pattern SINGLE_AREA_PATTERN = Pattern.compile(SINGLE_AREA);
    public static final String RANGE_AREA = "(?i)((?:\\d*\\.)?\\d+)(\\s*(m2|m\\^2)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*(?:m2|m\\^2))";
    public static final Pattern RANGE_AREA_PATTERN = Pattern.compile(RANGE_AREA);
    public static final String LESS_THAN_AREA = "(?i)(\\s*(<|((nh[oỏ]|th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(m2|m\\^2)";
    public static final Pattern LESS_THAN_AREA_PATTERN = Pattern.compile(LESS_THAN_AREA);
    public static final String GREATER_THAN_AREA = "(?i)(\\s*(>|((l[oơớ]n|cao)\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(m2|m\\^2)";
    public static final Pattern GREATER_THAN_AREA_PATTERN = Pattern.compile(GREATER_THAN_AREA);

    // số phòng ngủ/pn
    public static final String SINGlE_BEDROOM = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(pn|ph[oò]ng\\s+ng[uủ])";
    public static final Pattern SINGLE_BEDROOM_PATTERN = Pattern.compile(SINGlE_BEDROOM);
    public static final String RANGE_BEDROOM = "(?i)((?:\\d*\\.)?\\d+)(\\s*(pn|ph[oò]ng\\s+ng[uủ])?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*(?:pn|ph[oò]ng\\s+ng[uủ]))";
    public static final Pattern RANGE_BEDROOM_PATTERN = Pattern.compile(RANGE_BEDROOM);
    public static final String LESS_THAN_BEDROOM = "(?i)(\\s*(<|((nh[oỏ]|th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(pn|ph[oò]ng\\s+ng[uủ])";
    public static final Pattern LESS_THAN_BEDROOM_PATTERN = Pattern.compile(LESS_THAN_BEDROOM);
    public static final String GREATER_THAN_BEDROOM = "(?i)(\\s*(>|((l[oơớ]n|cao)\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(pn|ph[oò]ng\\s+ng[uủ])";
    public static final Pattern GREATER_THAN_BEDROOM_PATTERN = Pattern.compile(GREATER_THAN_BEDROOM);

    // số toilet/vs/vệ sinh
    public static final String SINGlE_TOILET = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(vs|v[eệ]\\s+sinh|toilet)";
    public static final Pattern SINGLE_TOILET_PATTERN = Pattern.compile(SINGlE_TOILET);
    public static final String RANGE_TOILET = "(?i)((?:\\d*\\.)?\\d+)(\\s*(vs|v[eệ]\\s+sinh|toilet)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*(?:vs|v[eệ]\\s+sinh|toilet))";
    public static final Pattern RANGE_TOILET_PATTERN = Pattern.compile(RANGE_TOILET);
    public static final String LESS_THAN_TOILET = "(?i)(\\s*(<|((nh[oỏ]|th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(vs|v[eệ]\\s+sinh|toilet)";
    public static final Pattern LESS_THAN_TOILET_PATTERN = Pattern.compile(LESS_THAN_TOILET);
    public static final String GREATER_THAN_TOILET = "(?i)(\\s*(>|((l[oơớ]n|cao)\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(vs|v[eệ]\\s+sinh|toilet)";
    public static final Pattern GREATER_THAN_TOILET_PATTERN = Pattern.compile(GREATER_THAN_TOILET);

    // số tầng (mua nhà riêng)
    public static final String SINGlE_FLOOR = "(?i)((?:\\d*\\.)?\\d+)(\\s*)(t[aâầ]ng)";
    public static final Pattern SINGLE_FLOOR_PATTERN = Pattern.compile(SINGlE_FLOOR);
    public static final String RANGE_FLOOR = "(?i)((?:\\d*\\.)?\\d+)(\\s*(t[aâầ]ng)?\\s*)([\\s-,_]|([dđ][eêế]n))(\\s*)((?:\\d*\\.)?\\d+)(\\s*(?:t[aâầ]ng))";
    public static final Pattern RANGE_FLOOR_PATTERN = Pattern.compile(RANGE_FLOOR);
    public static final String LESS_THAN_FLOOR = "(?i)(\\s*(<|((nh[oỏ]|th[aáâấ]p)\\s+h[oơ]n)|(d[uưứ][oơớ]i))\\s*)((?:\\d*\\.)?\\d+)(t[aâầ]ng)";
    public static final Pattern LESS_THAN_FLOOR_PATTERN = Pattern.compile(LESS_THAN_FLOOR);
    public static final String GREATER_THAN_FLOOR = "(?i)(\\s*(>|((l[oơớ]n|cao)\\s+h[oơ]n)|(tr[eê]n))\\s*)((?:\\d*\\.)?\\d+)(t[aâầ]ng)";
    public static final Pattern GREATER_THAN_FLOOR_PATTERN = Pattern.compile(GREATER_THAN_FLOOR);

    // test single Price
    public static String[] singlePrices = {
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

    public static String rangePrice = "mua chung cư giá 1.5-2.25 tỷ tại linh đàm";
    // test range price billion
    public static String[] rangePrices = {
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
    public static String[] rangesMi = {
            "100-200trieu",
            "100-200.5tr",
            "100.33-300triệu",
            "mua căn hộ 500 - 900 trieu",
            "mua can ho 400- 900 tr",
            "mua chung cư 550 - 999.99 triệu",
            "500 trieu - 800 trieu"
    };

    //test range price from million to billion
    public static String[] rangeMiBi = {
            "500 trieu - 1 ty"
    };

    // test range price less than
    public static String[] lessThanBi = {
            " < 100 t",
            " < 10 ty",
            " < 10.1 tỷ",
            " dưới 5.5 tỷ",
            " nhỏ hơn .89 tỷ",
            "  nho hon 34 t",
            " nho hon 23 ty",
            " thap hon 22.2 tỷ",
            " thấp hơn 2ty",
            " tháp hơn 2t",
            " cao hon 2ty"
    };

    public static String[] greaterThanBi = {
            " > 100 t jfjfjfjg",
            " > 10 ty",
            " > 10.1 tỷ",
            " trên 5.5 tỷ",
            " lớn hơn .89 tỷ",
            "  lon hon 34 t",
            " lon hon 23 ty",
            " cao hơn 2tỷ",
            " cao hơn 2t",
            " cao hon 2.2 ty"
    };

    public static String[] lessThanMi = {
            " < 100 tr",
            " < 10 trieu",
            " < 10.1 triệu",
            " dưới 5.5 triệu",
            " nhỏ hơn .89 triệu",
            "  nho hon 34 tr",
            " nho hon 23 trieu"
    };

    public static String[] greaterThanMi = {
            " > 100 tr jfjfjfjg",
            " > 10 trieu",
            " > 10.1 triệu",
            " trên 5.5 triệu",
            " lớn hơn .89 triệu",
            "  lon hon 34 tr",
            " lon hon 23 trieu"
    };

    public static String[] singleArea = {
            " mua can ho .100 m2",
            " mua can ho 200.2 m^2",
            " mua chung cu dien tich 120m2",
            " mua căn hộ chung cư diện tích 100 m2"
    };

    public static String[] rangeArea = {
            "mua nhà riêng diện tích 60 - 100 m2 có 2 phòng ngủ",
            " mua căn hộ giá diện tích khoảng 50 - 80m2",
            "mua chung cư diện tích khoảng 25.5m^2-199m^2",
            "mua chung cư diện tích 40 m2 - 60 m2",
            "mua chung cư giá khoảng 40 m^2 - 70 m^2",
            "mua nhà riêng diện tích khoảng 40m2-60m2"
    };

    public static String[] lessThanArea = {

    };

    public static String[] greaterThanArea = {

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
//        for (int i = 0; i < greaterThanBi.length; ++i) {
//            System.out.println(i + " ---------------------");
//            greaterThanBi(greaterThanBi[i]);
//        }
//        for (int i = 0; i < singleArea.length; ++i) {
//            System.out.println(i + " -----------------------");
//            matchSingleArea(singleArea[i]);
//        }
        for (int i = 0; i < rangeArea.length; ++i) {
            System.out.println(i + " -----------------------");
            matchRangeArea(rangeArea[i]);
        }
    }

    public static boolean isMatch(String regex, String s) {
        return s.matches(regex);
    }

    public static void matchRangePriceBi(String s) {
        Matcher m = RANGE_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(count - 1));
        }
    }

    public static void matchSinglePriceBi(String s) {
        Matcher m = SINGLE_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

    public static void matchSinglePriceMi(String s) {

    }

    public static void matchRangePriceMi(String s) {
        Matcher m = RANGE_PRICE_MI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(count - 1));
        }
    }

    public static void lessThanBi(String s) {
        Matcher m = LESS_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

    public static void greaterThanBi(String s) {
        Matcher m = GREATER_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

    public static void lessThanMi(String s) {
        Matcher m = LESS_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

    public static void greaterThanMi(String s) {
        Matcher m = GREATER_THAN_PRICE_BI_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group(count - 1));
        }
    }

    public static void matchSingleArea(String s) {
        Matcher m = SINGLE_AREA_PATTERN.matcher(s);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }

    public static void matchRangeArea(String s) {
        Matcher m = RANGE_AREA_PATTERN.matcher(s);
        if (m.find()) {
            int count = m.groupCount();
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(count - 1));
        }
    }

}
