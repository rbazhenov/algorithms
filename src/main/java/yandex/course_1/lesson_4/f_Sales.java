package yandex.course_1.lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class f_Sales {
    public static void main(String[] args) {
        List<String> sales = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String line = reader.readLine();
            while (line != null && !line.isBlank()) {
                sales.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

        Map<String, Map<String, Integer>> customers = group(sales);
        print(customers);
    }

    public static void print(Map<String, Map<String, Integer>> customers) {
        Map<String, Map<String, Integer>> sortedCustomers = new TreeMap<>(customers);
        sortedCustomers.forEach((key, value) -> {
            System.out.println(key + ":");
            Map<String, Integer> sortedProducts = new TreeMap<>(value);
            sortedProducts.forEach((k, v) -> System.out.println(k + " " + v));
        });
    }

    public static Map<String, Map<String, Integer>> group(List<String> sales) {
        Map<String, Map<String, Integer>> customers = new HashMap<>();
        sales.forEach(s -> {
            String[] values = s.split(" ");
            String customer = values[0];
            String product = values[1];
            Integer count = Integer.parseInt(values[2]);

            if (customers.containsKey(customer)) {
                Map<String, Integer> productCount = customers.get(customer);
                productCount.put(product, productCount.getOrDefault(product, 0) + count);
            } else {
                Map<String, Integer> productCount = new HashMap<>();
                productCount.put(product, count);
                customers.put(customer, productCount);
            }
        });

        return customers;
    }
}
