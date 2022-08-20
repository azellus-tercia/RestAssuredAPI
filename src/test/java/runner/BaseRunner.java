package runner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.Function;

public abstract class BaseRunner<Self extends BaseRunner<?>> {

    public static Response responseGET(String payload) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + BaseProperties.getProperties().getProperty("token"))
                .get(String.format("https://api.instatus.com%s", payload));
    }

    public static Gson getGson() {
        return BaseProperties.getGson();
    }

    public static Type getCollectionsType(Class<?> typeClass) {
        return TypeToken.getParameterized(List.class, typeClass).getType();
    }

    public <Value> Self assertEquals(Function<Self, Value> actual, Value expected) {
        Assert.assertEquals(actual.apply((Self)this), expected);

        return (Self)this;
    }
}
