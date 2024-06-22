package SearchInsertPosition;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,5));
    }
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            } else if (target < nums[0]){
                return 0;
            } else if (nums[nums.length-1] < target){
                return nums.length;
            } else {
                return i+1;
            }
        }
        return -1;
    }

}
