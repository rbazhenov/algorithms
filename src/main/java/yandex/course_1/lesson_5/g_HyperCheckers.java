package yandex.course_1.lesson_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class g_HyperCheckers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(calcDifferentScores(nums, k));
    }

    private static long calcDifferentScores(int[] nums, int k) {
        //на карточке помещаются 3 числа
        //два числа не должны различатся больше чем в k раз
        //

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        List<Integer> unique = new ArrayList<>(cnt.keySet());
        Collections.sort(unique);
        int uniqueLen = unique.size();

        long ans = 0;
        int r = 0;
        int duplicates = 0;

        for (int l = 0; l < uniqueLen; l++) {
            while (r < uniqueLen && unique.get(l) * k >= unique.get(r)) {
                if (cnt.get(unique.get(r)) > 1) {
                    duplicates++;
                }
                r++;
            }

            int rangeLen = r - l;
            if (cnt.get(unique.get(l)) > 1) {
                ans += (rangeLen - 1) * 3L; // tell me why?
                duplicates--;
            }

            if (cnt.get(unique.get(l)) > 2) {
                ans += 1;
            }

            ans += (long) (rangeLen - 1) * (rangeLen - 2) * 3;
            ans += duplicates * 3L;
        }


        return ans;
    }
}
