package concurrency.vlad_zuev;

import static java.lang.Thread.currentThread;

import java.util.stream.IntStream;

public class _1_Creation {
    public static void main(String[] args) {
        System.out.println(currentThread().getName());

        //1
        final Thread thread = new MyThread();
        thread.start();

        //2
        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println(currentThread().getName());
            }
        };
        thread2.start();

        //3
        Runnable task = () -> System.out.println(currentThread().getName());
        Thread thread3 = new Thread(task);
        thread3.start();

        //4 создали и запустили 10 потоков
        final Runnable taskCreatingThreads = () ->
                IntStream.range(0, 10)
                        .forEach(i -> startThread(task));
        startThread(taskCreatingThreads);
    }

    private static void startThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.start();
    }


    private static final class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(currentThread().getName());
        }
    }
}
