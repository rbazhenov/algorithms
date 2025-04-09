package leetcode.easy.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes...
 */
public class _804_UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = getMap();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                morse.append(map.get(word.charAt(i)));
            }
            set.add(morse.toString());
        }

        return set.size();
    }

    public static Map<Character, String> getMap(){
        Map<Character,String> map = new HashMap<>();
        map.put('a',".-");
        map.put('A',".-");
        map.put('B',"-...");
        map.put('b',"-...");
        map.put('C',"-.-.");
        map.put('c',"-.-.");
        map.put('D',"-..");
        map.put('d',"-..");
        map.put('E',".");
        map.put('e',".");
        map.put('F',"..-.");
        map.put('f',"..-.");
        map.put('G',"--.");
        map.put('g',"--.");
        map.put('H',"....");
        map.put('h',"....");
        map.put('I',"..");
        map.put('i',"..");
        map.put('J',".---");
        map.put('j',".---");
        map.put('K',"-.-");
        map.put('k',"-.-");
        map.put('L',".-..");
        map.put('l',".-..");
        map.put('M',"--");
        map.put('m',"--");
        map.put('N',"-.");
        map.put('n',"-.");
        map.put('O',"---");
        map.put('o',"---");
        map.put('P',".--.");
        map.put('p',".--.");
        map.put('Q',"--.-");
        map.put('q',"--.-");
        map.put('R',".-.");
        map.put('r',".-.");
        map.put('S',"...");
        map.put('s',"...");
        map.put('T',"-");
        map.put('t',"-");
        map.put('U',"..-");
        map.put('u',"..-");
        map.put('V',"...-");
        map.put('v',"...-");
        map.put('W',".--");
        map.put('w',".--");
        map.put('X',"-..-");
        map.put('x',"-..-");
        map.put('Y', "-.--");
        map.put('y',"-.--");
        map.put('z', "--..");
        map.put('Z',"--..");
        return map;
    }
}
