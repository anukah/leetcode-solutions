package TwoSum;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        int[] array = {2,5,5,11};
        System.out.println(twoSum(array, 10));
    }

    //brute force

//    public static int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (i+j == target){
//                    return new int[] {i,j};
//                }
//            }
//        }
//        return nums;
//    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null){
                return new int[]{i, complementIndex};
            } else {
                complements.put(target - nums[i], i);
            }
        }
        return nums;
    }
}