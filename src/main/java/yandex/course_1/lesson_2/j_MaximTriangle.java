package yandex.course_1.lesson_2;

import java.util.Scanner;

public class j_MaximTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());//кол-во нот
        int[] records = new int[n];
        String[] recordsStr = new String[n];
        records[0] = Integer.parseInt(scanner.nextLine());
        recordsStr[0] = "";

        for (int i = 1; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            records[i] = Integer.parseInt(s[0]);
            recordsStr[i] = s[1];
        }

        float[] triangleRange = triangleRange(records, recordsStr);
        System.out.println(triangleRange[0] + " " + triangleRange[1]);
    }

    public static float[] triangleRange(int[] nums, String[] values) {
        float left = 30;
        float right = 4000;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int cur = nums[i];
            if (Math.abs(cur - prev) < Math.pow(10, -6)) {
                continue;
            }
            if (values[i].equalsIgnoreCase("closer")) {
                if (prev > cur) {
                    right = Math.min(right, (float) (prev + cur) / 2);
                } else {
                    left = Math.max(left, (float) (cur + prev) / 2);
                }
            } else {
                if (prev > cur) {
                    left = Math.max(left, (float) (cur + prev) / 2);
                } else {
                    right = Math.min(right, (float) (prev + cur) / 2);
                }
            }
        }
        return new float[]{left, right};
    }
}
