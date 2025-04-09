package search;

public class Binary {

    public static void main(String[] args) {
        int[] array = {1, 5, 6, 7, 11, 19};
        System.out.println(calcGuessIndex(array, 5));
        System.out.println(calcGuessIndex_2(array, 11));
        System.out.println(calcGuessIndex_3(array, 19));
//        System.out.println(calcGuessIndex_4(array, 7));
    }

    private static int calcGuessIndex(int[] array, int item) {
        int highIndex = array.length - 1;
        int lowIndex = 0;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            int guess = array[midIndex];

            if (item == guess) {
                return midIndex;
            }

            if (guess > item) {
                highIndex = midIndex - 1;
            }

            if (guess < item) {
                lowIndex = midIndex + 1;
            }
        }

        //O(Log n)
        throw new IllegalArgumentException("No value present");
    }

    private static int calcGuessIndex_2(int[] array, int item) {
        int lowIndex = 0;
        int highIndex = array.length - 1;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            int guess = array[midIndex];

            if (guess == item) {
                return midIndex;
            }

            if (guess > item) {
                highIndex = midIndex - 1;
            }

            if (guess < item) {
                lowIndex = midIndex + 1;
            }
        }

        //O(Log n)
        throw new IllegalArgumentException("No value present");
    }

    private static int calcGuessIndex_3(int[] array, int item) {
        int lowIndex = 0;
        int highIndex = array.length - 1;

        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            int guess = array[midIndex];

            if (guess == item) {
                return midIndex;
            }

            if (item > guess) {
                lowIndex = midIndex + 1;
            }

            if (item < guess) {
                highIndex = midIndex - 1;
            }
        }

        //big O(lon n)
        throw new IllegalArgumentException("No value present");
    }

    private static int calcGuessIndex_4(int[] array, int item) {
        //todo algorithm

        //todo big O
        throw new IllegalArgumentException("No value present");
    }

}
