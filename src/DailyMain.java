public class DailyMain {
    public static void main(String[] args) {
    int[] arr = {1,2,34,3,4,5,7,23,12};
        System.out.println(threeConsecutiveOdds(arr));
    }
    public static boolean threeConsecutiveOdds(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isOdd(arr[i])) {
                oddCount++;
                if (oddCount == 3) {
                    return true;
                }
            } else {
                oddCount = 0;
            }
        }
        return false;
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

}
