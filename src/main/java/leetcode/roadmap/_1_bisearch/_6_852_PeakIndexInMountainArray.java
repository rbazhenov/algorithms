package leetcode.roadmap._1_bisearch;

public class _6_852_PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
//        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
//        int[] arr = {3, 4, 5, 1};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] > arr[1] ? 0 : 1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m] > arr[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
