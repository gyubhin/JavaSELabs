package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

//package명은 소문자로

public class Account { //class명은 대문자로 시작
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor 선언 (기본 생성자)->멤버변수 초기화용
	public Account() { //class명이랑 동일
		System.out.println("기본 생성자 호출 테스트");
	} // 개발자가 생성자 안 만들었을때 기본 생성자 자동으로 만들어줌. 있으면 생성 X

	//Constructor Overloading(생성자 중복정의)
	public Account(String custId, String acctId, int balance) {
		super();
//		this.custId = custId;
//		this.acctId = acctId;
		setCustId(custId);
		setAcctId(acctId);
		this.balance = balance;
	}	
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getBalance() {
		return balance;
	}

//	public void setBalance(int newBalance) {
//		this.balance = newBalance; //두 변수명이 다르기때문에 굳이 this 쓸 필요 없음
//		//balance(멤버변수) = balance(입력 인자)와 같은 경우에는 this 필요
//	} -> balance 증감해주는 메서드 따로 있음(deposit, withdraw))
	
	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	//입금
	public void deposit(int amount) {
		//this.balance = this.balance+amount;
		this.balance += amount; //위에 같은 수식
	}

	//출금
	public void withdraw(int amount) throws InsufficientBalanceException{
		//잔액부족
		if(amount>this.balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액: %d)", amount, balance);
			//Exception 강제로 발생 시킴
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
}