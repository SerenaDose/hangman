import java.io.File;
import java.util.Scanner;

public class Game {

    public String movieTitle;

    //mi conviene settarla da qui? Sarebbe meglio contare i film?

    private static int numberOfMovies = 25;
    private static final int maxGuesses = 3;
    private int wrongGuesses;
    private char[] fails;

    // mi converrebbe usare degli array list?
    private char[] charMovieTitle;
    private char[] charGuessed;

    Game(){

        try{movieTitle = pickRandomMovie();}
        catch(Exception exception) {
            System.out.println("Something went wrong");
        }


        System.out.println(movieTitle);
        charMovieTitle = movieTitle.toCharArray();

        charGuessed = new char[charMovieTitle.length];

        for (int i=0; i<charMovieTitle.length; i++){

            if (charMovieTitle[i] == ' '){
                charGuessed[i] = ' ';
            }else {
                charGuessed[i] = '-';
            }

        }

        fails = new char[maxGuesses];
    }

    public String getRandomMovieTitle(){

        String randomMovieTitle = movieTitle;

        return randomMovieTitle;

    }

    private String pickRandomMovie() throws Exception{

        File file = new File("movies.txt");

        String[] movieTitles = new String[numberOfMovies];


        Scanner scanner = new Scanner(file);
        int i = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            movieTitles[i] = line;
            i++;
        }

        int randomNumber = (int) (Math.random()* numberOfMovies);

        return movieTitles[randomNumber];

    }

    public boolean isCharInTitle(char c) {

        for (char ch : charMovieTitle) {

            if (ch == c) {
                return true;
            }
        }
        return false;
    }

    public String returnStringWithGuesses(){

        String output = "";

        for (Character c : charGuessed){

            output += c.toString();
        }

        return output;

    }

    public boolean isNotEqual(){

        if (movieTitle.equals(returnStringWithGuesses())){
            return false;
        }

        return true;

    }

    public void setGuessedCharacter(char c){

        for (int i=0; i<charMovieTitle.length; i++){

            if (charMovieTitle[i] == c){
                charGuessed[i] = c;
            }

        }


    }

    public int getWrongGuesses(){

        return wrongGuesses;

    }
    public int getMaxGuesses(){

        return maxGuesses;

    }

    public void setAfterFailedAttempt(char c){

        wrongGuesses ++;
        fails[wrongGuesses - 1] = c;
    }

    public String printWrongGuesses(){

        String output = "";

        for (int i = 0; i < wrongGuesses; i ++){

            output += fails[i];
            output += ", ";
        }

        return output;
    }

    public int guessesLeft(){

        return maxGuesses-wrongGuesses;

    }


}
