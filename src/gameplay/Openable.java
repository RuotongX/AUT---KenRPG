package gameplay;

public abstract class Openable extends Pickup {
	private boolean locked = true;

	public Openable(String description) {
		super(description);
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked() {
		this.locked = false;
	}
}
