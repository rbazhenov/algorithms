package leetcode.easy.design;

import java.util.Arrays;

/**
 * Design a HashSet without using any built-in hash table libraries.
 */
public class _705_DesignHashSet {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        System.out.println("Add 1, arr = " + Arrays.toString(set.arr));
        set.add(2);
        System.out.println("Add 2, arr = " + Arrays.toString(set.arr));
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println("Add again 2, arr = " + Arrays.toString(set.arr));
        System.out.println(set.contains(2));

        set.add(3);

        set.remove(2);
        System.out.println("Remove 2, arr = " + Arrays.toString(set.arr));
        System.out.println(set.contains(2));

    }

    static class MyHashSet {

        int[] arr;

        public MyHashSet() {
            arr = new int[0];
        }

        public void add(int key) {
            if (!contains(key)) {
                int newLen = arr.length + 1;
                int[] temp = new int[newLen];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                temp[newLen - 1] = key;

                arr = temp;
            }
        }

        public void remove(int key) {
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                int[] temp = new int[arr.length - 1];
                System.arraycopy(arr, 0, temp, 0, index);
                if (index != arr.length - 1) {
                    System.arraycopy(arr, index + 1, temp, index, arr.length - 1 - index);
                }
                arr = temp;
            }

        }

        public boolean contains(int key) {
            for (int i : arr) {
                if (i == key) {
                    return true;
                }
            }
            return false;
        }
    }
}
