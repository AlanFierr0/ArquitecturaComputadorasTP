

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testSumBinary(){
        testSumBinaryEqualLengthString();
        testSumBinaryFirstLongerLengthString();
        testSumBinarySecondLongerLengthString();
    }

    @Test
    public void testSubBinary(){
        testSubBinaryEqualLengthString();
        testSubBinaryFirstLongerLengthString();
        testSubBinarySecondLongerLengthString();
    }

    @Test
    public void testMult(){
        testMultEqualLengthString();
        testMultFirstLongerLengthString();
        testMultSecondLongerLengthString();
    }

    @Test
    public void testToHex(){
        Assert.assertEquals(calculator.toHex("10011010"), "9A");
        Assert.assertEquals(calculator.toHex("100101"),"25");
        Assert.assertEquals(calculator.toHex("10010110101101"),"25AD");
    }

    @Test
    public void testFromHex(){
        Assert.assertEquals(calculator.fromHex("9A"), "10011010");
        Assert.assertEquals(calculator.fromHex("23DF"),"10001111011111");
        Assert.assertEquals(calculator.fromHex("A3F"),"101000111111");
    }


    private void testSumBinaryEqualLengthString(){
        Assert.assertEquals(calculator.sumBinary("01010110", "10101001"),"11111111");
    }

    private void testSumBinaryFirstLongerLengthString(){
        Assert.assertEquals(calculator.sumBinary("0110100110","1101001"),"1000001111");
    }

    private void testSumBinarySecondLongerLengthString(){
        Assert.assertEquals(calculator.sumBinary("0110100","100110110"),"101101010");
    }

    private void testSubBinaryEqualLengthString(){
        Assert.assertEquals(calculator.subBinary("010010110","010010010"),"000000100");
    }

    private void testSubBinaryFirstLongerLengthString(){
        Assert.assertEquals(calculator.subBinary("1110010010","1001011"),"1101000111");
    }

    private void testSubBinarySecondLongerLengthString(){
        Assert.assertEquals(calculator.subBinary("1110100","000110110"),"000111110");
    }

    private void testMultEqualLengthString(){
        Assert.assertEquals(calculator.mult("100101","110010"),"11100111010");
    }

    private void testMultFirstLongerLengthString(){
        Assert.assertEquals(calculator.mult("1001001","10010"),"10100100010");
    }

    private void testMultSecondLongerLengthString(){
        Assert.assertEquals(calculator.mult("1001001","1000100101"),"1001110010001101");
    }


}
