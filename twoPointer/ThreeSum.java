package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> twoSum(int[] nums, int i, int j, int target) {
        List<List<Integer>> solution = new ArrayList<>();
        int k = i;
        while (i < j) {
            if (nums[i] + nums[j] > target || (j < nums.length - 1 && nums[j] == nums[j + 1])) {
                j--;
            } else if (nums[i] + nums[j] < target || (i > k && nums[i] == nums[i - 1])) {
                i++;
            } else if (nums[i] + nums[j] == target) {
                solution.add(Arrays.asList(nums[i], nums[j]));
                i++;
                j--;
            }
        }

        return solution;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);
        int curr = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (curr != nums[i]) {
                List<List<Integer>> currSol = twoSum(nums, i + 1, nums.length, -nums[i]);
                if (currSol.size() != 0) {
                    sol.addAll(currSol);
                }
                curr = nums[i];
            }
        }
        return sol;
    }
}
