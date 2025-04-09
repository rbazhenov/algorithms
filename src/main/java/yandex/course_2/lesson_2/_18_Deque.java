package yandex.course_2.lesson_2;

import java.util.Scanner;

public class _18_Deque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyDeque myDeque = new MyDeque();
        String line = scanner.nextLine();
        while (!line.equals("exit")) {
            String[] split = line.split(" ");
            String operation = split[0];
            if (operation.equals("push_front")) {
                Integer x = Integer.parseInt(split[1]);
                myDeque.push_front(x);
                System.out.println("ok");
            } else if (operation.equals("push_back")) {
                Integer x = Integer.parseInt(split[1]);
                myDeque.push_back(x);
                System.out.println("ok");
            } else if (operation.equals("pop_front")) {
                Integer popFront = myDeque.pop_front();
                System.out.println(popFront == null ? "error" : popFront);
            } else if (operation.equals("pop_back")) {
                Integer popBack = myDeque.pop_back();
                System.out.println(popBack == null ? "error" : popBack);
            } else if (operation.equals("front")) {
                Integer front = myDeque.front();
                System.out.println(front == null ? "error" : front);
            } else if (operation.equals("back")) {
                Integer back = myDeque.back();
                System.out.println(back == null ? "error" : back);
            } else if (operation.equals("size")) {
                System.out.println(myDeque.size());
            } else if (operation.equals("clear")) {
                myDeque.clear();
                System.out.println("ok");
            }

            line = scanner.nextLine();
        }

        System.out.println("bye");
    }

    static class MyDeque {
        Integer head;
        Integer tail;
        Integer[] arr;

        public MyDeque() {
            clear();
        }

        void push_front(Integer x) {
            resize();
            if (head == null) {
                int initInd = arr.length / 2;
                head = initInd;
                tail = initInd;
                arr[initInd] = x;
            } else {
                arr[--head] = x;
            }
        }

        void push_back(Integer x) {
            resize();
            if (tail == null) {
                int initInd = arr.length / 2;
                tail = initInd;
                head = initInd;
                arr[initInd] = x;
            } else {
                arr[++tail] = x;
            }
        }

        Integer pop_front() {
            Integer front = arr[head];

            if (++head > tail) {
                clear();
            }

            return front;
        }

        Integer pop_back() {
            Integer back = arr[tail];

            if (--tail < head) {
                clear();
            }

            return back;
        }

        Integer front() {
            if (size() == 0) {
                return null;
            }

            return arr[head];
        }

        Integer back() {
            if (size() == 0) {
                return null;
            }

            return arr[tail];
        }

        Integer size() {
            if (tail == null || head == null) {
                return 0;
            }
            return tail - head + 1;
        }

        void clear() {
            head = null;
            tail = null;
            arr = new Integer[1];
        }

        private void resize() {
            if (head == null || tail == null) {
                return;
            }

            boolean frontFull = head == 0;
            boolean backFull = tail == arr.length - 1;
            if (!frontFull && !backFull) {
                return;
            }

            int newLen = (tail - head + 2) * 2;
            Integer[] newArr = new Integer[newLen];
            int newHead = newLen / 4;
            int newTail = newHead + tail - head;

            System.arraycopy(arr, head, newArr, newHead, tail - head + 1);
            arr = newArr;
            head = newHead;
            tail = newTail;
        }
    }
}
