
public abstract class Item {

	protected double price;
	protected String name;
	protected int id;
	
	public Item() {
		
	}
	
	public Item(double price, String name, int id) {
		this.price = price;
		this.name = name;
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
