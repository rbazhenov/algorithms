package concurrency.jmm;

/**
 * Возможные результаты:
 * (0, 1), (1, 0), (1, 1), (0,0)
 */
public class _1_MemoryReorderingExample {
    private int x;
    private int y;

    public void T1() {
        x = 1;
        int r1 = y;
    }

    public void T2() {
        y = 1;
        int r2 = x;
    }

}
