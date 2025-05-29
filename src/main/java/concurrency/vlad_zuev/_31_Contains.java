package concurrency.vlad_zuev;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class _31_Contains {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> values = new Vector<>();
        values.add(1);
        values.add(2);
        values.add(3);

        final Runnable task = () -> addIfNotExist(values, 4);

        final Thread firstThread = new Thread(task);
        final Thread secondThread = new Thread(task);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(values);
    }

    private static void addIfNotExist(final List<Integer> values, final Integer element) {
        //метод contains является синхронизированным и захватывает монитор нашего ветора
        //планировщик потоков мог прервать первый поток после проверки и дать проверить второму потоку
        //оба потока получать результат false и добавят значение - это неккоректная работа метода.
        //для наглядности усыпим первый поток и увидим дублирование
        try {
            if (!values.contains(element)) {
                TimeUnit.MILLISECONDS.sleep(100);
                values.add(element);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
