package leetcode.easy.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 */
public class _225_ImplementStackUsingQueues {

    private Queue<Integer> queue = new LinkedList<>();
//    private List<Integer> arr = new ArrayList<>();

    public _225_ImplementStackUsingQueues() {
    }

    public static void main(String[] args) {
        _225_ImplementStackUsingQueues obj = new _225_ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

    //Pushes element x to the top of the stack.
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }


        //my case
//        arr.add(x);
//
//        queue = new ArrayDeque<>();
//        for (int i = 0; i < arr.size(); i++) {
//            queue.add(arr.get(arr.size() - 1 - i));
//        }
    }

    //Removes the element on the top of the stack and returns it.
    public int pop() {
//        arr.remove(arr.get(arr.size()-1));
        return queue.poll();
    }

    //Returns the element on the top of the stack.
    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
