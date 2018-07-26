package gameplay;
/**
 * this class used to define a player with the valuables and how the player deal damage and what player has
 * @author RuotongXu
 *
 */

public class Player extends Character {
	private int confidence;
	private String name;
	private Inventory inventory = new Inventory();
	private FistofFury fist = new FistofFury("Intial Condition");
	private Wieldable weapon = fist;
	private int h = weapon.getStrength();
	private int damage;
	private String armour;

	public Player(String name, String armour, int healpoint, int confidence) {
		super("Player");
		super.setHealpoint(healpoint);
		this.name = name;
		this.armour = armour;
		this.confidence = confidence;
		this.weapon = fist;
	}

	public void pickup(Valuables valuable) {

	}

	public void admire(Valuables valuable) {
		valuable.setConsumed();
	}

	public int getConfidence() {
		return confidence;
	}

	public String getName() {
		return name;
	}

	public Wieldable getWeapon() {
		return weapon;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public void setWeapon(Wieldable weapon) {
		this.weapon = weapon;
	}

	public void setFist() {
		this.weapon = fist;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public int getDamage() {
		return damage;
	}

	public String getArmour() {
		return armour;
	}

	protected int dealAttackDamage() {
		return (h + h * confidence) / 100;
	}

	public int defendAttack(Character enemy) {
		int damage = enemy.dealAttackDamage();
		super.setHealpoint(super.getHealpoint() - damage);
		confidence -= damage / 2;
		return damage;
	}

	public String toString() {
		return this.getName() + " is wearing " + this.getArmour() + "Health: " + super.getHealpoint() + " Confidence: "
				+ this.getConfidence() + " Wielding: " + this.getWeapon().getId();
	}
}
