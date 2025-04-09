package yandex.course_1.lesson_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class h_BiggestMultiplicationOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> threeNums = getThreeNums(nums);
        System.out.println(threeNums.get(0) + " " + threeNums.get(1) + " " + threeNums.get(2));
    }

    public static List<Integer> getThreeNums(List<Integer> nums) {
        Collections.sort(nums);
        int pos1 = nums.get(nums.size() -1);
        int pos2 = nums.get(nums.size() -2);
        int pos3 = nums.get(nums.size() -3);
        int neg1 = nums.get(0);
        int neg2 = nums.get(1);

        int posRes = pos2 * pos3;
        int negRes = neg1 * neg2;
        List<Integer> result = new ArrayList<>();
        if (negRes > posRes) {
            result.add(neg1);
            result.add(neg2);
            result.add(pos1);
        } else {
            result.add(pos2);
            result.add(pos3);
            result.add(pos1);
        }

        return result;
    }

    public static List<Integer> getThreeNums2(List<Integer> nums) {
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        int neg1 = 0;
        int neg2 = 0;

        for (Integer num : nums) {
            if (num > pos1) {
                pos3 = pos2;
                pos2 = pos1;
                pos1 = num;
            } else if (num > pos2) {
                pos3 = pos2;
                pos2 = num;
            } else if (num > pos3) {
                pos3 = num;
            } else if (num < neg1) {
                neg2 = neg1;
                neg1 = num;
            } else if (num < neg2) {
                neg2 = num;
            }
        }

        int posRes = pos2 * pos3;
        int negRes = neg1 * neg2;
        List<Integer> result = new ArrayList<>();
        if (negRes > posRes) {
            result.add(neg1);
            result.add(neg2);
            result.add(pos1);
        } else {
            result.add(pos2);
            result.add(pos3);
            result.add(pos1);
        }

        return result;
    }
}
