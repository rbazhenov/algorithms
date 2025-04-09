package yandex.course_1.lesson_2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class d_BiggerThanNeighbors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(countNeighbors(nums));
    }

    public static int countNeighbors(List<Integer> nums) {
        int count = 0;
        if (nums.size() < 3) {
            return count;
        }

        for (int i = 1; i < nums.size() - 1; i++) {
            Integer prev = nums.get(i - 1);
            Integer cur = nums.get(i);
            Integer next = nums.get(i + 1);
            if (cur>prev && cur>next){
                count++;
            }
        }

        return count;
    }
}
