
public class Check extends Payment{

	private String name;
	private int bankID;
	
	public Check(double amount) {
		super(amount);
	}

	public Check(String name, int bankID, double amount) {
		super(amount);
		this.name = name;
		this.bankID = bankID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	
}
