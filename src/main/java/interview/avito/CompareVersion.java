package interview.avito;

/**
 * Даны две строки с версиями.
 * Нужно реализовать функцию, которая сравнит версии между собой и вернет ответ в less-формате (0, 1, -1).
 * Каждая версия задается строкой следующего формата:
 * <p>
 * буква "v"
 * комбинация точек и чисел
 * другие знаки не разрешены
 * Пример
 * v11.22.44
 * v11.22.45
 * Ответ: 1
 * <p>
 * v11.22.44
 * v11.22.44
 * Ответ: 0
 * <p>
 * v023.115 - невалидно
 * v0.23.11.5 - валидно
 * <p>
 * v0.23.11.5.0.0.0.0.0
 * v0.23.11.5.0.0.0.0.1
 */
public class CompareVersion {

    public static void main(String[] args) {
        String v1 = "v11.22.44";
        String v2 = "v11.22.45";

        String v3 = "v11.22.44";
        String v4 = "v11.22.44";

        String v5 = "v0.23.11.5";
        String v6 = "v0.23.11.5.0.0.0.0.0";

        String v7 = "v0.23.11.5";
        String v8 = "v0.23.11.5.0.0.0.0.1";

        System.out.println(compare(v1, v2));
        System.out.println(compare(v3, v4));
        System.out.println(compare(v5, v6));
        System.out.println(compare(v7, v8));
    }


    public static int compare(String v1, String v2) {
        v1 = v1.substring(1);
        v2 = v2.substring(1);

        String[] nums1 = v1.split("\\.");
        String[] nums2 = v2.split("\\.");

        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
            int n1 = 0;
            int n2 = 0;
            if (i < nums1.length) {
                n1 = Integer.parseInt(nums1[i]);
            }
            if (i < nums2.length) {
                n2 = Integer.parseInt(nums2[i]);
            }

            if (n1 > n2) {
                return -1;
            } else if (n2 > n1) {
                return 1;
            }
        }

        return 0;
    }
}
