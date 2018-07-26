package gameplay;
/**
 * this class used to define a room with what's inside
 * @author RuotongXu
 *
 */

public class Room {
	private Monster monster;
	private Inventory pickupsInRoom;
	private Room[] connectingRooms;
	boolean finalRoom;
	private String description;

	public Room(String description, Inventory pickupsInRoom, Room[] connectingRooms) {
		this.description = description;
		this.pickupsInRoom = pickupsInRoom;
		this.connectingRooms = connectingRooms;
	}

	public Room() {
		this.monster = null;
		this.connectingRooms = null;
		this.description = null;
		this.pickupsInRoom = null;
	}

	public Monster getMonster() {
		return monster;
	}

	public Inventory getPickupsInRoom() {
		return pickupsInRoom;
	}

	public String getDescription() {
		return description;
	}

	public Room[] getConnectingRooms() {
		return connectingRooms;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public void setPickupsInRoom(Inventory pickupsInRoom) {
		this.pickupsInRoom = pickupsInRoom;
	}

	public void setConnectingRooms(Room[] connectingRooms) {
		this.connectingRooms = connectingRooms;
	}

	public void setFinalRoom(boolean finalRoom) {
		this.finalRoom = finalRoom;
	}

}
