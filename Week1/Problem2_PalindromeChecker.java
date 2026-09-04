import java.util.*;

public class Problem2_PalindromeChecker {

    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(String text, int left, int right) {

        if (left >= right)
            return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return recursiveCheck(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = text.toCharArray();

        for (int i = 0, j = reversed.length - 1; i < j; i++, j--) {

            char temp = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = temp;
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: "
                + (isPalindromeIterative(text)
                ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (isPalindromeRecursive(text)
                ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (isPalindromeArrayReversal(text)
                ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}