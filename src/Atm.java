import java.util.Scanner;

/**
 * Created by branden on 2/3/16 at 12:33.
 */
public class Atm {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        int optionSelected = 0;
        String tempNumb; // needs this to convert numbers

        System.out.println("Welcome to the ATM. Please enjoy your ATM using experience");

        //create object to hold the user
        Account user = new Account();

        //run methods on user to build object
        user.getUserName();

        /** Get user option
         * This is outside of the Account class because it's not really a direct function to the Account class,
         * it's more of a function of the ATM itself.
         */
        System.out.printf("Select an option %n1. Check my balance %n2. Withdraw funds %n3. Cancel %n");

        optionSelected = stringToInt((scanner.nextLine()));

        //process user selection. This will need to be refactored I'm thinking.
        if (optionSelected == 1) {
            user.returnUserBalance();
        } else if (optionSelected == 2) {
            user.withdrawFunds();
        } else if (optionSelected == 3) {
            System.out.println("Session canceled");
            return;
        }


    }


        //methods
        //this should probably be moved to a util class really.
        public static int stringToInt(String tempNumber) {
            return Integer.valueOf(tempNumber);
        }




}
