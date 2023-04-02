public class BCD implements BCDEncoder{
    @Override
    public String encode(int intValue) {
        String Binary = "";
        String Binaryreserva = "";
        String NumerosInt = Integer.toString(intValue);
        int[] digitos = new int[NumerosInt.length()];
        for(int j = 0; j < digitos.length; j++) {
            digitos[j] = Character.getNumericValue(NumerosInt.charAt(j));
        }
        for(int i = 0; i < NumerosInt.length() ; i++){;
            Binaryreserva = "";
            int a = digitos[i];
            if(a == 0){
                Binaryreserva = "0000";
            } else if(a == 1){
                Binaryreserva = "0001";
            } else if(a == 2){
                Binaryreserva = "0010";
            } else if(a == 3){
                Binaryreserva = "0011";
            } else if(a == 4){
                Binaryreserva = "0100";
            } else if(a == 5){
                Binaryreserva = "0101";
            } else if(a == 6){
                Binaryreserva = "0110";
            } else if(a == 7){
                Binaryreserva = "0111";
            } else if(a == 8){
                Binaryreserva = "1000";
            } else if(a == 9){
                Binaryreserva = "1001";
        }
        Binary += Binaryreserva;
    }

        return Binary;
    }

    @Override
    public int decode(String BCDNatural) {
        String Int = "";
        String IntReserva = "";
        for(int i = 0; i < BCDNatural.length() / 4; i++){
            String BCDreserva = "";
            for(int j = 0; j < 4; j++){
                char c = BCDNatural.charAt(4 * i + j);
                BCDreserva += c;
            }  

            if(BCDreserva.equals("0000")){
                IntReserva = "0";
            } else if(BCDreserva.equals("0001")){
                IntReserva = "1";
            } else if(BCDreserva.equals("0010")){
                IntReserva = "2";
            } else if(BCDreserva.equals("0011")){
                IntReserva = "3";
            } else if(BCDreserva.equals("0100")){
                IntReserva = "4";
            } else if(BCDreserva.equals("0101")){
                IntReserva = "5";
            } else if(BCDreserva.equals("0110")){
                IntReserva = "6";
            } else if(BCDreserva.equals("0111")){
                IntReserva = "7";
            } else if(BCDreserva.equals("1000")){
                IntReserva = "8";
            } else if(BCDreserva.equals("1001")){
                IntReserva = "9";
        }
        Int += IntReserva;
        }
        return Integer.valueOf(Int);
    }
    
}
