package yandex.course_2.lesson_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//нельзя из тупика на путь 1. вагон один раз заезжает с пути 1 в тупик
//--нужно решить сколько оставляем в тупике
//можно один раз выехать из тупика на путь 2
public class _14_WagonSortLite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] wagons = new int[n];
        for (int i = 0; i < n; i++) {
            wagons[i] = scanner.nextInt();
        }

        Stack<Integer> track1 = new Stack<>();
        Stack<Integer> deadEnd = new Stack<>();
        List<Integer> track2 = new ArrayList<>();

        for (int i = wagons.length - 1; i >= 0; i--) {
            track1.push(wagons[i]);
        }

        rec(track1, deadEnd, track2, n);
        boolean real = true;
        if (track2.size() == n) {
            for (int i = 1; i < n - 1; i++) {
                if (track2.get(i) < track2.get(i - 1)) {
                    real = false;
                    break;
                }
            }
        } else {
            real = false;
        }

        System.out.println(real ? "YES" : "NO");
    }

    private static void rec(Stack<Integer> track1, Stack<Integer> deadEnd, List<Integer> track2, int n) {
        //если путь 1 и тупить пустые, то выходим
        while (track2.size() != n) {
            //берём вагон с пути 1.
            if (!track1.isEmpty()) {
                Integer fromTrack1 = track1.pop();

                //Если тупик пуст, загоняем вагон с пути 1.
                //Если вагон с пути 1 меньше, чем вагон в тупике, то перемещаем его в путь 2.
                if (deadEnd.isEmpty() || fromTrack1 < deadEnd.peek()) {
                    deadEnd.push(fromTrack1);
                    //Если вагон в тупике меньше, чем вагон с пути 1, то перемещаем из тупика в путь 2.
                    //А вагон с пути 1 перемещаем в тупик
                } else {
                    Integer fromDeadEnd = deadEnd.pop();
                    track2.add(fromDeadEnd);
                    deadEnd.push(fromTrack1);
                }
            }

            //если на пути 1 не осталось вагонов, то перемеаем все из тупика на путь 2
            if (track1.isEmpty() && !deadEnd.isEmpty()) {
                while (!deadEnd.isEmpty()) {
                    track2.add(deadEnd.pop());
                }
            }
        }
    }
}
