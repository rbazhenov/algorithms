package yandex.course_1.lesson_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class g_BiggestMultiplicationOfTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> twoNums = getTwoNums2(nums);
        System.out.println(twoNums.get(0) + " " + twoNums.get(1));
    }

    public static List<Integer> getTwoNums(List<Integer> nums) {
        int pos1, pos2;
        if (nums.get(0) > nums.get(1)) {
            pos1 = nums.get(0);
            pos2 = nums.get(1);
        } else {
            pos2 = nums.get(0);
            pos1 = nums.get(1);
        }

        int neg1 = pos2;
        int neg2 = pos1;

        for (Integer num : nums) {
            if (num > pos1) {
                pos2 = pos1;
                pos1 = num;
            } else if (num > pos2) {
                pos2 = num;
            }

            if (num < neg1) {
                neg2 = neg1;
                neg1 = num;
            } else if (num < neg2) {
                neg2 = num;
            }
        }

        int posRes = pos1 * pos2;
        int negRes = neg1 * neg2;

        List<Integer> result = new ArrayList<>();
        if (posRes > negRes) {
            result.add(pos2);
            result.add(pos1);
        } else {
            result.add(neg1);
            result.add(neg2);
        }

        return result;
    }

    public static List<Integer> getTwoNums2(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int bigPos1 = 0;
        int bigPos2 = 0;
        int bigNeg1 = 0;
        int bigNeg2 = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (key > 0 && key > bigPos1) {
                bigPos2 = bigPos1;
                bigPos1 = key;
                if (count > 1) {
                    bigPos2 = key;
                }
            }
            if (key < 0 && key < bigNeg1) {
                bigNeg2 = bigNeg1;
                bigNeg1 = key;
                if (count > 1) {
                    bigNeg2 = key;
                }
            }
        }

        int negRes = 0;
        if (bigNeg1 < 0 && bigNeg2 < 0) {
            negRes = bigNeg1 * bigNeg2;
        }

        int posRes = 0;
        if (bigPos1 > 0 && bigPos2 > 0) {
            posRes = bigPos1 * bigPos2;
        }

        List<Integer> result = new ArrayList<>();
        if (bigNeg2 == 0 && bigPos2 == 0) {
            result.add(bigNeg1);
            result.add(bigPos1);
            return result;
        }

        if (Math.abs(negRes) > posRes) {
            result.add(bigNeg1);
            result.add(bigNeg2);
            return result;
        }

        result.add(bigPos2);
        result.add(bigPos1);

        return result;
    }
}
