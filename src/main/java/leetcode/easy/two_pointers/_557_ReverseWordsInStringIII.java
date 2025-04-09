package leetcode.easy.two_pointers;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class _557_ReverseWordsInStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(best(s));
    }

    //Two pointer
    public static String best(String s) {
        char[] arr = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                int end = i - 1;
                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }

        return new String(arr);
    }

    public static String reverseWords2(String s) {
        String[] arr = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : arr) {
            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }

        return String.join(" ", arr);
    }
}
