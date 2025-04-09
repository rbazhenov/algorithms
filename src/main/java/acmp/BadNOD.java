package acmp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BadNOD {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        Set<Integer> del1 = new HashSet<>();

        int curDel = 2;
        boolean flag = true;
        do {
            if (curDel == a) {
                del1.add(curDel);
                flag = false;
            } else if (a % curDel == 0) {
                del1.add(curDel);
                a = a / curDel;
            } else {
                curDel = curDel + 1;
            }
        } while (flag);

        Set<Integer> del2 = new HashSet<>();
        curDel = 2;
        flag = true;
        do {
            if (curDel == b) {
                del2.add(curDel);
                flag = false;
            } else if (b % curDel == 0) {
                del2.add(curDel);
                b = b / curDel;
            } else {
                curDel = curDel + 1;
            }
        } while (flag);

        Set<Integer> temp = new HashSet<>(del1);
        temp.removeAll(del2); //temp has differ del1
        del1.removeAll(temp);

        Integer result = del1.stream().reduce(1, (x, y) -> x * y);

        System.out.println(result);

    }
}
