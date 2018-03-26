package lucene;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanh on 27/03/2018.
 */
public class DataConfig {

    public List<RealEstate> getData(String filePath) {
        System.out.println("getData");
        List<JSONObject> results = readData(filePath);
        List<RealEstate> data = new ArrayList<>();
        for (JSONObject obj: results) {
            JSONObject sellAddress = (JSONObject) obj.get("sell_address");
            String district = (String) sellAddress.get("district");
            String province = (String) sellAddress.get("province");
            String contactAddress = (String) ((JSONObject) obj.get("contact")).get("address");
            String title = (String) obj.get("title");
            String categoryName = (String) ((JSONObject) obj.get("category")).get("name");
            JSONObject prj = (JSONObject) obj.get("project");
            String projectName = null, projectInvestor = null, projectSize = null;
            if (prj != null) {
                 projectName = (String) prj.get("name");
                 projectInvestor = (String) prj.get("investor");
                 projectSize = (String) prj.get("size");
            }
            String address = (String) obj.get("address");
            String description = (String) obj.get("description");
            RealEstate realEstate = new RealEstate(district, province, contactAddress, title, categoryName, projectName, projectInvestor, projectSize, address, description);
            data.add(realEstate);
        }
        System.out.println("done getData");
        return data;
    }

//    private List<JSONObject> getData(String filePath) {
//        List<JSONObject> result = readData(filePath);
//        int size = result.size();
//        for (int i = 0; i < size; ++i) {
//            JSONObject obj = result.get(i);
//            obj.put("id", obj.get("_id"));
//            obj.remove("_id");
//        }
//        return result;
//    }

    private List<JSONObject> readData(String filePath) {
        List<JSONObject> resultList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(filePath);
            JSONArray a = (JSONArray) parser.parse(reader);
            for (Object o : a) {
                resultList.add((JSONObject) o);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultList;
    }


}
