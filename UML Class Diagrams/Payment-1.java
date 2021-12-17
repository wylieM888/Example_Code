
public abstract class Payment {

	private double amount;
	
	public Payment(double amount) {
		super();
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
