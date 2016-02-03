/**
 * Created by branden on 2/3/16 at 12:36.
 */
public class Account {

    // Set up Vars
    private String name;
    private double balance;
    private boolean isAccountEmpty, isAccountNegative;


    //begin methods

    public void getUserName() throws Exception {

        System.out.println("Please Enter First and Last Name: ");
        this.name = Atm.scanner.nextLine();
        if (name.isEmpty() || name.equals("") || name.equals(" ") || !name.contains(" ")) {
            throw new Exception("You have not entered your name.");
        }

    }


}