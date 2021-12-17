
public class Credit extends Payment{
	
	private int accountNumber;
	
	public Credit(double amount) {
		super(amount);
	}

	public Credit(int accountNumber, double amount) {
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
