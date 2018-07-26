package gameplay;
/**
 * This class used to define a character with healpoint and description
 * @author RuotongXu
 *
 */

public abstract class Character extends Entity {
	private int healpoint;

	public int getHealpoint() {
		return healpoint;
	}

	public void setHealpoint(int healpoint) {
		if (healpoint <= 0) {
			this.healpoint = 0;
		} else {
			this.healpoint = healpoint;
		}
	}

	public Character(String description) {
		super(description);
	}

	protected abstract int dealAttackDamage();

	public abstract int defendAttack(Character enemy);
}
