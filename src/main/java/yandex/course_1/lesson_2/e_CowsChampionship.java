package yandex.course_1.lesson_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class e_CowsChampionship {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(getPlace(nums));
    }

    public static int getPlace(List<Integer> nums) {
        if (nums.size() < 3) {
            return 0;
        }

        //find winner
        int winnerRes = nums.get(0);
        Map<Integer, Integer> dic = new HashMap<>();
        int firstWinnerIndex = 0;
        int lastWinnerIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            Integer cur = nums.get(i);
            dic.put(cur, dic.getOrDefault(cur, 0) + 1);

            if (cur > winnerRes) {
                winnerRes = cur;
                firstWinnerIndex = i;
            }
            if (cur == winnerRes) {
                lastWinnerIndex = i;
            }
        }

        if (lastWinnerIndex == nums.size() - 1) {
            return 0;
        }

        //find biggest Vasya result
        int vasyaRes = -1;
        for (int i = firstWinnerIndex + 1; i < nums.size() - 1; i++) {
            Integer current = nums.get(i);
            if (current % 10 == 5 && current > nums.get(i + 1) && (current > vasyaRes)) {
                vasyaRes = current;
            }
        }

        if (vasyaRes < 1) {
            return 0;
        }

        int place = 1;
        for (Map.Entry<Integer, Integer> entry : dic.entrySet()) {
            if (entry.getKey() > vasyaRes) {
                place = place + entry.getValue();
            }
        }

        return place;
    }
}
