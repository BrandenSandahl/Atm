import java.util.Scanner;

/**
 * Created by branden on 2/3/16 at 18:29.
 */
public class Utils {


    // Set up Vars
    static Scanner scanner = new Scanner(System.in);


    //begin utilities
    public static int stringToInt(String tempNumber) {
        return Integer.valueOf(tempNumber);
    }


    //this will catch user input and kill the program if input = exit
    public static String nextLine() {
        String lineIn = scanner.nextLine();
        while (lineIn.equalsIgnoreCase("exit")) {
            AtmFunctions.turnOff();
        }
        return lineIn;
    }
}