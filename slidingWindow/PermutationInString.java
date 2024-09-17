package slidingWindow;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] charMap = new int[27];
        for (int i = 0; i < s1.length(); i++) {
            charMap[s1.charAt(i) - 'a']++;
        }

        int[] charMap2 = new int[27];
        for (int i = 0, l = 0; i < s2.length(); i++) {
            charMap2[s2.charAt(i) - 'a']++;
            while (charMap2[s2.charAt(i) - 'a'] > charMap[s2.charAt(i) - 'a'] && l <= i) {
                charMap2[s2.charAt(l++) - 'a']--;
            }
            if (i - l == s1.length() - 1) {
                return true;
            }
        }
        return false;
    }
}
