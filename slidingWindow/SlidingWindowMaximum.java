package slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    // Gets TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> maxWinList = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (pq.size() >= k) {
                pq.remove(nums[i - k]);
            }
            pq.add(nums[i]);
            if (i >= k - 1) {
                maxWinList.add(pq.peek());
            }
            i++;
        }

        return maxWinList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Gets TLE
    public int[] maxSlidingWindow2(int[] nums, int k) {
        List<Integer> maxWinList = new ArrayList<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < nums.length) {
            max = Math.max(max, nums[i]);
            if (i >= k && max == nums[i - k]) {
                int j = i - k + 1;
                max = nums[i];
                while (j < i) {
                    max = Math.max(max, nums[j++]);
                }
            }
            if (i >= k - 1) {
                maxWinList.add(max);
            }
            i++;
        }

        return maxWinList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k + 1)
                q.pollFirst();
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()])
                q.pollLast();
            q.offer(i);
            if (i >= k - 1)
                ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }
}
