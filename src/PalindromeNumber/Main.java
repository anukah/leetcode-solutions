package PalindromeNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

//    public static boolean isPalindrome(int x) {
//        String number = Integer.toString(x);
//        StringBuilder reverse = new StringBuilder();
//        for (int i = number.length() - 1; i >= 0; i--) {
//            reverse.append(number.charAt(i));
//        }
//        if (reverse.toString().equals(number)) {
//            return true;
//        }
//        return false;
//    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }
}