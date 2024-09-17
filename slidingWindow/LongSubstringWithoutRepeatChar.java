package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongSubstringWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int maxCount = 0;
        Map<Character, Integer> cmap = new HashMap<>();
        for (int i = 0, left = 0; i < s.length(); i++) {
            if (cmap.get(s.charAt(i)) != null && cmap.get(s.charAt(i)) >= left) {
                count = i - cmap.get(s.charAt(i)) - 1;
                left = cmap.get(s.charAt(i)) + 1;
            }

            count++;
            cmap.put(s.charAt(i), i);
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new LongSubstringWithoutRepeatChar().lengthOfLongestSubstring("abcabcbb"));
    }
}
