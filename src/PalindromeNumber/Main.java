package PalindromeNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    public static boolean isPalindrome(int x) {
        String number = Integer.toString(x);
        StringBuilder reverse = new StringBuilder();
        for (int i = number.length()-1; i>=0; i--) {
            reverse.append(number.charAt(i));
        }
        if (reverse.toString().equals(number)){
            return true;
        }
        return false;
    }
}
