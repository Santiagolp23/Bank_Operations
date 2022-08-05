import java.time.LocalDate;

public abstract class Account {
    private Long accountNumber;
    private static Long accountNumberCounter;
    private Double balance;
    public LocalDate dateOfCreation;
    public User accountOwner;

    public Account(User accountOwner) {
        this.accountOwner = accountOwner;
        accountNumberCounter++;
        accountNumber = accountNumberCounter;
    }

    public void showAccountData() {
        System.out.println("The owner of the account is: " + accountOwner.firstName + " " + accountOwner.lastName);
        System.out.println("The account number is: " + accountNumber);
        System.out.println("The type of account is: ");
        if (this instanceof investmentsAccount){
            System.out.println("Investments Account");
        } else {
            System.out.println("Savings Account");
        }
        System.out.println("Balance: " + balance);
        System.out.println("You account was created in: " + dateOfCreation);

        if (accountOwner instanceof  Employee) {
            System.out.println("You're a company employee");
            System.out.println("You belong to the department: " + (((Employee) accountOwner).department));
            System.out.println("Your job title is: " + (((Employee) accountOwner).jobTitle));
        }
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
