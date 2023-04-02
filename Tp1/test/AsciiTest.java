import org.testng.Assert;
import org.testng.annotations.Test;

public class AsciiTest {

    private final Ascii ascii = new Ascii();

    @Test
    public void testEncode(){
        Assert.assertEquals(ascii.encode("1001001"),"I");
        Assert.assertEquals(ascii.encode("011010101001011001101"),"5%M");
        Assert.assertEquals(ascii.encode("001101110010110011010"), "\u001BK\u001A");
    }

    @Test
    public void testDecode(){
        Assert.assertEquals(ascii.decode("I"),"1001001 ");
        Assert.assertEquals(ascii.decode("5%M"),"0110101 0100101 1001101 ");
        Assert.assertEquals(ascii.decode("\u001BK\u001A"), "0011011 1001011 0011010 ");
    }

}
