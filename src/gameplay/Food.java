package gameplay;
/**
 * this class used to define the food and how much the food can heal hp
 * @author RuotongXu
 *
 */

public abstract class Food extends Consumable {
	private int foodheal;

	public Food(String desciption, int foodheal) {
		super(desciption);
		this.foodheal = foodheal;
	}

	public int getFoodheal() {
		return foodheal;
	}
}
