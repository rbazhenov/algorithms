package yandex.interviewcontext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class B {

    private static long getCardCount(int n, int k, List<Long> cards) {
        long sum = 0;
        int left = 0;
        int right = n - 1;
        for(int i = 0; i < k; i++){
            long current;
            if(cards.get(left) > cards.get(right)) {
                current = cards.get(left);
                left++;
            } else {
                current = cards.get(right);
                right--;
            }

            sum = sum + current;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int k = readInt(reader);
            List<Long> cards = readList(reader);

            System.out.println(getCardCount(n, k, cards));
        }
    }

    private static List<Long> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().strip().split(" "))
                .stream()
                .map(token -> Long.parseLong(token))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}