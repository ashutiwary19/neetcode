import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cmap = new int[24];
        for (int i = 0; i < s.length(); i++) {
            cmap[s.charAt(i) - 'a']++;
            cmap[t.charAt(i) - 'a']--;
        }

        for (int i : cmap) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);

    }
}
