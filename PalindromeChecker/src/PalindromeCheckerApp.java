/*
 * MAIN CLASS - PalindromeCheckerApp
 * UC12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class represents the palindrome checker app
 *
 * At this stage, the application:
 * - Validates a palindrome
 * - Chooses an algorithm dynamically during runtime
 * - Displays formatted result on console
 *
 *
 * @author Shrey Sharma
 * @version 11.0
 */


import java.util.*;


public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Palindrome Checker App (Strategy Pattern) ====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();
        PalindromeStrategy strategy = null;
        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }
        boolean result = strategy.check(input);

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}


interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}