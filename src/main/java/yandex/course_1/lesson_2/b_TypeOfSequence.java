package yandex.course_1.lesson_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b_TypeOfSequence {

    public static void main(String[] args) {
        List<Integer> nums = parseList();
        if (nums.isEmpty()) {
            System.out.println(Sequence.RANDOM.getName());
        } else {
            Sequence sequence = getSequence(nums);
            System.out.println(sequence.getName());
        }

    }

    public static List<Integer> parseList() {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = new ArrayList<>();
        boolean hasNext = true;
        while (hasNext) {
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                return List.of();
            }

            if (!s.equalsIgnoreCase("-2000000000")) {
                int num = Integer.parseInt(s);
                nums.add(num);
            } else {
                hasNext = false;
            }
        }
        return nums;
    }

    public static Sequence getSequence(List<Integer> nums) {
        int prev = nums.get(0);

        boolean isConstant = true;
        boolean isAscending = true;
        boolean isWeaklyAscending = true;
        boolean isDescending = true;
        boolean isWeaklyDescending = true;
        for (int i = 1; i < nums.size(); i++) {
            Integer cur = nums.get(i);
            if (prev == cur) {
                isDescending = false;
                isAscending = false;
            }
            if (prev > cur) {
                isConstant = false;
                isAscending = false;
                isWeaklyAscending = false;
            }
            if (prev < cur) {
                isConstant = false;
                isDescending = false;
                isWeaklyDescending = false;
            }

            if (!isConstant && !isAscending && !isWeaklyAscending && !isDescending && !isWeaklyDescending) {
                return Sequence.CONSTANT;
            }
        }

        if (isConstant) {
            return Sequence.CONSTANT;
        }
        if (isAscending) {
            return Sequence.ASCENDING;
        }
        if (isWeaklyAscending) {
            return Sequence.WEAKLY_ASCENDING;
        }
        if (isDescending) {
            return Sequence.DESCENDING;
        }
        if (isWeaklyDescending) {
            return Sequence.WEAKLY_DESCENDING;
        }

        return Sequence.RANDOM;
    }

    public enum Sequence {
        CONSTANT("CONSTANT"),//последовательность состоит из одинаковых значений
        ASCENDING("ASCENDING"),//последовательность является строго возрастающей
        WEAKLY_ASCENDING("WEAKLY ASCENDING"),//последовательность является нестрого возрастающей
        DESCENDING("DESCENDING"),//последовательность является строго убывающей
        WEAKLY_DESCENDING("WEAKLY DESCENDING"),
        RANDOM("RANDOM"); //последовательность не принадлежит ни к одному из вышеупомянутых типов

        private final String name;

        Sequence(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
