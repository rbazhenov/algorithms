package sorokin;

import jakarta.annotation.Nonnull;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Сервис, определяющий резрешено ли пользователю делать операцию на основе лимитов операций
 */
public class _6_UserOperationLimiter {

    private final Map<OperationType, Map<String, Queue<Operation>>> operationsMapQueue;

    private final Long readLimitPerMinute;
    private final Long writeLimitPerMinute;

    public _6_UserOperationLimiter(
            @Nonnull List<User> users,
            @Nonnull Long readLimitPerMinute,
            @Nonnull Long writeLimitPerMinute
    ) {
        this.readLimitPerMinute = readLimitPerMinute;
        this.writeLimitPerMinute = writeLimitPerMinute;

        Map<String, Queue<Operation>> readOperations = users.stream()
                .collect(Collectors.toMap(User::getId, user -> new ConcurrentLinkedQueue<>()));
        Map<String, Queue<Operation>> writeOperations = users.stream()
                .collect(Collectors.toMap(User::getId, user -> new ConcurrentLinkedQueue<>()));

        this.operationsMapQueue = Map.of(
                OperationType.READ, readOperations,
                OperationType.WRITE, writeOperations
        );
    }

    /**
     * Проверяет допустимо ли пользователю совершать операцию.
     * Принимает решение на основе лимитов для разных типов операций
     *
     * @param operation операцию
     * @return допустимо ли совершать операцию
     */
    public boolean isUserAllowedToPerform(@Nonnull Operation operation) {
        Queue<Operation> queue = getQueue(operation);

        removeOldOperations(queue);
        int operationCounter = queue.size();

        if (OperationType.READ.equals(operation.operationType)) {
            return operationCounter < readLimitPerMinute;
        }

        return operationCounter < writeLimitPerMinute;
    }

    /**
     * Обработать сделанную операцию пользователем
     *
     * @param operation операция
     */
    public void processPerformedOperation(@Nonnull Operation operation) {
        Queue<Operation> queue = getQueue(operation);
        operation.setTime(getCurrentTimeSeconds());
        queue.add(operation);
    }

    /**
     * Получить текущее время в секундах
     */
    @Nonnull
    public Long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    private Queue<Operation> getQueue(Operation operation) {
        Queue<Operation> queue = operationsMapQueue
                .get(operation.operationType)
                .get(operation.getUserId());

        if (queue == null) {
            throw new IllegalArgumentException("No such user with id: " + operation.getUserId());
        }

        return queue;
    }

    private void removeOldOperations(Queue<Operation> queue) {
        Long currentTimeSeconds = getCurrentTimeSeconds();
        while (!queue.isEmpty()) {
            if (currentTimeSeconds - queue.peek().getTime() > 60) {
                queue.poll();
            } else {
                break;
            }
        }
    }

    /**
     * Типы операций пользователя
     */
    enum OperationType {
        /**
         * Операция чтения
         */
        READ,
        /**
         * Операция записи
         */
        WRITE
    }

    /**
     * Операция, совершаемая пользователем
     */
    @Data
    public static class Operation {
        /**
         * Id, пользователя совершающего операцию
         */
        private final String userId;
        /**
         * Тип операции
         */
        private final OperationType operationType;

        /**
         * Время операции
         */
        private Long time;
    }

    /**
     * Пользователь
     */
    @Data
    public static class User {
        /**
         * Id пользователя
         */
        private final String id;
        /**
         * Login пользователя
         */
        private final String login;
    }
}
