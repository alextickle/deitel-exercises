package java_I_ch3;

public class PetrolPurchase {
	private String location;
	private String type;
	private int quantity;
	private double pricePerLiter;
	private double percentDiscount;
	
	public PetrolPurchase(String location, String type, int quantity, double pricePerLiter, double percentDiscount){
		this.location = location;
		this.type = type;
		this.quantity = quantity;
		this.pricePerLiter = pricePerLiter;
		this.percentDiscount = percentDiscount;
	}
	
	public double getPurchaseAmount(int quantity, double pricePerLiter, double percentDiscount){
		return quantity * pricePerLiter * (1 - percentDiscount);
	}
}
