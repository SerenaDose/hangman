import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception{


        Game guessTheMovie = new Game("movies.txt");

        String movieToGuess = guessTheMovie.getRandomMovieTitle();

        while ((guessTheMovie.getWrongGuesses()!= guessTheMovie.getMaxGuesses()) && !guessTheMovie.isCorrect()) {

            System.out.println(guessTheMovie.returnStringWithGuesses());
            System.out.println("Type a letter:");

           // Scanner scanner = new Scanner(System.in);
            char inputCharacter;
            inputCharacter = guessTheMovie.leggeEValidaInput();
            guessTheMovie.verificaEMemorizzaInput(inputCharacter);
        }

        if (guessTheMovie.isCorrect()){
            System.out.println("You guessed the title!");
            System.out.println(guessTheMovie.getMovieTitle());
        }else{
            System.out.println("Try again");
        }

    }

}