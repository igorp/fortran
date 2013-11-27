import java.util.Scanner;
import java.util.Random;

//You try to guess a random number between 0 and 100
public class Guess {
    public static void main(String[] args) {
        Random rand = new Random();
        int  n = rand.nextInt(100) + 1;
        int guess = -1;
        int tries = 1;
        
        //System.out.println(n);
        
        while (guess != n) {
            Scanner input = new Scanner(System.in);
            System.out.println("Guess a number between 0 and 100: ");
            guess = input.nextInt();
            if(guess != n) {
                tries++;
                if(guess > n)
                    System.out.println("You guessed too high");
                else
                    System.out.println("You guessed too low");
            }
        }
        System.out.println("You got it! It took you " + tries + " tries.");
    }
}