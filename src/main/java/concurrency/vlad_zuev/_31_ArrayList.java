package concurrency.vlad_zuev;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 *
 */
public class _31_ArrayList {
    public static void main(String[] args) throws InterruptedException {
        //Результат ожидаем 2000. Но возможны неожидаемые результаты или ошибка ArrayIndexOutOfBoundsException
//        final List<Integer> values = new ArrayList<>();
        final List<Integer> values = new Vector<>();
        final Runnable task = () -> IntStream.range(0, 1000).forEach(values::add);

        final Thread firstThread = new Thread(task);
        final Thread secondThread = new Thread(task);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println(values.size());
    }
}
