package acmp;

import java.util.Scanner;

/**
 * Время прибытия. 15%
 */
public class TrainArrival {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String way = scanner.nextLine();

        String[] splitStart = start.split(":");
        int startHour = Integer.parseInt(splitStart[0]);
        int startMinute = Integer.parseInt(splitStart[1]);

        String[] splitWay = way.split(" ");
        int wayHour = Integer.parseInt(splitWay[0]);
        int wayMinute = Integer.parseInt(splitWay[1]);

        int plusHours = wayHour > 24 ? wayHour % 24 : wayHour;
        int resHours = (startHour + plusHours) > 24 ? (startHour + plusHours) - 24 : (startHour + plusHours);

        int allMinutes = startMinute + wayMinute;
        int resMinute;
        if (allMinutes < 60) {
            resMinute = allMinutes;
        } else {
            resHours = resHours + 1 == 24 ? 0 : resHours + 1;
            if (allMinutes == 60) {
                resMinute = 0;
            } else {
                resMinute = allMinutes - 60;
            }
        }

        String resH = resHours > 9 ? resHours + "" : "0" + resHours;
        String resM = resMinute > 9 ? resMinute + "" : "0" + resMinute;
        System.out.println(resH + ":" + resM);
    }
}
