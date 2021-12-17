
public class Order {

	private double subTotal;
	private double tax;
	private double total;
	
	public Order(double subTotal, double tax, double total) {
		super();
		this.subTotal = subTotal;
		this.tax = tax;
		this.total = total;
	}
	
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public void computeSubTotal() {
		
	}
	
	public void computeTax() {
		tax = subTotal * 0.0725;
	}
	
	public void computeTotal() {
		total = subTotal + tax;
	}
	
}
