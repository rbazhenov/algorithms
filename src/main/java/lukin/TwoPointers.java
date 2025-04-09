package lukin;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Поиск Знаменитости. Метод двух указателей.
 */
public class TwoPointers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        // https://www.youtube.com/watch?v=xGvQN_g-JCI&t=4s
    }

    /**
     * Мы зададим k вопросов для поиска единственного кондидата и 2k для выяснения является ли он знаменитостью.
     * <p>
     * Скорость O(3k) = O(k).
     */
    private Person findCelebrity(Person[] persons) {
        int l = 0; //левый указатель
        int r = persons.length - 1; //правый указатель

        while (l != r) {
            if (persons[l].knows(persons[r])) {
                l++;
            } else {
                r--;
            }
        }

        for (int i = 0; i < persons.length; i++) {
            if (i != l && (!persons[i].knows(persons[l]) || persons[l].knows(persons[i]))) {
                return null;
            }
        }

        return persons[l];
    }


    private static class Person {
        private String id;
        private Person[] knownPersons;

        public boolean knows(Person person) {
            return Arrays.asList(knownPersons).contains(person);
        }

        public Person[] getKnownPersons() {
            return knownPersons;
        }

        public void setKnownPersons(Person[] knownPersons) {
            this.knownPersons = knownPersons;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id) && Arrays.equals(knownPersons, person.knownPersons);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(id);
            result = 31 * result + Arrays.hashCode(knownPersons);
            return result;
        }
    }
}
