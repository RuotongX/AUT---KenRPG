package gameplay;
/**
 *  A class which define a object that have the used or not used attribute
 * @author RuotongXu
 *
 */

public abstract class Consumable extends Pickup {
	boolean consumed = false;

	public Consumable(String description) {
		super(description);
	}

	public boolean isConsumed() {
		return consumed;
	}

	public void setConsumed() {
		this.consumed = true;
	}
}
