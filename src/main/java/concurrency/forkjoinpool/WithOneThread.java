package concurrency.forkjoinpool;

import java.util.Date;

public class WithOneThread {
    public static void main(String[] args) throws InterruptedException {
        int[] array = getInitArray(10000);
        System.out.println(new Date());
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            Thread.sleep(1);
            sum += array[i];
        }
        System.out.println(sum);
        System.out.println(new Date());
    }

    public static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = 1;
        }

        return array;
    }
}
