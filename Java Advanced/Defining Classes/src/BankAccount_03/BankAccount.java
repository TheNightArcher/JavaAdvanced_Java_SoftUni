package BankAccount_03;

public class BankAccount {
    private static int accountCounter = 1;
    private static double insertRate = 0.02;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = accountCounter;
        accountCounter++;
    }

    public static void setInsertRate(double insert) {
        insertRate = insert;
    }

    public double getInsert(int years){
        return insertRate * years * balance;
    }
    public void deposit(double amount){
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
