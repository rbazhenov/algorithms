import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(removeDuplicates(nums));
        Map<Character, String> dict = new HashMap<>();
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {
            while (right < nums.length - 1 && nums[right] == nums[left]){
                right++;
            }

            if (right >= nums.length) {
                break;
            }

            left++;
            nums[left] = nums[right];
        }

        return left + 1;
    }
}
