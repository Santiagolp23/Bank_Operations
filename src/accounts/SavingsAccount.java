public class SavingsAccount extends Account{
    private String percentage;
    public SavingsAccount(User accountOwner) {
        super(accountOwner);
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
