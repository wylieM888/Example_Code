
public class Debit extends Payment{
	
	private int accountNumber;
	
	public Debit(double amount) {
		super(amount);
	}
	
	public Debit(int accountNumber, double amount) {
		super(amount);
		this.accountNumber = accountNumber;
	}	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
