package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0) return -1;
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n <= 2) return 1;

        long[] array = new long[n + 1];

        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i <= n; i++)
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];

        return array[n];
    }

    private static boolean isSpace(char c) {
        return c == ' ' || c == '\t';
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null) return false;

        word = word.toLowerCase();

        int len = word.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (i < j && isSpace(word.charAt(i)))
                i++;

            while (i < j && isSpace(word.charAt(j)))
                j--;

            if (i >= j)
                break;

            char a = word.charAt(i);
            char b = word.charAt(j);

            if (a != b) return false;
        }

        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++)
                if (array[min] > array[j]) min = j;

            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        StringBuilder ret = new StringBuilder();

        int i = 0;
        while (i < a.length() && i < b.length()) {
            ret.append(a.charAt(i));
            ret.append(b.charAt(i));
            i++;
        }

        while (i < a.length()) {
            ret.append(a.charAt(i));
            i++;
        }

        while (i < b.length()) {
            ret.append(b.charAt(i));
            i++;
        }

        return ret.toString();
    }
}
