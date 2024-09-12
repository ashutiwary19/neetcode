package twoPointer;

public class ValidPalidrome {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            if (s.charAt(i) == ' ' || !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (s.charAt(j) == ' ' || !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
