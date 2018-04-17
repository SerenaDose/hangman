import java.io.File;
import java.util.Scanner;

public class Game {

    public String movieTitle;

    private int numberOfMovies;
    private static final int maxGuesses = 7;
    private int wrongGuesses;

    private File file;

    private char[] fails;

    private char[] charMovieTitle;
    private char[] charGuessed;

    Game(String fileTitle){

        this.file = new File(fileTitle);

        try{
            setNumberOfMovies(file);
        }
        catch(Exception exception) {
            System.out.println("Something went wrong while counting the movies");
        }

        try{
            movieTitle = pickRandomTitle(file);
        }
        catch(Exception exception) {
            System.out.println("Something went wrong whisle picking the Movie from the file");
        }

        turnTitleInArray(); //o va nel Main?

       // System.out.println(movieTitle);

        fails = new char[maxGuesses];
    }

    /*
    *MODIFY charMovieTitle with characters of the title and MODIFY charGuessed with "-" and " "
     */

    public void turnTitleInArray(){

        charMovieTitle = movieTitle.toCharArray();

        charGuessed = new char[charMovieTitle.length];

        for (int i=0; i<charMovieTitle.length; i++){

            if (charMovieTitle[i] == ' '){
                charGuessed[i] = ' ';
            }else {
                charGuessed[i] = '-';
            }
        }
    }


    public String getRandomMovieTitle(){

        String randomMovieTitle = movieTitle;

        return randomMovieTitle;
    }

    /*
    *MODIFY number of movies with number of movies in file movies.txt
     */

    private void setNumberOfMovies(File file) throws Exception{

        numberOfMovies = FileManager.countLines(file);

    }

    /*
    *RETURN a random title
     */

    private String pickRandomTitle(File file) throws Exception{

        String title = FileManager.returnRandomLine(file, numberOfMovies);

        return title;
    }

     /*
    *RETURN true if char is in the title
    * @par c REQUIRE to be a valid character
     */

    public boolean isCharInTitle(char c) {

        String character = Character.toString(c);

        return movieTitle.contains(character);
    }

     /*
    *RETURN the string with guesses
     */

    public String returnStringWithGuesses(){

        String output = "";

        for (Character c : charGuessed){

            output += c.toString();
        }

        return output;

    }

     /*
    *RETURN a random title
     */

    public boolean isEqual(){

        if (movieTitle.equals(returnStringWithGuesses())){
            return true;
        }
        return false;
    }
     /*
    *MODIFY charGuessed array, adds the new character
    *@param c REQUIRED to be a character in the title
     */

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

    /*
    *MODIFY wrongGuesses variable, MODIFY fails[]
    *@param c REQUIRED to be a valid character
     */

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

    public String getMovieTitle(){

        return movieTitle;
    }


}
