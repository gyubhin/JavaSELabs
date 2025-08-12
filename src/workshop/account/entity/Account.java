package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

//package���� �ҹ��ڷ�

public class Account { //class���� �빮�ڷ� ����
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor ���� (�⺻ ������)->������� �ʱ�ȭ��
	public Account() { //class���̶� ����
		System.out.println("�⺻ ������ ȣ�� �׽�Ʈ");
	} // �����ڰ� ������ �� ��������� �⺻ ������ �ڵ����� �������. ������ ���� X

	//Constructor Overloading(������ �ߺ�����)
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
//		this.balance = newBalance; //�� �������� �ٸ��⶧���� ���� this �� �ʿ� ����
//		//balance(�������) = balance(�Է� ����)�� ���� ��쿡�� this �ʿ�
//	} -> balance �������ִ� �޼��� ���� ����(deposit, withdraw))
	
	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	//�Ա�
	public void deposit(int amount) {
		//this.balance = this.balance+amount;
		this.balance += amount; //���� ���� ����
	}

	//���
	public void withdraw(int amount) throws InsufficientBalanceException{
		//�ܾ׺���
		if(amount>this.balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, balance);
			//Exception ������ �߻� ��Ŵ
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
}