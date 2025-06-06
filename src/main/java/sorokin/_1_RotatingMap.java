package sorokin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Есть мультимапа.
 * 1 -> [0, 1, 2]
 * 2 -> [3, 4]
 * Требуется развернуть мапу с использованием StreamAPI (можем считать, что коллизий не возникнет).
 * 0 -> 1; 1 -> 1; 2 -> 1; 3 -> 2; 4 -> 2;
 */
public class _1_RotatingMap {

    public static void main(String[] args) {
        Map<Integer, List<Long>> inputMap = new HashMap<>();
        inputMap.put(1, Arrays.asList(0L, 1L, 2L));
        inputMap.put(2, Arrays.asList(3L, 4L));

        System.out.println(rotate(inputMap));
    }

    private static Map<Long, Integer> rotate (Map<Integer, List<Long>> inputMap) {
        return inputMap.entrySet().stream()
                .flatMap(entry -> {
                    Integer key = entry.getKey();
                    List<Long> values = entry.getValue();
                    return values.stream()
                            .map(v -> Map.entry(v, key));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
