package PlusOne;

public class Main {
    public static void main(String[] args) {
        int[] d = {1,9,9};
        for (int i:plusOne(d)
             ) {
            System.out.print(i+", ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
