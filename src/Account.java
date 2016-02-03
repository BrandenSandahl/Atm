/**
 * Created by branden on 2/3/16 at 12:36.
 */
public class Account {

    // Set up Vars
    private String name;
    private float startBalance = 100;
    private float currentBalance = startBalance;
    private boolean isAccountEmpty, isAccountNegative;


    //begin methods

    //gets the users name, throws an error if not in correct format
    public void getUserName() throws Exception {

        System.out.println("Please Enter First and Last Name: ");
        this.name = Atm.scanner.nextLine();
        if (name.isEmpty() || name.equals("") || name.equals(" ") || !name.contains(" ")) {
            throw new Exception("You have not entered your name.");
        }

    }

    public void returnUserBalance() throws Exception {

        System.out.printf("The balance for %s is currently: %.2f", name, currentBalance);

    }

    public void withdrawFunds() throws Exception {
        System.out.println("How much would you like to withdraw?");
        float withdrawAmount = Atm.stringToInt(Atm.scanner.nextLine());
        if (withdrawAmount > currentBalance) {
            throw new Exception("You are attempting to withdraw more than you have");
        } else if (withdrawAmount == 0) {
            throw new Exception("You have entered 0");
        } else {
            currentBalance = startBalance - withdrawAmount;
            System.out.printf("You have withdrawn %.2f, your remaining balance is %.2f", withdrawAmount, currentBalance);
        }

    }


}