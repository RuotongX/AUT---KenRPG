package gameplay;
/**
 * this class used to define a monster with the percentage that it will appear(by using random)and how can it deal damage
 */

import java.util.Random;

public abstract class Monster extends Character {
	private int probability, damage;

	public Monster(String description) {
		super(description);
	}

	public int dealAttackDamage() {
		int r = new Random().nextInt(10 - 1) + 1;
		int damage = this.damage + r;
		return damage;
	}

	public int defendAttack(Character enemy) {
		int d = enemy.dealAttackDamage();
		super.setHealpoint(super.getHealpoint() - d);
		return d;
	}

	public boolean appear() {
		if (super.getHealpoint() == 0) {
			return false;
		} else {
			int x = new Random().nextInt(101);
			if (x <= this.probability) {
				return true;
			} else {
				return false;
			}
		}
	}
}
