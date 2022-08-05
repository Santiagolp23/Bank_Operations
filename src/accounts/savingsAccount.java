public class savingsAccount extends Account{
    private String percentage;
    public savingsAccount(User accountOwner) {
        super(accountOwner);
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
