package leetcode.easy.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Design a HashMap without using any built-in hash table libraries.
 */
public class _706_DesignHashMap {

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        System.out.println(map);
        map.put(2,2);
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));

    }

    static class MyHashMapBest {
        int[] map;

        public MyHashMapBest() {
            int size = (int) Math.pow(10,6);
            map = new int[size + 1];
            Arrays.fill(map, -1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key] = -1;
        }
    }

    static class MyHashMap {
        List<Pair> pairs;

        public MyHashMap() {
            this.pairs = new ArrayList<>();
        }

        public void put(int key, int value) {
            Optional<Pair> pairOpt = find(key);
            if (pairOpt.isPresent()){
                pairOpt.get().setValue(value);
            } else {
                pairs.add(new Pair(key, value));
            }
        }

        public int get(int key) {
            Optional<Pair> pair = find(key);
            return pair.map(Pair::getValue).orElse(-1);
        }

        public void remove(int key) {
            Optional<Pair> pair = find(key);
            pair.ifPresent(value -> pairs.remove(value));
        }

        private Optional<Pair> find(int key) {
            return pairs.stream()
                    .filter(pair -> pair.key == key)
                    .findAny();
        }

        @Override
        public String toString() {
            return "MyHashMap{" +
                    "pairs=" + pairs +
                    '}';
        }
    }

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKet() {
            return key;
        }

        public void setKet(int ket) {
            this.key = ket;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
