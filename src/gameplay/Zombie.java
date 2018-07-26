package gameplay;
/*
 * this class define a zombie has 30 hp
 */

public class Zombie extends Monster {
	public Zombie(int probability) {
		super("Zombie");
		super.setHealpoint(30);
	}
}
