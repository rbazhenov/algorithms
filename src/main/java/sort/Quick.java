package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Quick {

    public static void main(String[] args) {
//        System.out.println(quickSort(List.of(5, 3, 7, 1, 9, 2, 8, 4, 10, 6)));
        System.out.println(Arrays.toString(quickSort(new int[]{5, 3, 7, 1, 9, 2, 8, 4, 10, 6, 10, 3, 2})));
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        System.out.println("Список = " + arr);
        int arrLength = arr.size();
        if (arrLength < 2) {
            return arr;
        }

        if (arrLength == 2) {
            List<Integer> sorted = new ArrayList<>(2);
            sorted.add(Math.min(arr.get(0), arr.get(1)));
            sorted.add(Math.max(arr.get(0), arr.get(1)));
            return sorted;
        }

        Random random = new Random();
        int randIndex = random.nextInt(arrLength - 1);

        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();
        Integer pivot = arr.get(randIndex);
        System.out.println("Опорный элемент = " + pivot);

        for (int i = 0; i < arrLength; i++) {
            Integer value = arr.get(i);
            if (value < pivot) {
                lefts.add(value);
            } else if (value > pivot) {
                rights.add(value);
            }
        }

        List<Integer> sorted = new ArrayList<>(arrLength);
        System.out.println(lefts + " " + pivot + " " + rights);
        sorted.addAll(quickSort(lefts));
        sorted.add(pivot);
        sorted.addAll(quickSort(rights));

        return sorted;
    }

    public static int[] quickSort(int[] arr) {
        //случаи выхода из рекурсии
        if (arr.length < 2) {
            return arr;
        }
        if (arr.length == 2) {
            int a = arr[0];
            int b = arr[1];
            arr[0] = Math.min(a, b);
            arr[1] = Math.max(a, b);
            return arr;
        }

        //выбор случайного числа
        Random random = new Random();
        int randomIndex = random.nextInt(arr.length - 1);
        int pivot = arr[randomIndex];

        //определение длин для 3 массивов
        //можно использовать листы, тогда память массива будет расширяемой автоматически
        int lessCount = 0;
        int biggerCount = 0;
        int pivotCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                lessCount++;
            } else if (arr[i] > pivot) {
                biggerCount++;
            } else {
                pivotCount++;
            }
        }

        //заполняем 3 массива
        int[] left = new int[lessCount];
        int[] right = new int[biggerCount];
        int[] mid = new int[pivotCount];
        lessCount--;
        biggerCount--;
        pivotCount--;
        for (int num : arr) {
            if (num < pivot) {
                left[lessCount--] = num;
            } else if (num > pivot) {
                right[biggerCount--] = num;
            } else {
                mid[pivotCount--] = num;
            }
        }

        quickSort(left);
        for (int i = 0; i < left.length; i++) {
            arr[i] = left[i];
        }

        for (int i = 0; i < mid.length; i++) {
            arr[left.length + i] = mid[i];
        }

        quickSort(right);
        for (int i = 0; i < right.length; i++) {
            arr[left.length + mid.length + i] = right[i];
        }

        return arr;
    }
}
