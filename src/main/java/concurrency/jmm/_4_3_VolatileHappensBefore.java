package concurrency.jmm;

/**
 * Здесь по сравнению с предыдущим примером возможных SC порядков побольше, так как нет эксклюзивного захвата лока, но итоговый сет результатов все равно остается таким же.
 * write(x, 5) -> write(initialized, true) -> read(initialized):true -> read(x):5 // (initialized, x) = (true, 5)
 * write(x, 5) -> read(initialized):false -> write(initialized, true) // (initialized, x) = (false, _)
 * read(initialized):false -> write(x, 5) -> write(initialized, true) // (initialized, x) = (false, _)
 * </br>
 * Все действия до release или после acquire могут быть переупорядочены под капотом как угодно. Но главное то, что они не будут переупорядочены с самим release/acquire действием.
 * Например, если мы имеем действия [W1, W2, W3, RELEASE], то [W1, W2, W3] могут быть переупорядочены под капотом как угодно, но они всегда будут выполнены до RELEASE действия.
 */
public class _4_3_VolatileHappensBefore {
    private int x;
    private volatile boolean initialized;

    public void writer() {
        x = 5; /* W1 */
        initialized = true; /* W2 */
    }

    public void reader() {
        boolean r1 = initialized; /* R1 */
        if (r1) { //если убрать эту проверку, то результат действия присваение значения r2, будет неизвестен.
            int r2 = x; /* R2, guaranteed to see 5 */
        }
    }
}
