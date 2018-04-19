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
     * Extract price data from a query string
     * @param query
     * @return
     */
    public static QueryData<Float> extractPrice(String query) {
        try {
            List<Float> result = new ArrayList<>();
            Matcher m = QueryPattern.RANGE_PRICE_MI_MET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r1 = Float.parseFloat(m.group(1).replace(',', '.'));
                result.add(r1);
                float r2 = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r2);
                return new QueryData<>(result, QueryType.RANGE_MIL_MET);
            }
            m = QueryPattern.LESS_THAN_PRICE_MI_MET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN_MI_MET);
            }
            m = QueryPattern.GREATER_THAN_PRICE_MI_MET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN_MI_MET);
            }
            m = QueryPattern.SINGLE_PRICE_MI_MET_PATTERN.matcher(query);
            if (m.find()) {
                float r = Float.parseFloat(m.group(1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.SINGLE_MIL_MET);
            }
            m = QueryPattern.RANGE_PRICE_BI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                result.add(Float.parseFloat(m.group(1).replace(',', '.')));
                result.add(Float.parseFloat(m.group(count - 1).replace(',', '.')));
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.RANGE_PRICE_MI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r1 = Float.parseFloat(m.group(1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r1);
                float r2 = Float.parseFloat(m.group(count - 1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r2);
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.RANGE_PRICE_MI_BI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r1 = Float.parseFloat(m.group(1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r1);
                float r2 = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r2);
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.LESS_THAN_PRICE_BI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_PRICE_BI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.LESS_THAN_PRICE_MI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_PRICE_MI_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.SINGLE_PRICE_BI_PATTERN.matcher(query);
            if (m.find()) {
                result.add(Float.parseFloat(m.group(1).replace(',', '.')));
                return new QueryData<>(result, QueryType.SINGLE);
            }
            m = QueryPattern.SINGLE_PRICE_MI_PATTERN.matcher(query);
            if (m.find()) {
                float r = Float.parseFloat(m.group(1).replace(',', '.')) / Constants.BIL_TO_MIL;
                result.add(r);
                return new QueryData<>(result, QueryType.SINGLE);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static QueryData<Float> extractArea(String query) {
        try {
            List<Float> result = new ArrayList<>();
            Matcher m = QueryPattern.RANGE_AREA_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                result.add(Float.parseFloat(m.group(1).replace(',', '.')));
                result.add(Float.parseFloat(m.group(count - 1).replace(',', '.')));
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.LESS_THAN_AREA_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_AREA_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                float r = Float.parseFloat(m.group(count - 1).replace(',', '.'));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.SINGLE_AREA_PATTERN.matcher(query);
            if (m.find()) {
                result.add(Float.parseFloat(m.group(1).replace(',', '.')));
                return new QueryData<>(result, QueryType.SINGLE);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static QueryData<Integer> extractBedroom(String query) {
        try {
            List<Integer> result = new ArrayList<>();
            Matcher m = QueryPattern.RANGE_BEDROOM_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                result.add(Integer.parseInt(m.group(1)));
                result.add(Integer.parseInt(m.group(count - 1)));
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.LESS_THAN_BEDROOM_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_BEDROOM_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.SINGLE_BEDROOM_PATTERN.matcher(query);
            if (m.find()) {
                result.add(Integer.parseInt(m.group(1)));
                return new QueryData<>(result, QueryType.SINGLE);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static QueryData<Integer> extractToilet(String query) {
        try {
            List<Integer> result = new ArrayList<>();
            Matcher m = QueryPattern.RANGE_TOILET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                result.add(Integer.parseInt(m.group(1)));
                result.add(Integer.parseInt(m.group(count - 1)));
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.LESS_THAN_TOILET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_TOILET_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.SINGLE_TOILET_PATTERN.matcher(query);
            if (m.find()) {
                result.add(Integer.parseInt(m.group(1)));
                return new QueryData<>(result, QueryType.SINGLE);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static QueryData<Integer> extractFloor(String query) {
        try {
            List<Integer> result = new ArrayList<>();
            Matcher m = QueryPattern.RANGE_FLOOR_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                result.add(Integer.parseInt(m.group(1)));
                result.add(Integer.parseInt(m.group(count - 1)));
                return new QueryData<>(result, QueryType.RANGE);
            }
            m = QueryPattern.LESS_THAN_FLOOR_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.LESS_THAN);
            }
            m = QueryPattern.GREATER_THAN_FLOOR_PATTERN.matcher(query);
            if (m.find()) {
                int count = m.groupCount();
                int r = Integer.parseInt(m.group(count - 1));
                result.add(r);
                return new QueryData<>(result, QueryType.GREATER_THAN);
            }
            m = QueryPattern.SINGLE_FLOOR_PATTERN.matcher(query);
            if (m.find()) {
                result.add(Integer.parseInt(m.group(1)));
                return new QueryData<>(result, QueryType.SINGLE);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
//        String q = " mua nha rieng gia 1-2 ty dien tich 20-30m2 co 3-4 phong ngu 7 vs 5-6 tang";
//        String q = " mua nha rieng gia 1.3-2,5 ty dien tich 20,33 -30.33 m2 co 3-40 phong ngu 7 vs 5-6 tang";
        String q = "nhà riêng >= 32trieu/m2 giá nho hon 2 tỷ 2pn 3vs tại linh đàm";

        long t1 = System.currentTimeMillis();
        System.out.println("Price--------------");
        QueryData r = extractPrice(q);
        print(r);
        System.out.println("Area--------------");
        r = extractArea(q);
        print(r);
        System.out.println("Bedroom--------------");
        r = extractBedroom(q);
        print(r);
        System.out.println("Toilet--------------");
        r = extractToilet(q);
        print(r);
        System.out.println("Floor--------------");
        r = extractFloor(q);
        print(r);
        long t2 = System.currentTimeMillis();
        System.out.printf("extract time: %d", t2 - t1);
    }

    private static void print(QueryData r) {
        if (r == null) {
            return;
        }
        System.out.println(r.getType());
        for (Object f: r.getList()) {
            System.out.println(f);
        }
    }

}
