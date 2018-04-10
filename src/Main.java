import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        // I have to handle this exception:
        // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0


        Game guessTheMovie = new Game();

        String movieToGuess = guessTheMovie.getRandomMovieTitle();

        while ((guessTheMovie.getWrongGuesses()!= guessTheMovie.getMaxGuesses()) && !guessTheMovie.isEqual()) {

            System.out.println(guessTheMovie.returnStringWithGuesses());

            System.out.println("Type a letter:");

            Scanner scanner = new Scanner(System.in);

            try {
                String input = scanner.nextLine();
                Character inputCharacter = input.charAt(0);

                //devo assicurarmi che sia solo un carattere e non una stringa?

                if(input.length()>1){

                    System.out.println("You must type only one letter");
                }else {



                    if (guessTheMovie.isCharInTitle(inputCharacter)) {

                        guessTheMovie.setGuessedCharacter(inputCharacter);

                        System.out.println("Yay the character is in the title!");
                        System.out.println("");
                        // System.out.println("The title doesn't contain: " + guessTheMovie.printWrongGuesses());

                    } else {
                        guessTheMovie.setAfterFailedAttempt(inputCharacter);
                        System.out.println("The character isn't in the title");
                        System.out.println("You have now " + guessTheMovie.guessesLeft() + " guesses left");
                        System.out.println("");
                        System.out.println("The title doesn't contain: " + guessTheMovie.printWrongGuesses());

                    }
                }
            }catch (StringIndexOutOfBoundsException exception){

                System.out.println("You must type one letter");

            }catch(Exception exception){

                System.out.println("Something went wrong");

            }
        }

        if (guessTheMovie.isEqual()){

            System.out.println("You guessed the title!");

        }else{
            System.out.println("Try again");
        }

    }

}