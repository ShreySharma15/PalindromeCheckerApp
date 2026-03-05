/*
 * MAIN CLASS - PalindromeCheckerApp
 * UC11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class represents the palindrome checker app
 *
 * At this stage, the application:
 * - Validates a palindrome by creating instance of another class
 * - comparing start and end characters
 * - Displays formatted result on console
 *
 *
 * @author Shrey Sharma
 * @version 11.0
 */


import java.util.Locale;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "racecar";
        PalindromeService p1 = new PalindromeService();
        boolean isPalindrome = p1.checkPalindrome(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}


class PalindromeService{
    public boolean checkPalindrome(String input){
        int start =0;
        int end = input.length() -1;

        boolean isPlaindrome = true;

        while(start < end){
            if(input.charAt(start) != input.charAt(end)){
                isPlaindrome = false;
            }
            start++;
            end--;
        }
        return isPlaindrome;
    }
}