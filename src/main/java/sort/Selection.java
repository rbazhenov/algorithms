package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Selection {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new Integer[]{5, 3, 6, 2, 10})));
        System.out.println(Arrays.toString(selectionSort_2(new Integer[]{8, 15, 33, 1, 10, 7})));
        System.out.println(Arrays.toString(selectionSort_3(new Integer[]{8, 15, 33, 1, 10, 7})));
    }

    public static int[] selectionSort(Integer[] inputArr) {
        //big O(log N^2)
        List<Integer> list = new ArrayList<>(Arrays.asList(inputArr));
        int size = list.size();

        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            int smallest = findSmallestIndex(list);
            newArr[i] = list.get(smallest);
            list.remove(smallest);
        }
        return newArr;
    }

    public static int findSmallestIndex(List<Integer> list) {
        // O(n)
//        System.out.println("findSmallest list = " + list);
        int smallest = list.get(0);
        int smallestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    //-----------------------------------------------------------------

    public static int[] selectionSort_2(Integer[] inputArr) {
        List<Integer> list = new ArrayList<>(Arrays.asList(inputArr));
        int inputSize = list.size();
        int[] sortedArray = new int[inputSize];

        for (int i = 0; i < inputSize; i++) {
            int smallestIndex = findSmallestIndex_2(list);
            sortedArray[i] = list.get(smallestIndex);
            list.remove(list.get(smallestIndex));
        }

        return sortedArray;
    }

    public static int findSmallestIndex_2(List<Integer> list) {
        System.out.println("findSmallest list = " + list);
        Integer smallest = list.get(0);
        int smallestIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    //-----------------------------------------------------------------

    public static int[] selectionSort_3(Integer[] inputArr) {
        //todo rbs
        throw new IllegalArgumentException();
    }

    public static int findSmallestIndex_3(List<Integer> list) {
        System.out.println("findSmallest list = " + list);
        //todo rbs
        throw new IllegalArgumentException();
    }
}
