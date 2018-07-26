package gameplay;
/**
 * this class used to define the sword maximum damage and minimum damage
 * @author RuotongXu
 *
 */

public class Sword extends Wieldable {
	public Sword(String description, int low, int high) {
		super(description);
		super.setHigh(high);
		super.setLow(low);
	}
}
