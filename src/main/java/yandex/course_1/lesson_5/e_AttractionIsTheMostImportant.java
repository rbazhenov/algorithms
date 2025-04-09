package yandex.course_1.lesson_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class e_AttractionIsTheMostImportant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt(); // types
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        List<Integer> segment = findSegment(nums, k);
        int l = segment.get(0) + 1;
        int r = segment.get(1) + 1;
        System.out.println(l + " " + r);
        //вывести индексы + 1 отрезка, если ответов несколько, то любой
    }

    //найти наименьший отрезок, где будет каждого вида дерева, как минимум по 1 шт
    private static List<Integer> findSegment(int[] nums, int k) {
        List<List<Integer>> intervals = new ArrayList<>();
        Map<Integer, Integer> dict = new HashMap<>();
        dict.put(nums[0], 1);

        int l = 0;
        int r = 0;
        int lastIndex = nums.length - 1;
        boolean toNextR = false;
        boolean toNextL = false;
        while (r < lastIndex || r - l > k - 1) {
            if (dict.size() == k) {
                //нашли самый маленький отрезок, вернём значения индекс
                if (r - l == k - 1) {
                    List<Integer> result = new ArrayList<>();
                    result.add(l);
                    result.add(r);
                    return result;
                }

                List<Integer> interval = new ArrayList<>();
                interval.add(l);
                interval.add(r);
                intervals.add(interval);

                toNextL = true;

                if (l == r) {
                    toNextR = true;
                }
            } else {
                toNextR = true;
            }

            if (toNextR) {
                if (r < lastIndex) {
                    r++;
                    int key = nums[r];
                    dict.put(key, dict.getOrDefault(key, 0) + 1);
                    toNextR = false;
                } else {
                    toNextL = true;
                }
            }
            if (toNextL) {
                int oldKey = nums[l];
                dict.put(oldKey, dict.get(oldKey) - 1);
                if (dict.get(oldKey) == 0) {
                    dict.remove(oldKey);
                }
                l++;
                toNextL = false;
            }
        }

        //поиск самого короткого сегмента
        int minSegment = nums.length;
        int minSegmentIndex = -1;
        for (int i = 0; i < intervals.size(); i++) {
            int difference = intervals.get(i).get(1) - intervals.get(i).get(0);
            if (difference < minSegment) {
                minSegment = difference;
                minSegmentIndex = i;
            }
            if (difference == k - 1) {
                return intervals.get(minSegmentIndex);
            }
        }

        return intervals.get(minSegmentIndex);
    }
}
