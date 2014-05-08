package Items;

@SuppressWarnings("serial")
public class EmptySlot extends Item{

	public EmptySlot(){
		this.setItemName("Empty Spot");
		this.setCurrentStack(1);
		this.setMaxStack(1);

		this.setCost(0);
		this.setValue(0);
	}
}
