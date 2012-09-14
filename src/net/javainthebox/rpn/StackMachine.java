package net.javainthebox.rpn;

import java.util.ArrayDeque;

public class StackMachine {
    private ArrayDeque<Integer> stack = new ArrayDeque<>();

    public void push(int number) {
        stack.push(number);
    }

    public void clear() {
        stack.clear();
    }

    void printStack() {
        System.out.print("[");
        for (Integer x: stack) {
            System.out.print(x + " ");
        }
        System.out.println("]");        
    }
    
    public int add() throws ArithmeticException {
        if (stack.size() >= 2) {
            Integer x = stack.pop();
            Integer y = stack.pop();

            int result = y + x;

            stack.push(result);

            return result;
        } else {
            clear();
            throw new ArithmeticException("No Element in Stack");
        }
    }

    public int sub() throws ArithmeticException {
        System.out.println(stack.size());
        if (stack.size() >= 2) {
            Integer x = stack.pop();
            Integer y = stack.pop();

            int result = y - x;

            stack.push(result);
            return result;
        } else if (stack.size() == 1) {
            Integer x = stack.pop();

            int result = -x;

            stack.push(result);
            return result;
        } else {
            clear();
            throw new ArithmeticException("No Element in Stack");
        }
    }

    public int mal() throws ArithmeticException {
        if (stack.size() >= 2) {
            Integer x = stack.pop();
            Integer y = stack.pop();

            int result = y * x;

            stack.push(result);

            return result;
        } else {
            clear();
            throw new ArithmeticException("No Element in Stack");
        }
    }

    public int div() throws ArithmeticException {
        if (stack.size() >= 2) {
            Integer x = stack.pop();
            Integer y = stack.pop();

            int result = y / x;

            stack.push(result);

            return result;
        } else {
            clear();
            throw new ArithmeticException("No Element in Stack");
        }
    }
}
