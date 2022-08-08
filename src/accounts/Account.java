package accounts;

import users.Employee;
import users.User;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Account {
    private static Long accountNumberCounter = 0L;
    public LocalDate dateOfCreation;
    public User accountOwner;
    Scanner scan = new Scanner(System.in);
    private Long accountNumber;
    private Double balance = 0.0;

    public Account(User accountOwner) {
        this.accountOwner = accountOwner;
        accountNumberCounter++;
        accountNumber = accountNumberCounter;
        this.dateOfCreation = LocalDate.now();
    }

    public void showAccountData() {
        System.out.println("The owner of the account is: " + accountOwner.firstName + " " + accountOwner.lastName);
        System.out.println("The account number is: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("You account was created in: " + dateOfCreation);

        if (accountOwner instanceof users.Employee) {
            System.out.println("You're a company employee");
            System.out.println("You belong to the department: " + ((Employee) accountOwner).getDepartment());
            System.out.println("Your job title is: " + (((Employee) accountOwner).getJobTitle()));
        }
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("New balance is: $" + getBalance());
    }

    public void withdraw(double amountToWithdraw) {
        if (balance < amountToWithdraw) {
            System.out.println("The balance is lower than $" + amountToWithdraw + ", the transaction failed");
        } else {
            balance -= amountToWithdraw;
            System.out.println("New balance is: $" + balance);
        }

    }

}
