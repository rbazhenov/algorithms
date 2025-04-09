package leetcode.easy.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Alice has n candies, where the ith candy is of type candyType[i].
 * Alice noticed that she started to gain weight, so she visited a doctor.
 * <p>
 * The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
 * Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
 * <p>
 * Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
 */
public class _575_DistributeCandies {

    public static void main(String[] args) {
        int[] candyType = {1,1,2,2,3,3};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int n = candyType.length / 2;
        for (int type : candyType) {
            set.add(type);
            if (set.size()==n){
                return n;
            }
        }

        return set.size();
    }
}
