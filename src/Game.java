import java.io.File;
import java.io.FileNotFoundException;
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
        catch(FileNotFoundException exception) {
            System.out.println("Something went wrong while counting the movies");
            //inserire anche il messaggio dell'eccezione I/O exc
        }

        try{
            movieTitle = pickRandomTitle(file);
        }
        catch(FileNotFoundException exception) {
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

    private void setNumberOfMovies(File file) throws FileNotFoundException {

        numberOfMovies = FileManager.countLines(file);

    }

    /*
    *RETURN a random title
     */

    private String pickRandomTitle(File file) throws FileNotFoundException{

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

    public boolean isCorrect(){

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

    public String WrongGuesses(){

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

    public void verificaEMemorizzaInput(char c){

        if (isCharInTitle(c)) {
            setGuessedCharacter(c);
            System.out.println("Yay the character is in the title!");
            System.out.println("");

        } else {
            setAfterFailedAttempt(c);
            System.out.format("The character isn't in the title \n You have now %d guesses left \n\n " +
                    "The title doesn't contain: %d",
                    guessesLeft(), WrongGuesses()  );
        }
    }


    public char leggeEValidaInput() throws Exception{

        Scanner scanner = new Scanner(System.in);

        try {
            String input = scanner.nextLine();
            Character inputCharacter = input.charAt(0);
            return input.charAt(0);
        }catch (StringIndexOutOfBoundsException exception){
            System.out.println("You must type one letter");
            throw new Exception("Empty Input not allowed");
        }catch(Exception exception){
            System.out.println("Something went wrong");
            throw exception;
        }

    }

  /*  public char leggeEValidaInputBis(Scanner scanner){

            String input = scanner.nextLine();
            Character inputCharacter = input.charAt(0);

            if(inputCharacter != ' '){

            }

    }*/

}
