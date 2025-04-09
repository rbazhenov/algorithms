package yandex.course_1.lesson_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class g_BankAccounts {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            Map<String, Integer> accounts = new HashMap<>();
            String line = reader.readLine();
            while (line != null && !line.isBlank()) {
                String[] split = line.split(" ");
                String operation = split[0];
                if (operation.equalsIgnoreCase(Operation.DEPOSIT.name())) {
                    deposit(split, accounts);
                } else if (operation.equalsIgnoreCase(Operation.WITHDRAW.name())) {
                    withdraw(split, accounts);
                } else if (operation.equalsIgnoreCase(Operation.TRANSFER.name())) {
                    transfer(split, accounts);
                } else if (operation.equalsIgnoreCase(Operation.BALANCE.name())) {
                    balance(split, accounts);
                } else if (operation.equalsIgnoreCase(Operation.INCOME.name())) {
                    income(split, accounts);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
        }
    }

    private static void deposit(String[] split, Map<String, Integer> accounts) {
        String owner = split[1];
        int amount = Integer.parseInt(split[2]);
        accounts.put(owner, accounts.getOrDefault(owner, 0) + amount);
    }

    private static void withdraw(String[] split, Map<String, Integer> accounts) {
        String owner = split[1];
        int amount = Integer.parseInt(split[2]);
        accounts.put(owner, accounts.getOrDefault(owner, 0) - amount);
    }

    private static void transfer(String[] split, Map<String, Integer> accounts) {
        String owner1 = split[1];
        String owner2 = split[2];
        int amount = Integer.parseInt(split[3]);
        accounts.put(owner1, accounts.getOrDefault(owner1, 0) - amount);
        accounts.put(owner2, accounts.getOrDefault(owner2, 0) + amount);
    }

    private static void balance(String[] split, Map<String, Integer> accounts) {
        String owner = split[1];
        if (accounts.containsKey(owner)) {
            System.out.println(accounts.get(owner));
        } else {
            System.out.println("ERROR");
        }
    }

    private static void income(String[] split, Map<String, Integer> accounts) {
        Integer percent = Integer.parseInt(split[1]);

        accounts.forEach((owner, amount) -> accounts.put(owner, amount + (amount / 100) * percent));
    }

    enum Operation {

        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        BALANCE,
        INCOME,
        ;
    }
}
