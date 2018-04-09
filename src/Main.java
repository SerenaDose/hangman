import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        // I have to handle this exceptionx
        // Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0

        // write your code here
        ///////

        Game guessTheMovie = new Game();

        String movieToGuess = guessTheMovie.getRandomMovieTitle();

        //  System.out.print(guessTheMovie.pickNumberOfMovies());

        while ((guessTheMovie.getWrongGuesses()!= guessTheMovie.getMaxGuesses()) && guessTheMovie.isNotEqual()) {

            System.out.println(guessTheMovie.returnStringWithGuesses());

            System.out.println("Type a letter:");

            Scanner scanner = new Scanner(System.in);

            try {
                String input = scanner.nextLine();

                //devo assicurarmi che sia solo un carattere e non una stringa?

                if(input.length()>1){

                    System.out.println("You must type only one letter");
                }else {

                    Character inputCharacter = input.charAt(0);

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

        if (guessTheMovie.isNotEqual() == false){

            System.out.println("You guessed the title!");

        }else{
            System.out.println("Try again");
        }

    }

}