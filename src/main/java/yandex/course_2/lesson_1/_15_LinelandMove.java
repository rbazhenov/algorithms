package yandex.course_2.lesson_1;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//найти следующее меньшее справа
//если его нет, то -1
public class _15_LinelandMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> costs = Stream.of(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cost = costs.get(i);

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek()[1] > cost) {
                    int[] pop = stack.pop();
                    answer[pop[0]] = i;
                }
            }

            int[] index2value = new int[2];
            index2value[0] = i;
            index2value[1] = cost;
            stack.push(index2value);
        }

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = -1;
        }

        //print result
        StringBuilder builder = new StringBuilder();
        for (int i : answer) {
            builder.append(i);
            builder.append(" ");
        }
        System.out.println(builder);
    }
}
