import java.util.Scanner;

//You try to guess the correct word, either by entering a single letter
//or the whole word
public class Hangman {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String answer = "television";
        char[] word = new char[answer.length()];
        boolean hasNotBeenGuessed = true;

        //initialize word
        for (int i = 0; i < answer.length(); i++) {
            word[i] = '_';
        }

        while (hasNotBeenGuessed) {
            //print word
            for (int i = 0; i < word.length; i++) {
                System.out.print(word[i] + " ");
            }
            System.out.println();

            System.out.print("Guess a letter or word: ");
            String guess = input.next();
            if (guess.length() > 1) {
                if (guess.equals(answer)) {
                    System.out.println("You guessed correctly!");
                    hasNotBeenGuessed = false;
                } 
                else {
                    System.out.println("You didn't guess correctly.");
                }
            } 
            else {
                System.out.println("You tried to guess letter");
                //if letter is in answer then show that letter
                for (int i = 0; i < answer.length(); i++) {
                    char letter = guess.charAt(0);
                    if (letter == answer.charAt(i)) {
                        word[i] = letter;
                    }
                }
            }
            //check if all letters have been guessed
            boolean canStop = true;
            for (int i = 0; i < answer.length(); i++) {
                if (word[i] == '_') {
                    canStop = false;
                }
            }
            if (canStop == true) {
                System.out.println("You guessed correctly!");
                hasNotBeenGuessed = false;
            }
        }
    }
}