/**
 * Created by branden on 2/3/16 at 17:54.
 *
 * This is a class that contains functions the ATM can perform
 */
public class AtmFunctions {


    // Set up Vars
    public static String currentUser;


    //methods

    //turn on the ATM
    public static void turnOn() throws InterruptedException {
        System.out.printf("Loading....%n%n");
        Thread.sleep(2000);
        System.out.println("Welcome to the ATM. Please enjoy your ATM using experience. Enter exit at any time to cancel");
    }
    //turn off the ATM
    public static void turnOff() {
        System.out.println("Thank you for using. User.");
        System.exit(0);
    }
    //Prompt user for name, validate, then set to the user object
    public static void logIn() throws Exception {
        System.out.println("Please enter log in credentials as user's full name");
        String tempUser = Utils.nextLine().toLowerCase();
        boolean isValidName = false;
        // tempUser = tempUser.toLowerCase();
        System.out.printf("Accessing...%n%n");
        Thread.sleep(1000);
        while (!isValidName) {
            if (tempUser.isEmpty() || tempUser.equals("") || tempUser.equals(" ") || !tempUser.contains(" ")) {
                System.out.println("You have entered your name in an invalid format, please try again");
                tempUser = Utils.nextLine().toLowerCase();
            } else {
                isValidName = true;
            }
        }
        if (Atm.account.containsKey(tempUser)) {
            currentUser = tempUser;
            System.out.println("Greetings, " + currentUser + ".");
            System.out.println("");
            userSelection();
        } else {
            Atm.account.put(tempUser, 100f);
            currentUser = tempUser;
            System.out.printf("I can not find " + currentUser + " in our system. An account has been created.%n%n");
            userSelection();
            }
        }




    //formats and returns users balance
    public static void returnUserBalance() throws Exception {
        System.out.printf("The balance for %s is currently: %.2f %n", currentUser, Atm.account.get(currentUser));

    }
    //withdraws funds and updates balance
    public static void withdrawFunds() throws Exception {
        System.out.println("How much would you like to withdraw?");
        float withdrawAmount = Utils.stringToFloat(Utils.nextLine());
        boolean isValidNumber = false;
        while (!isValidNumber) {
            if (withdrawAmount > Atm.account.get(currentUser)) {
                System.out.println("You are attempting to withdraw more than you have. Please try again");
                withdrawAmount = Utils.stringToFloat(Utils.nextLine());
            } else if (withdrawAmount <= 0) {
                System.out.println("You have entered an impossible amount. Please try again");
                withdrawAmount = Utils.stringToFloat(Utils.nextLine());
            } else {
                isValidNumber = true;
            }
        }
            Atm.account.put(currentUser, Atm.account.get(currentUser) - withdrawAmount);
            System.out.printf("You have withdrawn %.2f, your remaining balance is %.2f %n", withdrawAmount, Atm.account.get(currentUser));
    }



    //gives user a choice, and calls methods based on that choice
    //note that if you JUST push enter for this it breaks the program. I do not know why.
    public static void userSelection() throws Exception {
        System.out.printf("Select an option number %n1. Check my balance %n2. Withdraw funds %n3. Remove account %n4. Return to log in %n");
        int optionSelected;
        optionSelected = Utils.stringToInt((Utils.nextLine()));
        switch (optionSelected) {
            case 1:
                returnUserBalance();
                userSelection();
                break;
            case 2:
                withdrawFunds();
                userSelection();
                break;
            case 3:
                System.out.println("This will permanently delete your account. Please confirm by entering your account name again");
                if (Utils.nextLine().equalsIgnoreCase(currentUser)) {
                    Atm.account.remove(currentUser);
                } else {
                    System.out.println("canceling removal");
                }
                logIn();
                break;
            case 4:
                System.out.println("Returning");
                logIn();
                break;
            default:
                System.out.println("You entered a value I cannot recognize. Please try again");
                userSelection();

        }

    }
}


