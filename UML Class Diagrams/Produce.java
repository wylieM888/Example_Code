
public class Produce extends Item{

	private double pricePerWeight;
	private double weight;
	
	public Produce() {
		
	}
	
	public Produce(double price, String name, int id) {
		super(price, name, id);
	}
	
	public Produce(double price, String name, int id, double pricePerWeight, double weight) {
		super(price, name, id);
		this.pricePerWeight = pricePerWeight;
		this.weight = weight;
		this.price = weight * pricePerWeight;
	}
	
		public double getPricePerWeight() {
		return pricePerWeight;
	}

	public void setPricePerWeight(double pricePerWeight) {
		this.pricePerWeight = pricePerWeight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
