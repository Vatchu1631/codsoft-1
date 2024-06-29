import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        int totalScore = 0;
        boolean continuePlaying = true;
        
        while (continuePlaying) {
            int targetNumber = generator.nextInt(100) + 1;
            int tries = 0;
            boolean isCorrect = false;
            System.out.println("Try to guess the number between 1 and 100:");

            while (tries < 10 && !isCorrect) {
                System.out.print("Enter your guess: ");
                int playerGuess = input.nextInt();
                tries++;
                
                if (playerGuess == targetNumber) {
                    System.out.println("Well done! You guessed the number correctly.");
                    isCorrect = true;
                    totalScore += (10 - tries + 1); // Higher score for fewer attempts
                } else if (playerGuess > targetNumber) {
                    System.out.println("Your guess is too high! Try again.");
                } else {
                    System.out.println("Your guess is too low! Try again.");
                }
            }
            
            if (!isCorrect) {
                System.out.println("Out of tries! The correct number was: " + targetNumber);
            }
            
            System.out.print("Would you like to play another round? (yes/no): ");
            continuePlaying = input.next().equalsIgnoreCase("yes");
        }
        
        System.out.println("Your final score is: " + totalScore);
        System.out.println("Thanks for playing!");
        input.close();
    }
}