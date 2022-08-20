import instatus.StatusPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusPageTest {

    @Test
    public void testGetResponse() {
        boolean isNotNull = new StatusPage()
                .isResponseReceived();

        Assert.assertTrue(isNotNull);
    }

    @Test
    public void testCollections() {
        String response = new StatusPage()
                .getResponseId();

        Assert.assertEquals(response, "cl707fbr51651b7n1i9sqmkl8");
    }

    @Test
    public void testAssertInChain() {
        new StatusPage()
                .assertEquals(StatusPage::getResponseId, "cl707fbr51651b7n1i9sqmkl8");
    }

    @Test void testAssertInChainSubdomain() {
        new StatusPage()
                .assertEquals(StatusPage::isResponseReceived, true)
                .assertEquals(StatusPage::getResponseSubdomain, "spaceya");
    }
}
