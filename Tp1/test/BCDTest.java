import org.testng.Assert;
import org.testng.annotations.Test;

public class BCDTest {

    private final BCD bcd = new BCD();

    @Test
    public void testEncode(){
        Assert.assertEquals(bcd.encode(420), "010000100000");
        Assert.assertEquals(bcd.encode(1), "0001");
        Assert.assertEquals(bcd.encode(7580), "0111010110000000");
    }

    @Test public void testDecode(){
        Assert.assertEquals(bcd.decode("010000100000"),420 );
        Assert.assertEquals(bcd.decode("0001"), 1);
        Assert.assertEquals(bcd.decode("0111010110000000"), 7580);
    }
}
