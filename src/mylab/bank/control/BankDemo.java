package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // ���� ����
        bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        bank.printAllAccounts();

        try {
            // �Ա�/���
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);

            // ���� ����
            SavingsAccount sa = (SavingsAccount) bank.findAccount("AC1000");
            sa.applyInterest();

            // ���� ��ü
            bank.transfer("AC1002", "AC1001", 5000.0);

            bank.printAllAccounts();

            // ���� �׽�Ʈ
            bank.withdraw("AC1001", 6000.0);
            bank.withdraw("AC1001", 7000.0);
            bank.deposit("AC9999", 1000.0);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
