package yandex.course_2.lesson_1;

import java.util.Scanner;

public class _11_StackWithProtection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MyStack myStack = new MyStack();
        String line = scanner.nextLine();
        while (!line.equals("exit")) {
            String[] split = line.split(" ");
            String operation = split[0];
            if (operation.equals("push")) {
                int x = Integer.parseInt(split[1]);
                myStack.push(x);
                System.out.println("ok");
            } else if (operation.equals("pop")) {
                Integer pop = myStack.pop();
                System.out.println(pop == null ? "error" : pop);
            } else if (operation.equals("back")) {
                Integer back = myStack.back();
                System.out.println(back == null ? "error" : back);
            } else if (operation.equals("size")) {
                int size = myStack.size();
                System.out.println(size);
            } else if (operation.equals("clear")) {
                myStack.clear();
                System.out.println("ok");
            }

            line = scanner.nextLine();
        }
        System.out.println("bye");
    }

    private static class MyStack {
        Integer[] arr;
        Integer lastInd = -1;

        public MyStack() {
            arr = new Integer[10];
        }

        public int size() {
            return lastInd + 1;
        }

        public void push(int x) {
            resize();
            lastInd++;
            arr[lastInd] = x;
        }

        private void resize() {
            if (lastInd == arr.length - 1) {
                int newLen = arr.length * 2;
                Integer[] newArr = new Integer[newLen];
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                arr = newArr;
            }
        }

        public Integer pop() {
            if (lastInd < 0) {
                return null;
            }

            int toRemove = arr[lastInd];
            arr[lastInd] = 0;
            lastInd--;
            return toRemove;
        }

        public Integer back() {
            if (lastInd < 0) {
                return null;
            }
            return arr[lastInd];
        }

        public void clear() {
            arr = new Integer[10];
            lastInd = -1;
        }
    }
}
