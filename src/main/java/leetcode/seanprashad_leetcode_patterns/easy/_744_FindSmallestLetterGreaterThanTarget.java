package leetcode.seanprashad_leetcode_patterns.easy;

public class _744_FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'x', 'x', 'y', 'y'};
//        char[] letters = {'c', 'f', 'j'};
//        char target = 'c';
        char target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return letters[l] > target ? letters[l] : letters[0];
    }
}
