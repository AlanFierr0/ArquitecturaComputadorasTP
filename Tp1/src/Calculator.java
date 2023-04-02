public class Calculator implements Icalculator {

    public static int diff(String a, String b) {
            if (a.length() > b.length()) {
                return a.length() - b.length();
            } else if (a.length() < b.length()) {
                return b.length() - a.length();
            } else {
                return 0;
            }
        }
    
    public static String[] complete(String a, String b) {
            if (a.length() > b.length()) {
                String zeros = String.format("%0" + diff(a, b) + "d", 0);
                b = zeros + b;
            } else if (a.length() < b.length()) {
                String zeros = String.format("%0" + diff(b, a) + "d", 0);
                a = zeros + a;
            }
            String[] result = { a, b };
            return result;
        }
    
    @Override
    public String sumBinary(String Binary1, String Binary2) {
            String[] completeResult = complete(Binary1, Binary2);
            Binary1 = completeResult[0];
            Binary2 = completeResult[1];
            String sum = "";
            String extra = "0";
            for (int i = 0; i <= Binary1.length() - 1; i++) {
                char num_a = Binary1.charAt(Binary1.length() - 1 - i);
                char num_b = Binary2.charAt(Binary2.length() - 1 - i);
    
                if (num_a == '0' && num_b == '0') {
                    if (extra.equals("0")) {
                        sum = "0" + sum;
                    } else {
                        sum = "1" + sum;
                        extra = "0";
                    }
                } else if (num_a == '1' && num_b == '0') {
                    if (extra.equals("0")) {
                        sum = "1" + sum;
                    } else {
                        sum = "0" + sum;
                        extra = "1";
                    }
                } else if (num_a == '0' && num_b == '1') {
                    if (extra.equals("0")) {
                        sum = "1" + sum;
                    } else {
                        sum = "0" + sum;
                        extra = "1";
                    }
                } else if (num_a == '1' && num_b == '1') {
                    if (extra.equals("0")) {
                        sum = "0" + sum;
                        extra = "1";
                    } else {
                        sum = "1" + sum;
                        extra = "1";
                    }
                }
            }
            if (extra.equals("1")) {
                sum = "1" + sum;
            }
            return sum;
        }
    
    public boolean checkNegativeAnswer(String a, String b){
        for(int j = 0; j <= a.length() - 1; j++) {
            char checkNum_a = a.charAt(j);
            char checkNum_b = b.charAt(j);
            if (checkNum_a > checkNum_b){
               return true;
            }
            else if(checkNum_a == checkNum_b){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    @Override
    public String subBinary(String Binary1, String Binary2) {
        String[] completeResult = complete(Binary1, Binary2);
        Binary1 = completeResult[0];
        Binary2 = completeResult[1];
        String substitution = "";
        String extra = "0";
        if(checkNegativeAnswer(Binary1,Binary2)){
            for (int i = 0; i <= Binary1.length() - 1; i++) {
                char num_a = Binary1.charAt(Binary1.length() - 1 - i);
                char num_b = Binary2.charAt(Binary2.length() - 1 - i);
                if (num_a == '0' && num_b == '0') {
                    if (extra.equals("0")) {
                        substitution = "0" + substitution;
                    } else {
                        substitution = "1" + substitution;
                        extra = "1";
                    }
                } else if (num_a == '1' && num_b == '0') {
                    if (extra.equals("0")) {
                        substitution = "1" + substitution;
                    } else {
                        substitution = "0" + substitution;
                        extra = "0";
                    }
                } else if (num_a == '0' && num_b == '1') {
                    if (extra.equals("0")) {
                        substitution = "1" + substitution;
                        extra = "1";
                    } else {
                        substitution = "0" + substitution;
                        extra = "1";
                    }
                } else if (num_a == '1' && num_b == '1') {
                    if (extra.equals("0")) {
                        substitution = "0" + substitution;
                        extra = "0";
                    } else {
                        substitution = "1" + substitution;
                        extra = "0";
                        }
                    }
                }
                }
        else{
            System.out.println("No se pueden calcular numeros negativos");
        }    
        if (extra.equals("1")) {
            substitution = "1" + substitution;
        }
    return substitution;
    }
    
    @Override
    public String mult(String Binary1, String Binary2) {
        int timesMultiplied = binarytoDecimal(Binary2);
        String Binary = "";
            for(int i = 0; i < timesMultiplied; i++){
            Binary= sumBinary(Binary,Binary1);
        }
        return(Binary);
    }
    @Override
    public String div(String a, String b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'div'");
    }
    
    public Integer binarytoDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i <= binary.length() - 1; i++) {
            char num_a = binary.charAt(binary.length() - 1 - i);
            if(num_a == '1'){
                decimal = (int) (decimal + Math.pow(2,i));
            }
        } 
        return decimal;
    }
    
    public String numToHex(int num2){
        String hex = "";
        if(num2 == 10){
            hex = "A";
        }
        else if(num2 == 11){
            hex = "B";
        }
        else if(num2 == 12){
            hex = "C";
        }
        else if(num2 == 13){
            hex = "D";
        }
        else if(num2 == 14){
            hex = "E";
        }
        else if(num2 == 15){
            hex = "F";
        }
        else{
            hex = String.valueOf(num2) + hex;
        }
        return hex;
    }
    @Override
    public String toHex(String binary) {
        int decimal = binarytoDecimal(binary);
        String hex = "";
        Integer num = 0;
        while (decimal > 16){
        int resto = decimal % 16;
        String resto2 = numToHex(resto);
        hex = String.valueOf(resto2) + hex;
        num = decimal / 16 ;
        decimal = decimal / 16;
        }
        int num2 = num.intValue();
        String num3 = numToHex(num2);
        hex = String.valueOf(num3) + hex;
        return hex;
    }
    
    public Integer hexToDecimal(String hexa){
        Integer num = 0;
        for (int i = 0; i <= hexa.length() - 1; i++) {
            char num_a = hexa.charAt(hexa.length() - 1 - i);
            String hexadecimal = String.valueOf(num_a);
            Integer hex = ConvertHextoDecimal(hexadecimal);
            num += (int) (hex * Math.pow(16,i));
            } 
        return num;
        }
    
    public Integer ConvertHextoDecimal(String num){
        int number = 0;
        if(num.equals("A")){
            number = 10;
        }
        else if(num.equals("B")){
            number = 11;
        }
        else if(num.equals("C")){
            number = 12;
        }
        else if(num.equals("D")){
            number = 13;
        }
        else if(num.equals("E")){
            number = 14;
        }
        else if(num.equals("F")){
            number = 15;
        }
        else{
            number = Integer.valueOf(num);
        }
    
        return number;
    }
    
    public String DecimalToBinary(Integer number){
        String binary = "";
        while (number >= 2){
        int resto = number % 2;
        binary += String.valueOf(resto);
        number /= 2;
        }
        int restante = number.intValue();
        binary += String.valueOf(restante);
        String binaryReal = "";
        for (int i = 0; i < binary.length(); i++)
        binaryReal += binary.charAt(binary.length()-1-i);
        return binaryReal;
    }
    @Override
    public String fromHex(String hex) {
        Integer num = hexToDecimal(hex);
        String result = DecimalToBinary(num);
        return result;
        }
    }
    
