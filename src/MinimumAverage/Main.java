package MinimumAverage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,9,8,3,10,5};
        System.out.println(minimumAverage(nums));

    }
    public static double minimumAverage(int[] nums) {
        int min = 0;
        int max = 0;
        int j = 0;
        Arrays.sort(nums);
        double[] averages = new double[nums.length/2];
        for (int i = 0; i < nums.length; i++) {
            if (j == averages.length){
                break;
            }
            min = nums[i];
            max = nums[nums.length-1-i];
            averages[j] = (double)(min+max)/2;
            j++;
        }
        Arrays.sort(averages);
        return averages[0];
    }
}
