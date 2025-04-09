package leetcode.roadmap._2_twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//i!=j!=k
//sum==0
public class _5_15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    while (j<k && nums[j-1] == nums[j]){
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
