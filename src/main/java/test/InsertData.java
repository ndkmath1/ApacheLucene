package test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
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
 * Created by khanh on 22/03/2018.
 */
public class InsertData {

    public static void main(String[] args) {
//        String filePath = "src/resources/sell_detail.json";
//        List<JSONObject> result = getData(filePath);
////        JSONObject jsonObject = result.get(0);
//        int size = result.size();
//        for (int i = 0; i < size; ++i) {
//            JSONObject obj = result.get(i);
//            obj.put("id", obj.get("_id"));
//            obj.remove("_id");
//            System.out.println(i + ": " + obj.toJSONString());
//            sendRequest(obj);
//        }
////        httpUrl();
        sendRequest(createJSON());
    }

    public static List<JSONObject> getData(String filePath) {
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

    private static void httpUrl() {
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
        try {
            HttpPost request = new HttpPost("http://localhost:9200/icu_vi_sample/test");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", "User 1");
            jsonObject.put("introduce", "Introduce 1");
            System.out.println(jsonObject.toJSONString());
            StringEntity params = new StringEntity(jsonObject.toJSONString());
//            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            request.getRequestLine();
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            System.out.println("response: " + response);
        } catch (Exception ex) {

        } finally {

        }
    }

    private static JSONObject createJSON() {
        JSONObject body = new JSONObject();
        String s = "- Bạn mới lập gia đình.\n" +
                "- Bạn cần tìm một căn hộ vừa túi tiền.\n" +
                "- Bạn đang tìm 1 căn hộ thuận tiện cho con đi học.\n" +
                "- Bạn đang tìm 1 căn hộ thuận tiện giao thông, gần khu trung tâm.\n" +
                "\n" +
                "Hãy liên hệ với tôi ngay để được xem nhà. Chị Hà: 0972.628.188.\n" +
                "\n" +
                "Do các con tôi đã lớn vì vậy gia đình phải chuyển đến ở căn hộ 3 phòng ngủ, chúng tôi rất tiếc phải bán lại căn hộ tầng 4, tòa 11 tầng chung cư An Lạc - Mỹ Đình.\n" +
                "\n" +
                "Nhà ở rất thoáng mát, hành lang trước nhà rộng, trẻ em có thể vui chơi. Chung cư nằm tại khu vực giao thông thuận tiện, dân trí tốt, gần trường học và bệnh viện:\n" +
                "- Phía sau là trường Việt Úc, gần Trường Lê Quý Đôn, Đoàn Thị Điểm.\n" +
                "- Gần bệnh viện 198.\n" +
                "\n" +
                "Đặc điểm căn hộ:\n" +
                "- Diện tích: 83,5 m2 hướng cửa Đông Bắc, hướng ban công Tây Nam.\n" +
                "- Nhà có 2 phòng ngủ, 1 phòng khách, 2 nhà vệ sinh, 2 ban công.\n" +
                "- Sổ đỏ chính chủ.\n" +
                "- Nội thất cơ bản gồm bình nóng lạnh, bếp.\n" +
                "\n" +
                "Tôi bán với giá 1.8 tỷ có gia lộc cho bạn nào có thiện chí, mua bán nhanh gọn.\n" +
                "\n" +
                "Liên hệ: Chị Hà: 0972.628.188. ";
        String t = s;
        for (int i = 0; i < 10; ++i) {
            s += t;
        }
        body.put("analyzer", "my_analyzer");
        body.put("text", s);
        return body;
    }

    private static void sendRequest(JSONObject body) {
        HttpClient httpClient = HttpClientBuilder.create().build(); //Use this instead
        try {
            HttpPost request = new HttpPost("http://localhost:9200/real_estate/_analyze");
//            JSONObject obj = new JSONObject();
//            obj.put("area", body.get("area"));
//            obj.put("begin_date", body.get("begin_date").toString());
//            JSONObject pj = (JSONObject) body.get("project");
//            JSONObject prj = new JSONObject();
//            prj.put("name",  pj.get("name"));
//            prj.put("size", pj.get("size"));
//            prj.put("investor", pj.get("investor"));
//            obj.put("project", prj);
//            obj.put("description", body.get("description"));
//            System.out.println("obj: " + obj.toJSONString());
            StringEntity params = new StringEntity(body.toJSONString(), ContentType.APPLICATION_JSON);
//            StringEntity params = new StringEntity(obj.toJSONString(), "UTF-8");
//            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            request.getRequestLine();
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            System.out.println("response: " + EntityUtils.toString(response.getEntity()));
        } catch (Exception ex) {

        } finally {

        }


    }

}
