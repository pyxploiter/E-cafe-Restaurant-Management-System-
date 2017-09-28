package main;

public class ItemPreparation extends Item {
	private short cooksAvailable;
	private int preparationTime;
	
	
	public ItemPreparation() {
		
	}
	
	public int getAvailableCooks() {
		return this.cooksAvailable;
	}
	
	public void prepareItem(String itemName) {
		if(getAvailableCooks() > 0) {
			
			cooksAvailable--;
		}
		else {
			System.out.println("No cook is available. Kindly wait");
		}
	}
	
}
