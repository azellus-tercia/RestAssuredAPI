package instatus;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseRunner;

public class InstatusAPITest extends BaseRunner {

    @Test
    public void testGetResponse() {
        boolean isNotNull = responseGET("/v1/pages") != null;

        Assert.assertTrue(isNotNull);
    }

    @Test
    public void testNegativeCI() {
        int x = 5;

        Assert.assertTrue(x == 6);
    }
}
