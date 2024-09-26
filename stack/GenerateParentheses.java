package stack;

import java.util.*;
import java.util.stream.Stream;

public class GenerateParentheses {
    public List<String> getParanthesis(String curr, int bal, int n) {
        if (bal > 0 || bal < -n || curr.length() > 2 * n) {
            return Collections.emptyList();
        }

        if (curr.length() == 2 * n && bal == 0) {
            return Arrays.asList(curr);
        }

        return Stream.concat(getParanthesis(curr + "(", bal - 1, n).stream(),
                getParanthesis(curr + ")", bal + 1, n).stream()).toList();
    }

    public List<String> generateParenthesis(int n) {
        return getParanthesis("(", -1, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        generate(builder, 1, 0, n, res);
        return res;
    }

    public void generate(StringBuilder s, int countL, int countR, int n, List<String> res) {
        if (countL + countR == n * 2)
            res.add(s.toString());

        if (countL < n) {
            s.append("(");
            generate(s, countL + 1, countR, n, res);
            s.deleteCharAt(s.length() - 1);
        }

        if (countR < countL) {
            s.append(")");
            generate(s, countL, countR + 1, n, res);
            s.deleteCharAt(s.length() - 1);
        }
    }

    // Better time performance
    public void getParanthesis2(StringBuilder curr, int left, int right, int n, List<String> sol) {
        if (left < right || left > n || right > n) {
            return;
        }

        if (curr.length() == 2 * n && left - right == 0) {
            sol.add(curr.toString());
        }

        curr.append("(");
        getParanthesis(curr, left + 1, right, n, sol);
        curr.deleteCharAt(curr.length() - 1);

        curr.append(")");
        getParanthesis(curr, left, right + 1, n, sol);
        curr.deleteCharAt(curr.length() - 1);

    }

    public List<String> generateParenthesis2(int n) {
        List<String> sol = new ArrayList<>();
        getParanthesis(new StringBuilder(""), 0, 0, n, sol);
        return sol;
    }
}
