package yandex.course_1.lesson_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class f_SymmetricalSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        List<Integer> extraSeq = extraSeq(nums);
        int size = extraSeq.size();
        System.out.println(size);
        if (size > 0) {
            String result = extraSeq.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }

    }

    public static List<Integer> extraSeq(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int start = 0; start < nums.length; start++) {
            int l = start;
            int r = nums.length - 1;
            while (l < nums.length && r >= 0 && nums[l] == nums[r] && l <= r) {
                l++;
                r--;
            }

            if (l > r) {
                for (int i = 0; i < start; i++) {
                    result.add(nums[start-i-1]);
                }
                return result;
            }
        }

        return result;
    }
}
