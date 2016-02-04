import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

/**
 * Created by branden on 2/3/16 at 18:04.
 * This class stores data on the current user of the ATM
 */
public class User {

    // Set up Vars
    public HashMap<String, Float> account = new HashMap<>(); //hashmap to store user and account
    private String name;
    public String currentUser;
    private float startBalance = 100;
    private float currentBalance = startBalance;
    //private boolean isAccountEmpty, isAccountNegative;


    /** Start Getters and Setters */
   //name
    public String getName() {
        return name;
    }
    public void setName(String name) throws Exception {
        if (name.isEmpty() || name.equals("") || name.equals(" ") || !name.contains(" ")) {
            throw new Exception("You have not entered a valid name.");
       } else {
            this.name = name;
        }
    }

    //startBalance
    public float getStartBalance() {
        return startBalance;
    }

    //currentBalance
    public float getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    /** End of Getters and Setters */

}