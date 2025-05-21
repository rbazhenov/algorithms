package concurrency.jmm;

/**
 * Можно подумать, что если мы прочитали значение true на R1, то прочитаем и значение 5 на R2, так как в порядке программы запись в x идет перед записью в initialized.
 * Но на самом деле мы можем наблюдать значение по умолчанию (0) при чтении x по следующим причинам:
 * 1. Instructions reordering (1/2) — записи W1 и W2 были переставлены местами
 * 2. Instructions reordering (2/2) — чтения R1 и R2 были переставлены местами
 * 3. Visibility — запись в x не пропагирована другим ядрам на момент чтения
 * </br>
 * С точки зрения программы мы говорим, что произошли StoreStore или LoadLoad переупорядочивания. Это ожидаемо, ведь мы имеем две гонки: при доступе к x и initialized.
 * А соответственно, нам не гарантируются только sequentially consistent выполнения, ведь такие переупорядочивания валидны с точки зрения JMM при наличии гонок.
 */
public class _4_1_MemoryReorderingExample {
    private int x;
    private boolean initialized = false;

    public void writer() {
        x = 5; /* W1 */
        initialized = true; /* W2 */
    }

    public void reader() {
        boolean r1 = initialized; /* R1 */
        if (r1) {
            int r2 = x; /* R2, may read default value (0) */
        }
    }
}
