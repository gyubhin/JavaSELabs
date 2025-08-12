package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate; // %

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, balance);
    }

    @Override
    public void printInfo() {
        System.out.printf("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%%n",
                accountNumber, ownerName, balance, interestRate);
    }
}