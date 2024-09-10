import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, count = 0, curr = nums[0]; i < nums.length; i++) {
            if (nums[i] == curr) {
                count++;
            } else {
                curr = nums[i];
                count = 1;
            }

            if (count == k) {
                solution.add(nums[i]);
            }
        }

        return solution.stream().mapToInt(Integer::intValue).toArray();
    }
}
