package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetCount = new HashMap<>();
        HashSet<Character> chars = new HashSet<>();
        Map<Character, Integer> extraCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            chars.add(t.charAt(i));
            targetCount.putIfAbsent(t.charAt(i), 0);
            targetCount.computeIfPresent(t.charAt(i), (key, value) -> value + 1);
        }

        int minWindow = Integer.MAX_VALUE;
        String solution = "";
        for (int i = 0, l = 0; i < s.length(); i++) {
            if (targetCount.get(s.charAt(i)) != null && targetCount.get(s.charAt(i)) == 1) {
                targetCount.remove(s.charAt(i));
            } else if (targetCount.get(s.charAt(i)) != null) {
                targetCount.computeIfPresent(s.charAt(i), (key, value) -> value - 1);
            } else {
                extraCount.putIfAbsent(s.charAt(i), 0);
                extraCount.computeIfPresent(s.charAt(i), (key, value) -> value + 1);
            }

            while (targetCount.size() == 0 && l <= i) {
                if (minWindow >= i + 1 - l) {
                    minWindow = i + 1 - l;
                    solution = s.substring(l, i + 1);
                }
                if (chars.contains(s.charAt(l)) && extraCount.getOrDefault(s.charAt(l), 0) <= 0) {
                    targetCount.putIfAbsent(s.charAt(l), 1);
                } else {
                    extraCount.computeIfPresent(s.charAt(l), (key, value) -> value - 1);
                }
                l++;
            }

        }

        return solution;
    }

    public String minWindow2(String s, String t) {
        int[] map = new int[128];
        int count = t.length();

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int minWindow = Integer.MAX_VALUE;
        int le = -1, re = -1;
        for (int i = 0, l = 0; i < s.length(); i++) {

            if (map[s.charAt(i)]-- > 0) {
                count--;
            }
            while (count == 0 && l <= i) {
                if (minWindow > i + 1 - l) {
                    minWindow = i + 1 - l;
                    le = l;
                    re = i;
                }
                if (++map[s.charAt(l++)] > 0) {
                    count++;
                }
            }

        }

        return le != -1 ? s.substring(le, re + 1) : "";
    }
}