package stack;

import java.util.Stack;

public class ReversePolishNotion {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (t.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (t.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (t.equals("/")) {
                int v1 = stack.pop();
                stack.push(stack.pop() / v1);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
