package concurrency.vlad_zuev._24_livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    public static void main(String[] args) {
        Lock firstGivenLock = new ReentrantLock();
        Lock secondGivenLock = new ReentrantLock();

        //liveLock
        Thread firstGivenThread = new Thread(new Task(firstGivenLock, secondGivenLock));
        Thread secondGivenThread = new Thread(new Task(secondGivenLock, firstGivenLock));

//        Thread firstGivenThread = new Thread(new Task(firstGivenLock, secondGivenLock));
//        Thread secondGivenThread = new Thread(new Task(firstGivenLock, secondGivenLock));

        firstGivenThread.start();
        secondGivenThread.start();
    }
}
