package stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] solution = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                solution[index] = i - index;
            }
            stack.push(i);
        }

        return solution;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        int hotest = 0;
        for (int i = len - 1; i >= 0; i--) {
            int cur = temperatures[i];
            if (cur >= hotest) {
                hotest = cur;
                continue;
            }
            int days = 1;
            while (temperatures[days + i] <= temperatures[i]) {
                days += res[days + i];
            }
            res[i] = days;
        }
        return res;
    }
}
