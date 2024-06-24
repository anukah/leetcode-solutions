package MergedSortedArrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
    }
    /*
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        if (m==0) nums1 = nums2;
        else if (n!=0){
            for (int i = m; i < m+n; i++) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
    }
    */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
