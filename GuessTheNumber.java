import java.util.*;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int rounds = 3;

        for (int r = 1; r <= rounds; r++) {
            int number = rand.nextInt(100) + 1;
            int attempts = 5;
            boolean guessed = false;

            System.out.println("\nRound " + r);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + attempts + " attempts");

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == number) {
                    System.out.println("Correct Guess!");
                    totalScore += (attempts - i + 1) * 10;
                    guessed = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
            }

            if (!guessed) {
                System.out.println("You lost this round");
                System.out.println("Correct number was: " + number);
            }
        }

        System.out.println("\nGame Over");
        System.out.println("Total Score: " + totalScore);
    }
}
