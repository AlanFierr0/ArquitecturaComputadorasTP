public class Ascii implements AsciiEncoder  {

    @Override
    public String encode(String binary) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encode'");
    }

    @Override
    public String decode(String ascii) {
        String binary = "";
        Calculator calc = new Calculator();
        for(int i = 0; i <= ascii.length() - 1; i++){
            char num_a = ascii.charAt(i);
            int decimal = (int) (num_a);
            String BinaryChar = calc.DecimalToBinary(decimal);
            BinaryChar = Calculator.complete(BinaryChar, "0000000")[0];
            binary += BinaryChar;
        }
        return binary;
    }
    
}
