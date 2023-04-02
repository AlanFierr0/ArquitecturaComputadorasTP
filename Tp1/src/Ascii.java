public class Ascii implements AsciiEncoder  {

    @Override
    public String encode(String binary) {
        String Ascii = "";
        String binaryReserveString = "";
        Calculator calc = new Calculator();
        for(int i = 0; i <= binary.length()/7 - 1; i++){
            binaryReserveString = "";
            for(int j = 0; j < 7; j++){
                int numReserva = 7 * i + j;
                char num = binary.charAt(numReserva);
                binaryReserveString += String.valueOf(num);
            }
            int intasciinum = calc.binarytoDecimal(binaryReserveString);
            char asciinum = (char) intasciinum;
                Ascii += asciinum;
        }
        return Ascii;
    }

    @Override
    public String decode(String ascii) {
        String binary = "";
        Calculator calc = new Calculator();
        for(int i = 0; i <= ascii.length() - 1; i++){
            char num = ascii.charAt(i);
            int decimal = (int) (num);
            String BinaryChar = calc.DecimalToBinary(decimal);
            BinaryChar = Calculator.complete(BinaryChar, "0000000")[0];
            binary += BinaryChar + ' ';
        }
        return binary;
    }
}
