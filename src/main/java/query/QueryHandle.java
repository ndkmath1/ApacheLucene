package query;

import org.json.simple.JSONObject;
import rule.QueryData;
import rule.QueryParser;

import javax.management.Query;

/**
 * Created by khanh on 19/04/2018.
 */
public class QueryHandle {

    public static JSONObject handle(String query) {
        JSONObject result = new JSONObject();
        QueryData<Float> etPrice = QueryParser.extractPrice(query);
        QueryData<Float> etArea = QueryParser.extractArea(query);
        QueryData<Integer> etBedroom = QueryParser.extractBedroom(query);
        QueryData<Integer> etFloor = QueryParser.extractFloor(query);
        QueryData<Integer> etToilet = QueryParser.extractToilet(query);
        return result;
    }

    private void handlePrice() {

    }



}
