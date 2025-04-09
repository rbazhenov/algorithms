package yandex.course_2.lesson_2;

import java.util.Scanner;

public class _16_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyQueue myQueue = new MyQueue();
        String line = scanner.nextLine();
        while (!line.equals("exit")) {
            String[] split = line.split(" ");

            String operation = split[0];
            if (operation.equals("push")) {
                myQueue.push(Integer.parseInt(split[1]));
            } else if (operation.equals("pop")) {
                myQueue.pop();
            } else if (operation.equals("front")) {
                myQueue.front();
            } else if (operation.equals("size")) {
                int size = myQueue.size();
                System.out.println(size);
            } else if (operation.equals("clear")) {
                myQueue.clear();
                System.out.println("ok");
            }

            line = scanner.nextLine();
        }

        System.out.println("bye");
    }

    //FIFO - first in, first out
    private static class MyQueue {
        int front;
        int lastInd;
        int[] arr;

        public MyQueue() {
            clear();
        }

        void push(int x) {
            resize();
            arr[++lastInd] = x;
            System.out.println("ok");
        }

        int pop() {
            if (size() == 0) {
                System.out.println("error");
                return -1;
            }

            int first = arr[front];
            System.out.println(first);

            if (++front > lastInd) {
                resize();
            }

            return first;
        }

        int front() {
            if (size() == 0) {
                System.out.println("error");
                return -1;
            }

            int first = arr[front];
            System.out.println(first);
            return first;
        }

        int size() {
            if (arr == null) {
                System.out.println(0);
                return 0;
            }

            int size = lastInd - front + 1;
            return size;
        }

        void clear() {
            front = 0;
            lastInd = -1;
            arr = new int[1];
        }

        private void resize() {
            if (lastInd + 1 <= arr.length - 1) {
                return;
            }

            int newLen = size() * 2;
            int[] newArr = new int[newLen];
            System.arraycopy(arr, front, newArr, 0, size());
            arr = newArr;
        }
    }
}
