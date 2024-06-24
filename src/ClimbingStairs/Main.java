package ClimbingStairs;

public class Main {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] fib = new int[n+1];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= n ; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    private static void print(int[] arr){
        for (int i:arr) {
            System.out.print(i+", ");
        }
    }
}
