package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 계좌 생성
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        bank.printAllAccounts();

        try {
            // 입금/출금
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);

            // 이자 적용
            SavingsAccount sa = (SavingsAccount) bank.findAccount("AC1000");
            sa.applyInterest();

            // 계좌 이체
            bank.transfer("AC1002", "AC1001", 5000.0);

            bank.printAllAccounts();

            // 예외 테스트
            bank.withdraw("AC1001", 6000.0);
            bank.withdraw("AC1001", 7000.0);
            bank.deposit("AC9999", 1000.0);

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
