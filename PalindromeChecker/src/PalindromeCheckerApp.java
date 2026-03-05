/*
 * MAIN CLASS - PalindromeCheckerApp
 * UC10: Case-Insensitive & Space-Ignored Palindrome
 *
 * Description:
 * This class represents the palindrome checker app
 *
 * At this stage, the application:
 * - Validates a palindrome after normalisation
 * - comparing start and end characters
 * - Displays formatted result on console
 *
 *
 * @author Shrey Sharma
 * @version 9=10.0
 */


import java.util.Locale;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        boolean isPalindrome = true;
        String inputLowerCase= input.toLowerCase();
        String normalised = inputLowerCase.replace(" ","");
        for(int i=0; i<normalised.length()/2; i++){
            if(normalised.charAt(i) != normalised.charAt(normalised.length() -1 -i)){
                isPalindrome = false;
            }
        }
        System.out.println("Input : " + normalised);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
