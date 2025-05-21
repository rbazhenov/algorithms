package concurrency.jmm;

/**
 * Если в Dekker lock мы пометим обе переменные как volatile, то свяжем все действия с переменными в SO и получим только SC выполнения.
 * (0, 1), (1, 0), (1, 1)
 */
public class _3_DekkerVolatile {
    private volatile int x;
    private volatile int y;

    public void T1() {
        x = 1;
        int r1 = y;
    }

    public void T2() {
        y = 1;
        int r2 = x;
    }
}
