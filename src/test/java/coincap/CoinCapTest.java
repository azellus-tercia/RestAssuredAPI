package coincap;

import coincap.BaseClasses.JsonFormat;
import com.google.gson.Gson;
import io.restassured.RestAssured;

public class CoinCapTest {

    public static void main(String[] args) {
        Gson g = new Gson();
        JsonFormat jsonFormat = g.fromJson(RestAssured.get("https://api.coincap.io/v2/assets?limit=1").asString(), JsonFormat.class);
        System.out.println(jsonFormat.data.get(0).name);
    }
}
