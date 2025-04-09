package leetcode.easy.two_pointers;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * <p>
 * Вернуть кол-во элементов val, удалить из nums все эл-ты = val, поместить пропуски массива в конец.
 */
public class _27_RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 3;
//        int val = 2;
//        System.out.println(removeElement(nums, val));
        System.out.println(iwasstupid(nums, val));
    }

    //my bad
    public static int removeElement(int[] nums, int val) {
        int k = 0;

        Arrays.sort(nums);
        int first = 0;

        a: for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                first = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == val) {
                        k++;
                    } else {
                        break a;
                    }
                    if (j == nums.length-1){
                        break a;
                    }
                }
            }
        }

        System.out.println("First = " + first);

        for (int i = 0; i < k; i++) {
            nums[first + i] = nums[nums.length - 1 - i];
        }

        System.out.println(Arrays.toString(nums));
        return nums.length -k;
    }


    public static int iwasstupid(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
