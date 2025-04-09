package leetcode.easy.string;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
public class _1071_GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    //НОД
    public static int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b,a%b);
    }
}
