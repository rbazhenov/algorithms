package yandex.course_1.lesson_1;

import java.util.Scanner;

public class h_Subway {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int interval1 = Integer.parseInt(scanner.nextLine());
        int interval2 = Integer.parseInt(scanner.nextLine());
        int trains1 = Integer.parseInt(scanner.nextLine());
        int trains2 = Integer.parseInt(scanner.nextLine());

        int min1 = trains1 + (trains1 - 1) * interval1;
        int min2 = trains2 + (trains2 - 1) * interval2;
        int min = Math.max(min1, min2);

        int max1 = trains1 + (trains1 + 1) * interval1;
        int max2 = trains2 + (trains2 + 1) * interval2;
        int max = Math.min(max1, max2);

        if (max < min) {
            System.out.println(-1);
        } else {
            System.out.println(min + " " + max);
        }
    }

    //omg
//    public static int[] minMaxStandTime(int interval1, int interval2, int trains1, int trains2) {
//        int[] res = new int[2];
//        if (trains1 == 0 && trains2 == 0) {
//            res[0] = 0;
//            res[1] = Math.min(interval1, interval2);
//            return res;
//        }
//
//        //train is
//        int minWay1 = trains1 + interval1 * (trains1 - 1);
//        int minWay2 = trains2 + interval2 * (trains2 - 1);
//        int minTime = minTime(minWay1, minWay2, interval1, interval2);
//        if (minTime < 0) {
//            res[0] = -1;
//            return res;
//        } else {
//            res[0] = minTime;
//        }
//
//        //no trains
//        int maxWay1 = interval1 + trains1 + interval1 * trains1;
//        int maxWay2 = interval2 + trains2 + interval2 * trains2;
//        int maxTime = maxTime(maxWay1, maxWay2, interval1, interval2);
//        if (maxTime < 0) {
//            res[1] = -1;
//            return res;
//        } else {
//            res[1] = maxTime;
//        }
//
//        return res;
//    }
//
//    public static int maxTime(int maxTime1, int maxTime2, int interval1, int interval2) {
//        if (maxTime1 == maxTime2) {
//            return maxTime1;
//        }
//        //первое время большее, второе меньшее
//        if (maxTime1 < maxTime2) {
//            int temp = maxTime1;
//            maxTime1 = maxTime2;
//            maxTime2 = temp;
//
//            temp = interval1;
//            interval1 = interval2;
//            interval2 = temp;
//        }
//
//        if (maxTime1 - 2 * interval1 <= maxTime2) {
//            return maxTime2;
//        }
//
//        return -1;
//
////        boolean flag = true;
////        int max = -1;
////        while (flag){
////            boolean hasExtra = maxTime1 - maxTime2 > interval2;
////            if (hasExtra) {
////                if (interval1 > 0) {
////                    interval1--;
////                } else {
////                    flag = false;
////                }
////            } else {
////                max = maxTime1 - maxTime2 - interval1;
////                flag = false;
////            }
////        }
////
////        return max;
//    }
//
//    public static int minTime(int minTime1, int minTime2, int interval1, int interval2) {
//        if (minTime1 == minTime2) {
//            return minTime1;
//        }
//        //первое время большее, второе меньшее
//        if (minTime1 < minTime2) {
//            int temp = minTime1;
//            minTime1 = minTime2;
//            minTime2 = temp;
//
//            temp = interval1;
//            interval1 = interval2;
//            interval2 = temp;
//        }
//
//        //останется ли 1, если вычесть меньший интервал из большего времени
//        return minTime1 - minTime2 > interval2 ? -1 : minTime1;
//    }

}
