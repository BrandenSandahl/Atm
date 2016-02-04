/**
 * Created by branden on 2/3/16 at 17:54.
 *
 * This is a class that contains functions the ATM can perform
 */
public class AtmFunctions {


    // Set up Vars
    private static int optionSelected; //this can be static because again, it runs one time then ceases.


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
    //Prompt user for name, then set to the user object (validation is done there)
    public static void logIn() throws InterruptedException {
        System.out.println("Please enter log in credentials");
        String tempUser = Utils.nextLine();
        tempUser = tempUser.toLowerCase();
        System.out.printf("Accessing...%n%n");
        Thread.sleep(1000);
        if (Atm.user.account.containsKey(tempUser)) {
            Atm.user.currentUser = tempUser;
            System.out.println("Greetings, " + Atm.user.currentUser + ".");
        } else {
            Atm.user.account.put(tempUser, 100f);
            Atm.user.currentUser = tempUser;
            System.out.printf("I can not find " + Atm.user.currentUser + " in our system. An account has been created.%n%n");
            }
        }


    //formats and returns users balance
    public static void returnUserBalance() throws Exception {
        System.out.printf("The balance for %s is currently: %.2f %n", Atm.user.currentUser, Atm.user.account.get(Atm.user.currentUser));

    }
    //withdraws funds and updates balance
    public static void withdrawFunds() throws Exception {
        System.out.println("How much would you like to withdraw?");
        float withdrawAmount = Utils.stringToInt(Utils.nextLine());
        if (withdrawAmount > Atm.user.account.get(Atm.user.currentUser)) {
            throw new Exception("You are attempting to withdraw more than you have");
        } else if (withdrawAmount == 0) {
            throw new Exception("You have entered 0");
        } else {
            Atm.user.account.put(Atm.user.currentUser, Atm.user.account.get(Atm.user.currentUser) - withdrawAmount);
            System.out.printf("You have withdrawn %.2f, your remaining balance is %.2f %n", withdrawAmount, Atm.user.account.get(Atm.user.currentUser));
        }

    }

    //gives user a choice, and calls methods based on that choice
    public static void userSelection() throws Exception {
        System.out.printf("Select an option number %n1. Check my balance %n2. Withdraw funds %n3. Cancel Transaction %n4. Remove account %n");
        optionSelected = Utils.stringToInt((Utils.nextLine()));
        if (optionSelected > 4 || optionSelected <= 0) {
            throw new Exception("1 2 3 4. Those are your options. Simple enough. Try again. ");
        } else {
            if (optionSelected == 1) {
                returnUserBalance();
            } else if (optionSelected == 2) {
                withdrawFunds();
            } else if (optionSelected == 3) {
                System.out.println("Session canceled");
            } else if (optionSelected == 4)  {
                System.out.println("This will permanently delete your account. Please confirm by entering your account name again");
                if (Utils.nextLine().equalsIgnoreCase(Atm.user.currentUser)){
                    Atm.user.account.remove(Atm.user.currentUser);
                } else {
                    System.out.println("canceling removal");
                }
            }
        }

    }
}


