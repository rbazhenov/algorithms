package leetcode.easy.design;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
public class _232_ImplementQueueUsingStacks {

    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public _232_ImplementQueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public static void main(String[] args) {
        _232_ImplementQueueUsingStacks obj = new _232_ImplementQueueUsingStacks();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    //Pushes element x to the back of the queue.
    public void push(int x) {
        inStack.add(x);
    }

    //Removes the element from the front of the queue and returns it.
    public int pop() {
        if (outStack.isEmpty()) {
            transfer();
        }

        return outStack.pop();
    }

    //Returns the element at the front of the queue.
    public int peek() {
        if (outStack.isEmpty()){
            transfer();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void transfer() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
    }
}
