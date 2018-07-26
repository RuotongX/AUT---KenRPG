package gameplay;

public class TreasureChest extends Openable {
	private Valuables valuable;

	public TreasureChest(Valuables valuable) {
		super("Treasure Chest");
		this.valuable = valuable;
	}

	public Valuables getValuable() {
		return valuable;
	}
}
