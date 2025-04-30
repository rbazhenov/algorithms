package yandex.reviewprepair;

public class _3_BiSearch {

    public static void main(String[] args) {
        int[] sortedArray = {1, 5, 11, 22, 22, 33, 44, 55};
        int target = 5;

        System.out.println(biSearch(sortedArray, target));
    }


    //[0,5]
    //[5,10]
    //[0]
    //[]
    //[5]
    private static boolean biSearch(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int leftIndx = 0;
        int rightIndx = nums.length - 1;

        while (leftIndx + 1 < rightIndx) {
            int midIndx = leftIndx + (rightIndx - leftIndx) / 2;
            if (nums[midIndx] > target) {
                rightIndx = midIndx - 1;
            } else {
                leftIndx = midIndx;
            }
        }

        return nums[leftIndx] == target;
    }
}
