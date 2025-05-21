package leetcode.easy.array;

public class _941_ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArrayBest(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int maxIndx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[maxIndx] < arr[i]) {
                maxIndx = i;
            }
        }

        if (maxIndx == 0 || maxIndx == arr.length - 1) {
            return false;
        }

        for (int i = maxIndx - 1; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        for (int i = maxIndx + 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
