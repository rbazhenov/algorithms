package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class _383_RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct2nd(ransomNote, magazine));
    }

    //second try. 5ms
    public static boolean canConstruct2nd(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            Integer oldCount = map.getOrDefault(key, 0);
            map.put(key, oldCount + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);

            //уменьшаем мапу
            if (map.containsKey(ch)) {
                if (map.get(ch) == 0 || map.get(ch) == 1){
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }


        }

        return map.isEmpty();
    }

    //first try. 20ms
    public static boolean canConstruct1st(String ransomNote, String magazine) {
        Map<Character, Integer> mapNote = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            Integer oldCount = mapNote.getOrDefault(key, 0);
            mapNote.put(key, oldCount + 1);
        }

        Map<Character, Integer> mapMagazine = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char key = magazine.charAt(i);
            if (mapNote.containsKey(key)) {
                Integer oldCount = mapMagazine.getOrDefault(key, 0);
                mapMagazine.put(key, oldCount + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : mapNote.entrySet()) {
            if (!mapMagazine.containsKey(entry.getKey())){
                return false;
            }
            if (entry.getValue() > mapMagazine.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }

}
