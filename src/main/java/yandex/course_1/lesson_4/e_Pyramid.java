package yandex.course_1.lesson_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class e_Pyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] sizes = new int[n][2];
        for (int i = 0; i < n; i++) {
            List<Integer> wh = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            sizes[i][0] = wh.get(0);
            sizes[i][1] = wh.get(1);
        }

        Arrays.sort(sizes, Comparator.comparingInt(x -> x[0]));
        System.out.println(getMaxHeight(sizes));
    }

    private static int getMaxHeight(int[][] sizes) {
        int maxHeight = sizes[0][1];
        for (int i = 1; i < sizes.length; i++) {
            int prevWidth = sizes[i - 1][0];
            int prevHeight = sizes[i - 1][1];
            int currentWidth = sizes[i][0];
            int currentHeight = sizes[i][1];
            if (prevWidth == currentWidth && currentHeight > prevHeight) {
                maxHeight = maxHeight - prevHeight + currentHeight;
            } else if (prevWidth != currentWidth) {
                maxHeight += currentHeight;
            }
        }
        return maxHeight;
    }
}
