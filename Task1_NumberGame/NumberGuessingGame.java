import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int roundsWon = 0;
        String choice;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it within 7 attempts.");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correct = false;

            System.out.println("\nLet's start a new round!");

            while (attempts < 7) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed it!");
                    System.out.println("You took " + attempts + " attempts.");

                    score += (8 - attempts) * 10;
                    roundsWon++;
                    correct = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (7 - attempts));
            }

            if (!correct) {
                System.out.println("Sorry, you couldn't guess the number.");
                System.out.println("The correct number was " + number + ".");
            }

            System.out.println("\nYour score: " + score);
            System.out.println("Rounds won: " + roundsWon);

            System.out.print("Do you want to play again? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("\nThanks for playing!");
        System.out.println("Your final score is " + score + ".");
        System.out.println("You won " + roundsWon + " round(s).");

        sc.close();
    }
}
