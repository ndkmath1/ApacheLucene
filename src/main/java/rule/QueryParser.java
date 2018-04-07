package rule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by khanh on 07/04/2018.
 */
public class QueryParser {

    /**
     * Extract price, area, room information, ... from a query
     * @param query a query string
     */
    public static void parse(String query) {
        
    }

    /**
     * How to get address in a query string?
     * @param query
     */
    private static void extractAddress(String query) {

    }

    /**
     *
     * @param query
     * @return 0 double number if do not have price, one double number (single price), two double number (range price)
     */
    private static List<Float> extractPrice(String query) {
        List<Float> result = new ArrayList<>();
        Matcher m = QueryPattern.RANGE_PRICE_BI_PATTERN.matcher(query);
        if (m.find()) {
            int count = m.groupCount();
            result.add(Float.parseFloat(m.group(1)));
            result.add(Float.parseFloat(m.group(count - 1)));
            return result;
        }
        m = QueryPattern.RANGE_PRICE_MI_PATTERN.matcher(query);
        if (m.find()) {
            int count = m.groupCount();
            float r1 = Float.parseFloat(m.group(1)) / Constants.BIL_TO_MIL;
            result.add(r1);
            float r2 = Float.parseFloat(m.group(count - 1)) / Constants.BIL_TO_MIL;
            result.add(r2);
            return result;
        }
        m = QueryPattern.RANGE_PRICE_MI_BI_PATTERN.matcher(query);
        if (m.find()) {
            int count = m.groupCount();
            float r1 = Float.parseFloat(m.group(1)) / Constants.BIL_TO_MIL;
            result.add(r1);
            float r2 = Float.parseFloat(m.group(count - 1));
            result.add(r2);
            return result;
        }
        m = QueryPattern.SINGLE_PRICE_BI_PATTERN.matcher(query);
        if (m.find()) {

        }
        m = QueryPattern.SINGLE_PRICE_MI_PATTERN.matcher(query);
        if (m.find()) {

        }
        return result;
    }

    private static void extractArea(String query) {

    }

    private static void extractBedroom(String query) {

    }

    private static void extractToilet(String query) {

    }

    private static void extractFloor(String query) {

    }

}
