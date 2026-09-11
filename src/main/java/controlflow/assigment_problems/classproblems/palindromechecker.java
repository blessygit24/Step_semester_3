
package controlflow.assigment_problems.classproblems;
import java.util.Scanner;

class PalindromeChecker {

    // Approach 1: Iterative
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text) {

        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(text, left + 1, right - 1);
    }


    // Approach 3: Array Reversal
    static boolean isPalindromeArrayReversal(String text) {

        char[] array = text.toCharArray();

        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(array);

        return text.equals(reversed);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println();

        if (iterative)
            System.out.println("Iterative: Palindrome");
        else
            System.out.println("Iterative: Not Palindrome");

        if (recursive)
            System.out.println("Recursive: Palindrome");
        else
            System.out.println("Recursive: Not Palindrome");

        if (arrayReversal)
            System.out.println("Array Reversal: Palindrome");
        else
            System.out.println("Array Reversal: Not Palindrome");

        sc.close();
    }
}
