package leetcode.medium;

import java.util.Arrays;

//каждый элемент встречается не более 2 раз
public class _80_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicatesBest(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicatesBest(int[] nums) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        while(right < nums.length) {
            if (right > 0 && nums[right] != nums[right - 1]){
                cnt = 0;
            }

            cnt++;
            if (cnt < 3) {
                nums[left] = nums[right];
                left++;
            }

            right++;
        }

        return left;
    }

    public static int removeDuplicates(int[] nums) {
        /*
        иду до 2 дубликата, lastIndex--
        первые 2 числа передвигаю
        меняю indxToReplace + 2

        1 1 1 2 2 3
           i,r     l
        i = 2, dup = 2, lastIndex--

         */

        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int cntDuplicates = 0;
        int indxToReplace = 1;
        int ans = len;
        for (int i = 1; i < len; i++) {
            int curNum = nums[i];

            if (curNum == nums[i - 1]) {
                cntDuplicates++;
            } else {
                cntDuplicates = 0;
            }

            if (cntDuplicates > 1) {
                ans--;
            } else {
                nums[indxToReplace++] = curNum;
            }

        }

        return ans;
    }
}
