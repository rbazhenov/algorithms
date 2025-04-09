package acmp;

import java.util.Scanner;

public class LuckyTicket {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String ticket = scanner.nextLine();
            String res = "Yes";
            if (!isLucky(Integer.parseInt(ticket) + 1)) {
                if (!isLucky(Integer.parseInt(ticket) - 1)) {
                    res = "No";
                }
            }
            System.out.println(res);
        }

    }

    private static boolean isLucky(Integer newValue) {
        String strNewValue = String.valueOf(newValue);
        int dif = 6 - strNewValue.length();
        if (dif != 0) {
            String nol = "";
            for (int i = 0; i < dif; i++) {
                nol = nol + "0";
            }
            strNewValue = nol + strNewValue;
        }
        String[] fstPart = strNewValue.substring(0, 3).split("");
        String[] scdPart = strNewValue.substring(3, 6).split("");

        int a = Integer.parseInt(fstPart[0]) + Integer.parseInt(fstPart[1]) + Integer.parseInt(fstPart[2]);
        int b = Integer.parseInt(scdPart[0]) + Integer.parseInt(scdPart[1]) + Integer.parseInt(scdPart[2]);

        return a == b;
    }
}
