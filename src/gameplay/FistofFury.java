package gameplay;
/**
 * this class used to define the fist maximum damage and minimum damage
 * @author RuotongXu
 *
 */

public class FistofFury extends Wieldable {
	public FistofFury(String description) {
		super(description);
		super.setHigh(25);
		super.setLow(20);
	}
}
