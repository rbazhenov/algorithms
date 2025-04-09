package yandex.course_1.lesson_2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class c_NearestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int x = Integer.parseInt(scanner.nextLine());

        System.out.println(nearest(nums, x));
    }

    public static int nearest(List<Integer> nums, int x) {
        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            Integer cur = nums.get(i);
            if (cur == x){
                return cur;
            }
            if (Math.abs(x-cur) < Math.abs(x-res)){
                res = cur;
            }
        }

        return res;
    }
}
