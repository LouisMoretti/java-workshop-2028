package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
            return -1;
        else if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0, j = len - 1; i < j; i++, j--)
            if (word.charAt(i) != word.charAt(j)) return false;
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[max] < array[j]) max = j;
            if (max != i)
            {
                int tmp = array[i];
                array[i] = array[max];
                array[max] = tmp;
            }
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        StringBuilder ret = new StringBuilder(a);
        ret.append(b);
        return ret.toString();
    }
}
