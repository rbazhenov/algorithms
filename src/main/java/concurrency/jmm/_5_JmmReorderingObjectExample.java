package concurrency.jmm;

/**
 * В данной программе мы можем наблюдать дефолтное значение на чтении R2 из-за StoreStore переупорядочивания
 * (запись ссылки W2 произошла перед записью в конструкторе W1) или LoadLoad переупорядочивания (чтение R2 случилось перед чтением R1).
 * </br>
 * Но как только мы пометим переменную instance как volatile или будем читать/писать под монитором, то такие переупорядочивания будут невозможны благодаря транзитивности happens-before:
 * write(x, 5) --hb-> write(volatile instance, ref) --hb-> read(volatile instance):ref -> read(x): 5
 * monitorEnter() --hb-> write(x, 5) --hb-> write(instance, ref) --hb-> monitorExit() --hb-> monitorEnter() --hb-> read(instance):ref --hb-> read(x): 5 --hb-> monitorExit()
 */
public class _5_JmmReorderingObjectExample {
    private Foo instance; //если поментим volatile

    private static class Foo {
        private int x;

        Foo() {
            this.x = 5; /* W1 */
        }
    }

    public void writer() {
        instance = new Foo(); /* W2, non-safe publish */
    }

    public void reader() {
        Foo r1 = instance; /* R1 */
        if (r1 != null) {
            int r2 = r1.x; /* R2: may be default value (0) */
        }
    }
}
