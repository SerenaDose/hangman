import java.io.File;
import java.util.Scanner;

/**
 * Created by ValarMorghulis on 16/04/2018.
 */
public class FileManager {

    public static int countLines(File file) throws Exception{

        int numberOfLines = 0;

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            numberOfLines ++;
        }

        return numberOfLines;
    }

    public static String returnRandomLine(File file, int n) throws Exception {

        int randomNumber = Random.randomN(n);

        String title = "";

        Scanner scanner = new Scanner(file);

        int i = 0;

        while (i<=randomNumber) {
            title = scanner.nextLine();
            i++;
        }

        return title;
    }
}
