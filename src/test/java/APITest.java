import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseRunner;

public class APITest extends BaseRunner {

    @Test
    public void testGetResponseHello() {
        Assert.assertTrue(RestAssured.get(getPageAPI("hello")).getBody().asString().contains("word"));
    }

    @Test
    public void testResponseContainsSourceURL() {
        Assert.assertTrue(RestAssured.get(getPageAPI("hello")).getBody().asString().contains("sourceUrl"));
    }

    @Test
    public void testCheckWorkFlow() {
        int x = 5;
        Assert.assertEquals(x, 7);

    }
}
