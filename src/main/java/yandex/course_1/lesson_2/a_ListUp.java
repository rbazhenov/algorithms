package yandex.course_1.lesson_2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class a_ListUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(isUp(nums)?"YES":"NO");
    }

    public static boolean isUp(List<Integer> nums)  {
        if (nums.isEmpty()){
            return false;
        }
        if (nums.size() == 1){
            return true;
        }
        for (int i = 0; i < nums.size()-1; i++) {
            if (nums.get(i)  >= nums.get(i+1)){
                return false;
            }
        }
        return true;
    }

}
