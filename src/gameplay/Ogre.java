package gameplay;
/**
 * Define a ogre has 40 hp
 * @author RuotongXu
 *
 */

public class Ogre extends Monster {
	Ogre(int probability) {
		super("Ogre");
		super.setHealpoint(40);
	}
}
