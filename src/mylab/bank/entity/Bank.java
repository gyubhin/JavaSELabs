package mylab.bank.entity;

import java.util.ArrayList;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private ArrayList<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000;
    }

    public Account createSavingsAccount(String owner, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        SavingsAccount acc = new SavingsAccount(accNum, owner, balance, interestRate);
        accounts.add(acc);
        System.out.println("저축 계좌가 생성되었습니다: ");
        acc.printInfo();
        return acc;
    }

    public Account createCheckingAccount(String owner, double balance, double limit) {
        String accNum = "AC" + nextAccountNumber++;
        CheckingAccount acc = new CheckingAccount(accNum, owner, balance, limit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: ");
        acc.printInfo();
        return acc;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccount);
        Account to = findAccount(toAccount);

        from.withdraw(amount);
        to.deposit(amount);
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccount, toAccount);
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            acc.printInfo();
        }
        System.out.println("===================");
    }
}
