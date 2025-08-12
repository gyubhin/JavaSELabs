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
        System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n", interest, balance);
    }

    @Override
    public void printInfo() {
        System.out.printf("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%%n",
                accountNumber, ownerName, balance, interestRate);
    }
}