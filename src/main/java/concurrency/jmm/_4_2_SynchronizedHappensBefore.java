package concurrency.jmm;

/**
 * monitorEnter() -> write(x, 5) -> write(initialized, true) -> monitorExit() -> monitorEnter() -> read(initialized):true -> read(x):5 -> monitorExit() // (initialized, x) = (true, 5)
 * monitorEnter() -> read(initialized):false -> monitorExit() -> monitorEnter() -> write(x, 5) -> write(initialized, true) -> monitorExit() // (initialized, x) = (false, _)
 */
public class _4_2_SynchronizedHappensBefore {
    private final Object lock = new Object();

    private int x;
    private boolean initialized = false;

    public void writer() {
        synchronized (lock) {
            x = 5; /* W1 */
            initialized = true; /* W2 */
        } /* RELEASE */
    }

    public synchronized void reader() {
        synchronized (lock) { /* ACQUIRE */
            boolean r1 = initialized; /* R1 */
            if (r1) {
                int r2 = x; /* R2, guaranteed to see 5 */
            }
        }
    }
}
