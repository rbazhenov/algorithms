package interview.vk;

import java.util.Arrays;

/**
 * Написать метод, который заменит все пробелы в массиве на "%20" inplace.
 * На вход подается массив с зарезервированными под расширение символами в конце массива.
 * Пример:
 * Input: ['j','a','v','a',' ','t','a','s','k', '\0', '\0']
 * Output: ['j','a','v','a','%','2','0','t','a','s','k']
 * <p>
 * Ограничения: O(1) по памяти, O(N) по времени, необходимо менять исходный массив.
 */
public class ReplaceSpaceWith3Symbol {

    public static void main(String[] args) {
        char[] input = {'j', 'a', 'v', 'a', ' ', 't', 'a', 's', 'k', '\0', '\0'};
        urlEncodeSpaces(input);
        System.out.println(Arrays.toString(input));
    }

    public static void urlEncodeSpaces(char[] input) {
        int j = input.length - 1;
        for (int i = input.length - 2; i >= 0; i--) {
            char cur = input[i];

            if (cur != '\0' && !Character.isWhitespace(cur)) {
                input[j--] = input[i];
            } else if (Character.isWhitespace(cur)) {
                input[j - 2] = '%';
                input[j - 1] = '2';
                input[j] = '0';
                j -= 3;
            }
        }
    }
}
