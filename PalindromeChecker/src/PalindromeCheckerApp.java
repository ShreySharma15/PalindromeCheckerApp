/*
 * MAIN CLASS - PalindromeCheckerApp
 * UC13: Performance Comparison
 *
 * Description:
 * This class represents the palindrome checker app
 *
 * At this stage, the application:
 * - Validates a palindrome using reversing a string
 * - Captures execution start and end time and calculates total execution duration
 * - Calculate and displays formatted result on console
 *
 *
 * @author Shrey Sharma
 * @version 10.0
 */


public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        long start = System.nanoTime();
        boolean reversePalindrome = reverseIsPalindrome(input);
        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + reversePalindrome);
        System.out.println("Execution time: " + duration + " ns");
    }
    private static boolean reverseIsPalindrome(String input){
        char[] reversed = new char[input.length()];
        boolean isPalindrome = false;
        for(int i = input.length() - 1; i >= 0; i--){
            int j = input.length() - 1 - i;
            reversed[j] = input.charAt(i);
        }
        String reverse = new String(reversed);
        if(input.equalsIgnoreCase(reverse)){
            isPalindrome = true;
        }

        return isPalindrome;
    }

    }




