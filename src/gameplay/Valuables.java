package gameplay;
/**
 * A class which storge the object attribute, which is how much confidence increase while player use this object 
 * @author RuotongXu
 *
 */

public abstract class Valuables extends Consumable {
	private int value;

	public Valuables(String description, int value) {
		super(description);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
