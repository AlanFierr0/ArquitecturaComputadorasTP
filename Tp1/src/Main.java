public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Ascii ascii = new Ascii();
        //System.out.println(calc.fromHex("A7F"));
        //System.out.println(calc.sumBinary("1001010", "100101010101"));
        //System.out.println(calc.subBinary("01010110101", "101010010000"));
        //System.out.println(calc.subBinary("01010110101", "001010010"));
        //System.out.println(calc.mult("1010", "101"));
        //System.out.println(calc.toHex("10101010010010010101010101010"));
        System.out.println(ascii.decode("Hola como andas!"));
        }
    }
