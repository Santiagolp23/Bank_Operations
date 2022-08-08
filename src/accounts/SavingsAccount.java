package accounts;

import users.User;

public class SavingsAccount extends Account {
    public static int minimumBalance = 500;
    private short percentage;

    public SavingsAccount(User accountOwner, short percentage) {
        super(accountOwner);
        this.percentage = percentage;
    }

    public String getPercentage() {
        return percentage + "%";
    }

    public void setPercentage(short percentage) {
        this.percentage = percentage;
    }

    @Override
    public void showAccountData() {
        super.showAccountData();
        System.out.println("The type of account is: ");
        System.out.println("Savings Account");
        System.out.println("With " + getPercentage() + " annual return");
    }

    @Override
    public void withdraw(double amountToWithdraw) {
        if ((getBalance() - amountToWithdraw) < minimumBalance) {
            System.out.println("There has to be at least $" + minimumBalance + " in the account, " +
                    "please withdraw less money");
        } else {
            setBalance(getBalance() - amountToWithdraw);
            System.out.println("New balance is: $" + getBalance());
        }
    }
}
