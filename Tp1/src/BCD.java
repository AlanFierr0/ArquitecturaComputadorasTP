public class BCD implements BCDEncoder{
    @Override
    public String encode(int intValue) {
        String Binary = "";
        String binaryreserveString = "";
        String NumsInt = Integer.toString(intValue);
        int[] digitos = new int[NumsInt.length()];
        for(int j = 0; j < digitos.length; j++) {
            digitos[j] = Character.getNumericValue(NumsInt.charAt(j));
        }
        for(int i = 0; i < NumsInt.length() ; i++){;
            binaryreserveString = "";
            int a = digitos[i];
            if(a == 0){
                binaryreserveString = "0000";
            } else if(a == 1){
                binaryreserveString = "0001";
            } else if(a == 2){
                binaryreserveString = "0010";
            } else if(a == 3){
                binaryreserveString = "0011";
            } else if(a == 4){
                binaryreserveString = "0100";
            } else if(a == 5){
                binaryreserveString = "0101";
            } else if(a == 6){
                binaryreserveString = "0110";
            } else if(a == 7){
                binaryreserveString = "0111";
            } else if(a == 8){
                binaryreserveString = "1000";
            } else if(a == 9){
                binaryreserveString = "1001";
        }
        Binary += binaryreserveString;
    }

        return Binary;
    }

    @Override
    public int decode(String BCDNatural) {
        String result = "";
        String intReserveString = "";
        for(int i = 0; i < BCDNatural.length() / 4; i++){
            String bCDreserveString = "";
            for(int j = 0; j < 4; j++){
                char c = BCDNatural.charAt(4 * i + j);
                bCDreserveString += c;
            }  

            if(bCDreserveString.equals("0000")){
                intReserveString = "0";
            } else if(bCDreserveString.equals("0001")){
                intReserveString = "1";
            } else if(bCDreserveString.equals("0010")){
                intReserveString = "2";
            } else if(bCDreserveString.equals("0011")){
                intReserveString = "3";
            } else if(bCDreserveString.equals("0100")){
                intReserveString = "4";
            } else if(bCDreserveString.equals("0101")){
                intReserveString = "5";
            } else if(bCDreserveString.equals("0110")){
                intReserveString = "6";
            } else if(bCDreserveString.equals("0111")){
                intReserveString = "7";
            } else if(bCDreserveString.equals("1000")){
                intReserveString = "8";
            } else if(bCDreserveString.equals("1001")){
                intReserveString = "9";
        }
        result += intReserveString;
        }
        return Integer.valueOf(result);
    }
    
}
