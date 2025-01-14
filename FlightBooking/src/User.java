public class User {
    private String userId;
    private String name;
    private double funds;

    public User(String userId, String name, double funds) {
        this.userId = userId;
        this.name = name;
        this.funds = funds;
    }

    public String getUserId() {
        return userId;
    }

    public double getFunds() {
        return funds;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", funds=" + funds +
                '}';
    }

    public void deductFund(double amount) {
        this.funds-=amount;
    }

    public void refund(double amount) {
        this.funds+=amount;
    }
}
