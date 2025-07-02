package interview.yandex.notmy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Дан массив целых неотприцательных чисел, нужно сгруппировать друг с другом числа,
 * которые можно получить путём перестановки цифр их составляющих,
 * нули при это игнорируем, т.к. нет числа 011.
 * Решение должно быть максимально эффективно по памяти и времени.
 * Пример:
 * {1230, 99, 23001, 123, 111, 300021, 101010, 90000009, 9}
 * -> [[99, 90000009], [111, 101010], [1230, 23001, 300021], [9]]
 */
public class DigitPermutation {
    public static void main(String[] args) {
        int[] arr = {1230, 99, 23001, 123, 111, 300021, 101010, 90000009, 9};
        System.out.println(digitPermutation(arr));
    }

    private static List<List<Integer>> digitPermutation(int[] arr) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int digit : arr) {
            String key = String.valueOf(digit)
                    .replaceAll("0", "")
                    .chars()
                    .mapToObj(i -> (char) i)
                    .sorted()
                    .map(Object::toString)
                    .collect(Collectors.joining(""));
            if (map.containsKey(key)) {
                map.get(key).add(digit);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(digit);
                map.put(key, value);
            }
        }

        return new ArrayList<>(map.values());
    }
}
