package ui;

import accounts.Account;
import accounts.InvestmentsAccount;
import accounts.SavingsAccount;
import users.Customer;
import users.Employee;
import users.User;

import java.util.Scanner;

public class UiMenu {
    static Scanner scan = new Scanner(System.in);
    static Account currentAccount;
    static User currentUser;

    public static void showMainMenu() {
        short response = 0;
        boolean redoLoop = false;
        System.out.println("Welcome to the bank 'Cup of Coffee' \n" +
                "Please create an User and Account before continuing");
        createUser();
        createAccount();
        System.out.println("Welcome " + currentUser.getFullName());
        do {
            System.out.println("Please enter the desired operation: \n" +
                    "1. Deposit\n" +
                    "2. Withdraw\n" +
                    "0. Exit");
            response = Short.parseShort(scan.nextLine());

            switch (response) {
                case 1:
                    depositMenu();
                    redoLoop = true;
                    break;

                case 2:
                    withdrawMenu();
                    redoLoop = true;
                    break;

                case 0:
                    redoLoop = false;
                    break;

                default:
                    System.out.println("Please enter a valid option");
                    redoLoop = true;
            }

        } while (redoLoop);
        System.out.println("Thanks for visiting our bank 'Cup of Coffee'");
    }

    public static void createUser() {
        String firstName, lastName;
        Long idNumber;
        int response = 0;

        System.out.println("Your first name: ");
        firstName = scan.nextLine();
        System.out.println("Your last name: ");
        lastName = scan.nextLine();
        System.out.println("Enter your ID Number: ");
        idNumber = Long.parseLong(scan.nextLine());

        do {
            System.out.println("Are you a company employee?\n" +
                    "1. Yes\n" +
                    "2. No");
            response = Integer.parseInt(scan.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Enter the department where you work: ");
                    String department = scan.nextLine();
                    System.out.println("Enter your job title: ");
                    String jobTitle = scan.nextLine();
                    currentUser = new Employee(firstName, lastName, idNumber, department, jobTitle);
                    response = 0;
                    break;

                case 2:
                    currentUser = new Customer(firstName, lastName, idNumber);
                    response = 0;
                    break;

                default:
                    response = 0;
            }

        } while (response != 0);
        currentUser.showUserData();
    }

    public static void createAccount() {
        int typeOfAccount; //1 = Savings, 2 = Investments
        boolean redoLoop = false;

        do {
            System.out.println("Enter the type of account you want to open:\n" +
                    "1. Savings\n" +
                    "2. Investments");
            typeOfAccount = Integer.parseInt(scan.nextLine());

            switch (typeOfAccount) {
                case 1:
                    short percentage;
                    double amount;
                    System.out.println("Enter the annual return of the Savings account: ");
                    percentage = Short.parseShort(scan.nextLine());
                    currentAccount = new SavingsAccount(currentUser, percentage);
                    do {
                        System.out.println("Please deposit at least $" + SavingsAccount.minimumBalance);
                        amount = Double.parseDouble(scan.nextLine());
                        if (amount < SavingsAccount.minimumBalance) {
                            redoLoop = true;
                        } else {
                            currentAccount.deposit(amount);
                            redoLoop = false;
                        }
                    } while (redoLoop);
                    redoLoop = false;
                    break;

                case 2:
                    currentAccount = new InvestmentsAccount(currentUser);
                    do {
                        System.out.println("Please deposit at least $" + InvestmentsAccount.minimumBalance);
                        amount = Double.parseDouble(scan.nextLine());
                        if (amount < InvestmentsAccount.minimumBalance) {
                            redoLoop = true;
                        } else {
                            currentAccount.deposit(amount);
                            redoLoop = false;
                        }
                    } while (redoLoop);
                    break;

                default:
                    System.out.println("Please select a valid option");
                    redoLoop = true;
                    break;
            }
        } while (redoLoop);
        currentAccount.showAccountData();

    }

    public static void withdrawMenu() {
        double amountToWithdraw;
        System.out.println("Enter the amount to withdraw: ");
        amountToWithdraw = Double.parseDouble(scan.nextLine());
        currentAccount.withdraw(amountToWithdraw);
    }

    public static void depositMenu() {
        double amountToDeposit;
        System.out.println("Enter the amount to deposit: ");
        amountToDeposit = Double.parseDouble(scan.nextLine());
        currentAccount.deposit(amountToDeposit);
    }

}
