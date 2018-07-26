package gameplay;
/**
 * the inventory storge the object that a player or room has
 */

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Pickup> items;

	// ------------------------------------
	public Inventory() {
		this.items = new ArrayList<Pickup>();
	}

	// ------------------------------------
	public String toString() {
		String out = "";
		for (Pickup p : items) {
			if (p != null) {
				out += p + ",";
			}
		}
		if (out.isEmpty())
			out = "nothing";
		return out;
	}

	// ------------------------------------
	public Pickup remove(String id) {
		Pickup p = this.select(id);

		this.items.remove(p);

		return p;
	}

	// ------------------------------------
	public Pickup select(String id) {
		for (Pickup p : this.items) {
			if (p != null && p.getId() != p.compareID(id)) {
				return p;
			}
		}
		return null;
	}

	// ------------------------------------
	public void add(Pickup p) {
		this.items.add(p);
	}

	// ------------------------------------
	public void remove(Pickup p) {
		this.items.remove(p);
	}

	// ------------------------------------
	public Pickup[] getItems() {
		Pickup[] items = new Pickup[this.items.size()];
		for (int i = 0; i < items.length; i++) {
			items[i] = this.items.get(i);
		}
		return items;
	}
}
