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
            String ceros = String.format("%0" + diff(a, b) + "d", 0);
            b = ceros + b;
        } else if (a.length() < b.length()) {
            String ceros = String.format("%0" + diff(b, a) + "d", 0);
            a = ceros + a;
        }
        String[] result = { a, b };
        return result;
    }

@Override
public String sumBinary(String a, String b) {
        String[] completeResult = complete(a, b);
        a = completeResult[0];
        b = completeResult[1];
        String sum = "";
        String extra = "0";
        for (int i = 0; i <= a.length() - 1; i++) {
            char num_a = a.charAt(a.length() - 1 - i);
            char num_b = b.charAt(b.length() - 1 - i);

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

@Override
public String subBinary(String a, String b) {
    String[] completeResult = complete(a, b);
    a = completeResult[0];
    b = completeResult[1];
    String substitution = "";
    String extra = "0";

    for (int i = 0; i <= a.length() - 1; i++) {
        char num_a = a.charAt(a.length() - 1 - i);
        char num_b = b.charAt(b.length() - 1 - i);
        if (num_a < num_b){
            return "1" + subBinary(b, a); 
        }
        else{
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
    
    if (extra.equals("1")) {
        substitution = "1" + substitution;
    }
}
return substitution;
}

@Override
public String mult(String a, String b) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mult'");
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
    while (number > 2){
    int resto = number % 2;
    binary += String.valueOf(resto);
    number /= 2;
    }
    int restante = number.intValue();
    binary += String.valueOf(restante);
    System.out.println("el numero binario es" + binary);
    return binary;
}
@Override
public String fromHex(String hex) {
    Integer num = hexToDecimal(hex);
    String result = DecimalToBinary(num);
    return result;
    }
}




