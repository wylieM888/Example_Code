
public class Electronic extends Item{
	
	private boolean isSubscription;
	
	public Electronic(double price, String name, int id) {
		super(price, name, id);
	}
	
	public Electronic(double price, String name, int id, boolean isSubscription) {
		super(price, name, id);
		this.setSubscription(isSubscription);
	}
	
	public boolean getIsSubscription() {
		return this.isSubscription;
	}
	
	public void setIsSubscription(boolean sub) {
		this.isSubscription = sub;
	}

	public void setSubscription(boolean isSubscription) {
		this.isSubscription = isSubscription;
	}
	
}
