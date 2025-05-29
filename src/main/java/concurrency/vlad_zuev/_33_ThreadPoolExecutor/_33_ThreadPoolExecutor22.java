package concurrency.vlad_zuev._33_ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class _33_ThreadPoolExecutor22 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                3,
                1,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(3)
        );

        executor.execute(() -> {
            System.out.println("Hello");
            while (true){

            }
        });
        executor.execute(() -> {
            System.out.println("Hi");
            while (true){

            }
        });
        executor.execute(() -> {
            System.out.println("Bye. in queue");
            while (true){

            }
        });
        executor.execute(() -> {
            System.out.println("Ok, Bye. in queue");
            while (true){

            }
        });
        executor.execute(() -> {
            System.out.println("i am last of size in queue");
            while (true){

            }
        });

        //new Thread created by main thread
        executor.execute(() -> {
            System.out.println("Work without queue");
            while (true){

            }
        });

        //new Thread created by main thread
        executor.execute(() -> {
            System.out.println("No space( -> Exception");
            while (true){

            }
        });
    }
}
