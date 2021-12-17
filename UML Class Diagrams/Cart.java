import java.util.ArrayList;

public class Cart {

	private Item item;
	private ArrayList<Item> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public Item getItem() {
		return item;
	}

	public void setItemsList(ArrayList<Item> items) {
		this.items = items;
	}
	
	public ArrayList<Item> getItemsList() {
		return this.items;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void addToCart(Item item) {
		items.add(item);
	}
	
	public void removeFromCart(Item item) {
		items.remove(item);
	}
	
	public void clearCart() {
		items.clear();
	}
	
}
