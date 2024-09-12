package twoPointer;

public class TwoSumSortedArray {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j;) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return new int[] {};
    }
}
