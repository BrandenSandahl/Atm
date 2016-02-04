/**
 * Created by branden on 2/3/16 at 17:54.
 *
 * This is a class that contains functions the ATM can perform
 */
public class AtmFunctions {


    // Set up Vars
    private static int optionSelected; //this can be static because again, it runs one time then ceases.


    //methods
    public static void turnOn() throws InterruptedException {
        System.out.println("Loading....");
        Thread.sleep(2000);
        System.out.println("Welcome to the ATM. Please enjoy your ATM using experience");
    }

    public static void turnOff() {
        System.out.println("Thank you for using. User.");
    }

    public static void getUser() throws Exception {
        System.out.println("Please Enter First and Last Name: ");
        Atm.user.setName(Utils.scanner.nextLine());
    }

    public static void returnUserBalance() throws Exception {
        System.out.printf("The balance for %s is currently: %.2f %n", Atm.user.getName(), Atm.user.getCurrentBalance());

    }

    public static void withdrawFunds() throws Exception {
        System.out.println("How much would you like to withdraw?");
        float withdrawAmount = Utils.stringToInt(Utils.scanner.nextLine());
        if (withdrawAmount > Atm.user.getCurrentBalance()) {
            throw new Exception("You are attempting to withdraw more than you have");
        } else if (withdrawAmount == 0) {
            throw new Exception("You have entered 0");
        } else {
            Atm.user.setCurrentBalance(Atm.user.getStartBalance() - withdrawAmount);
            System.out.printf("You have withdrawn %.2f, your remaining balance is %.2f %n", withdrawAmount, Atm.user.getCurrentBalance());
        }

    }


    public static void userSelection() throws Exception {
        System.out.printf("Select an option number %n1. Check my balance %n2. Withdraw funds %n3. Cancel Transaction %n");
        optionSelected = Utils.stringToInt((Utils.scanner.nextLine()));
        if (optionSelected > 3 || optionSelected <= 0) {
            throw new Exception("1 2 3 . Those are your options. Simple enough. Try again. ");
        } else {
            if (optionSelected == 1) {
                returnUserBalance();
            } else if (optionSelected == 2) {
                withdrawFunds();
            } else if (optionSelected == 3) {
                System.out.println("Session canceled");
            }
        }

    }
}


