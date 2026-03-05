/*
 * MAIN CLASS - PalindromeCheckerApp
 * UC13: Performance Comparison
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
        String input = "racecar";

        System.out.println("Input : " + input);

        // Hardcoded strategies
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();


        runAndMeasure(stackStrategy, input);
        runAndMeasure(dequeStrategy, input);

    }

    // Method to measure execution time
    private static void runAndMeasure(PalindromeStrategy strategy, String input) {

        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("\nAlgorithm: " + strategy.getClass().getSimpleName());
        System.out.println("Is Palindrome : " + result);
        System.out.println("Execution Time : " + executionTime + " ns");
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