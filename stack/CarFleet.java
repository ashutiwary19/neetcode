package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class CarFleet {
    public boolean willCatchUp(int target, int posCurr, int posPrev, int vCurr, int vPrev) {
        if (vCurr < vPrev) {
            double currTime = (target - posCurr) * 1.0 / vCurr;
            double timeByPrev = ((posCurr - posPrev) * 1.0) / (vPrev - vCurr);
            return timeByPrev <= currTime;
        }

        return false;
    }

    public int carFleet1(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        Stack<Integer> stack = new Stack<>();
        for (int x : position) {
            while (!stack.isEmpty() && willCatchUp(target, x, stack.peek(), map.get(x), map.get(stack.peek()))) {
                stack.pop();
            }
            stack.push(x);
        }

        return stack.size();
    }

    public int carFleet2(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[] { position[i], speed[i] };
        }
        Arrays.sort(dp, (a, b) -> a[0] - b[0]);
        Stack<Double> stack = new Stack<>();
        for (int[] d : dp) {
            double trt = ((target - d[0]) * 0.1f) / d[1];
            while (!stack.isEmpty() && trt >= stack.peek()) {
                stack.pop();
            }
            stack.push(trt);
        }

        return stack.size();
    }

    // Best complexity
    public int carFleet3(int target, int[] position, int[] speed) {
        double[] times = new double[target + 1];
        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (target - position[i]) / (double) speed[i];
        }

        int numFleets = 0;
        double prevTime = 0;
        for (int i = times.length - 1; i >= 0; i--) {
            if (times[i] > prevTime) {
                numFleets++;
                prevTime = times[i];
            }
        }

        return numFleets;
    }
}