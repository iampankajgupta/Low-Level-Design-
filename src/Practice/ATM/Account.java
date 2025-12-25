package Practice.ATM;

public class Account {
    private String customerId;
    private String firstName;
    private String lastName;
    private int balance;
    private String pin;


    public Account(String customerId, String firstName, String lastName, int balance, String pin) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.pin = pin;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
