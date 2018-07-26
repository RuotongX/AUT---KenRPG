package gameplay;
/**
 * the wieldable class which calculate how much a weapon does in one times by using random method
 */

import java.util.Random;

public abstract class Wieldable extends Pickup {
	private int high, low;
	private int strength;

	public void setHigh(int high) {
		this.high = high;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getStrength() {
		strength = this.hit(high, low);
		return strength;
	}

	public int hit(int high, int low) {

		int temp = 0;
		if (high > low) {
			temp = new Random().nextInt(high - low) + low;
		}
		return temp;
	}

	public Wieldable(String description) {
		super(description);
	}
}
