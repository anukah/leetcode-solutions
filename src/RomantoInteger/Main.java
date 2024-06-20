package RomantoInteger;
public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int integer = 0;
        int length = s.length();
        int current = translate(s.charAt(0));
        for (int i = 1; i < length; i++) {
            int next = translate(s.charAt(i));
            if (current<next){
                integer = integer - current;
            } else {
                integer = integer + current;
            }
            current = next;
        }
        integer = integer + current;
        return integer;
    }



    private static int translate(char c){
        switch (c){
            case 'I' :
                return 1;
            case 'V' :
                return 5;
            case 'X' :
                return 10;
            case 'L' :
                return 50;
            case 'C' :
                return 100;
            case 'D' :
                return 500;
            case 'M' :
                return 1000;
            default:
                return 0;
        }
    }
}
