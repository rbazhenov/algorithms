package yandex.course_1.lesson_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class j_Triangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }

        System.out.println(countIsoscelesTriangle(xy));
    }

    private static long countIsoscelesTriangle(int[][] xy) {
        long ans = 0;
        for (int i = 0; i < xy.length; i++) {
            Set<String> usedVec = new HashSet<>();
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < xy.length; j++) {
                int vecX = xy[i][0] - xy[j][0];
                int vecY = xy[i][1] - xy[j][1];
                int lenVec = vecX * vecX + vecY * vecY; // no len, just square
                neighbors.add(lenVec);

                String vecKey = vecX + "," + vecY;
                String negVecKey = (-vecX) + "," + (-vecY);
                if (usedVec.contains(vecKey)) {
                    ans--;
                }
                usedVec.add(negVecKey);
            }

            Collections.sort(neighbors);
            int r = 0;
            for (int l = 0; l < neighbors.size(); l++) {
                while (r < neighbors.size() && neighbors.get(l).equals(neighbors.get(r))) {
                    r++;
                }
                ans += r - l - 1;
            }
        }

        return ans;
    }
}
