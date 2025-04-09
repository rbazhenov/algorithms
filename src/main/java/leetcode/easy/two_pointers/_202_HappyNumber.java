package leetcode.easy.two_pointers;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.<p>
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.<p>
 * Those numbers for which this process ends in 1 are happy.<p>
 * Return true if n is a happy number, and false if not.<p>
 */
public class _202_HappyNumber {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        String nStr = String.valueOf(n);
        while (Integer.parseInt(nStr) != 1) {
            if (nStr.length() == 1 && !nStr.equals("7")) {
                return false;
            }

            int sum = 0;
            for (int i = 0; i < nStr.length(); i++) {
                int num = Integer.parseInt(Character.toString(nStr.charAt(i)));
                sum = sum + num * num;
            }
            nStr = String.valueOf(sum);
        }

        return true;
    }
}
