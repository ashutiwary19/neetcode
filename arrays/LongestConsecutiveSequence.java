import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;

        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                continue;
            }
            int curr = nums[i];
            int ccount = 1;
            while (set.contains(curr + 1)) {
                curr++;
                ccount++;
                set.remove(curr);
            }

            curr = nums[i];
            while (set.contains(curr - 1)) {
                curr--;
                ccount++;
                set.remove(curr);
            }
            maxCount = Math.max(maxCount, ccount);
        }

        return maxCount;
    }
}
