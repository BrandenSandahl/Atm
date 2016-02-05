

/**
 * Created by branden on 2/3/16 at 12:33.
 * Creating a magical ATM that gives you $100 every time you enter into your account.
 */
public class Atm {

    static User user = new User();  //this is static because only one person can use this ATM at a time. It will never have multiple users

    public static void main(String[] args) throws Exception {

        AtmFunctions.turnOn();  //user pushes a power button. Because that's how ATMs work.
        while (true) {
            AtmFunctions.logIn(); //Atm prompts user for name, "finds" the account (creates account in this case)
            AtmFunctions.userSelection(); //Atm reads in user selection, if user plays their cards right, they get $100 (there is not an actual card game attached)
        }


    }
}