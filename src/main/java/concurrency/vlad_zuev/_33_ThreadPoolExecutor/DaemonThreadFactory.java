package concurrency.vlad_zuev._33_ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

/**
 * Если захотим создавать потоки деманы.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        final Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
