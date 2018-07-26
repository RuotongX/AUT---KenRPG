package gameplay;
/**
 * this class used to define the fist maximum damage and minimum damage by the file that define in read world file
 * @author RuotongXu
 *
 */

public class Axe extends Wieldable {
	public Axe(String description, int low, int high) {
		super(description);
		super.setHigh(high);
		super.setLow(low);
	}
}
