package BinaryAdd;

public class Main {
    public static void main(String[] args) {
        System.out.println(addBinary("100","100"));
    }
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder ret = new StringBuilder();
        while(i>=0 || j>=0){
            ret.insert(ret.length(),add(a.charAt(i),b.charAt(j)));
            i--;
            j--;
        }
        return ret.reverse().toString();
    }
    private static String add(char a, char b){
        if ((a == '0' && b == '1') || (a == '1' && b == '0')){
            return "1";
        } else if (a == '0' && b == '0') {
            return "0";
        } else {
            return "01";
        }
    }
}
