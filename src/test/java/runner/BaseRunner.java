package runner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseRunner {
    private final String pageAPI = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    protected String getPageAPI(String word) {
        return pageAPI + word;
    }

    public static Response responseGET(String payload) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseProperties.getProperties().getProperty("token"))
                .get(String.format("https://api.instatus.com%s", payload));
    }
}
