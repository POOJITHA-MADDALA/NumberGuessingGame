import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int randomNumber = rand.nextInt(100) + 1;  // Random number between 1 and 100
        int maxAttempts = 5;  // The user gets 5 attempts
        int attemptsLeft = maxAttempts;
        int lowerBound = 1;
        int upperBound = 100;
        
        System.out.println("=======================================");
        System.out.println("NEW GAME");
        System.out.println("=======================================");
        System.out.println("Pick a number between " + lowerBound + "-" + upperBound + "! You will get " + maxAttempts + " turns.");
        
        // Game loop
        while (attemptsLeft > 0) {
            System.out.print("\nPick a number between " + lowerBound + "-" + upperBound + " and turns left " + attemptsLeft + ": ");
            int playerGuess = sc.nextInt();
            
            System.out.println("Player guesses " + playerGuess);
            
            if (playerGuess == randomNumber) {
                System.out.println("YOU WIN! The SECRET number was " + randomNumber);
                break;
            } else if (playerGuess < randomNumber) {
                System.out.println("  Sorry, that is too low.");
                lowerBound = Math.max(lowerBound, playerGuess + 1);  // Update lower bound
            } else {
                System.out.println("  Sorry, that number is too high.");
                upperBound = Math.min(upperBound, playerGuess - 1);  // Update upper bound
            }
            
            attemptsLeft--;
            
            if (attemptsLeft == 0) {
                System.out.println("Game Over! You've used all your turns.");
                System.out.println("The secret number was " + randomNumber);
            }
        }
        
        sc.close();
    }
}
