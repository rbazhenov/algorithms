package data_structure;

import java.util.Arrays;

public class SimpleSet {
    public static void main(String[] args) {
        MySetImpl set = new MySetImpl();
        set.add(0);
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(11);
        set.add(111);
        set.add(22);
        set.add(23);
        set.add(123);
        System.out.println(Arrays.toString(set.arr));

        System.out.println(set.contains(2));
        System.out.println(set.contains(1));

        System.out.println(set.size());

        set.remove(1);
        System.out.println(Arrays.toString(set.arr));
        System.out.println(set.size());
    }


    interface MySet {

        void add(int num);

        boolean contains(int num);

        void remove(int num);

        int size();
    }

    static class MySetImpl implements MySet {
        int size;
        int[] arr;

        public MySetImpl() {
            arr = new int[10];
        }

        public void add(int num) {
            if (!contains(num)) {
                if (arr.length == size) {
                    increaseArraySize();
                } else {
                    arr[size++] = num;
                }
            }
        }

        private void increaseArraySize() {
            int newLen = size + size / 2 + 1;
            int[] newArr = new int[newLen];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }

        public boolean contains(int num) {
            for (int i = 0; i < size; i++) {
                if (num == arr[i]) {
                    return true;
                }
            }
            return false;
        }

        public void remove(int num) {
            int indexToRemove = -1;
            for (int i = 0; i < size; i++) {
                if (num == arr[i]) {
                    indexToRemove = i;
                    break;
                }
            }
            if (indexToRemove != -1) {
                if (indexToRemove == size - 1) {
                    arr[indexToRemove] = 0;
                } else {
                    arr[indexToRemove] = arr[size - 1];
                    arr[size - 1] = 0;
                }

                size--;
            }
        }

        public int size() {
            return size;
        }
    }
}

