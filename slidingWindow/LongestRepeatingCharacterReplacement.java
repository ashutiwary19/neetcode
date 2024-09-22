package slidingWindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int majority = 0;
        int solution = 0;
        int[] charMap = new int[128];
        for (int i = 0, l = 0; i < s.length(); i++) {
            if (majority < ++charMap[s.charAt(i)]) {
                majority = charMap[s.charAt(i)];
            }
            while (i - l + 1 - majority > k && i >= l) {
                charMap[s.charAt(l++)]--;
                for (int j = 0; j < 128; j++) {
                    majority = Math.max(majority, charMap[j]);
                }
            }
            solution = Math.max(solution, i - l + 1);

        }

        return solution;
    }

    public int characterReplacement2(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if (j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
