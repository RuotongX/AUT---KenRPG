package gameplay;

public class WarChest extends Openable {
	private Wieldable weapon;

	public WarChest(Wieldable weapon) {
		super("Weapon");
		this.weapon = weapon;
	}

	public Wieldable getWeapon() {
		return weapon;
	}
}
