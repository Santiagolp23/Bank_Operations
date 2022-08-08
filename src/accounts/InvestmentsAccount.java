package accounts;

import users.User;

public class InvestmentsAccount extends Account {
    public static int minimumBalance = 25000;

    public InvestmentsAccount(User accountOwner) {
        super(accountOwner);
    }

    @Override
    public void showAccountData() {
        super.showAccountData();
        System.out.println("The type of account is: ");
        System.out.println("Investments Account");
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


