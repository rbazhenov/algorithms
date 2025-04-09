package recursion;

import java.util.NoSuchElementException;

//todo rbs
public class BiSearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 4, 6, 8, 10, 12, 14}, 4));
    }

    public static int search(int[] arr, int item) {
        if (arr.length == 0) {
            throw new NoSuchElementException();
        }

        int highIndex = arr.length - 1;
        int lowIndex = 0;

        return search(arr, item, highIndex, lowIndex);
    }

    public static int search(int[] arr, int item, int highIndex, int lowIndex) {
        if (arr.length == 0) {
            throw new NoSuchElementException();
        }

        if (arr.length == 1 && arr[0] == item) {
            return arr[0];
        }

        return search(arr, (highIndex + lowIndex) / 2, highIndex, lowIndex);
    }
}
