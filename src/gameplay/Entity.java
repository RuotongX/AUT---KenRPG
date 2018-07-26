/**
 * This class used to define a Entity which all thing in this game have these attribute
 */
package gameplay;

import java.util.Random;

public abstract class Entity {//define valuables
	private String description;
	private String id;

	public Entity(String description) {//This is the Entity constructor
		this.description = description;
		this.id = this.getClass().getSimpleName();
	}

	public String getDescription() {//get method
		return description;
	}

	public void setDescription(String description) {//set method
		this.description = description;
	}

	public String getId() {//get method of id
		return id;
	}

	protected int protect() {//this is used to protect by using random
		return new Random().nextInt(10 - 3) + 3;
	}

	public String compareID(String id){//this method used to check the id of user input is equal to the id of object in the inventory or not
		String temp = this.id.toLowerCase();//make the id to lowercase because the id input is lowcase
		if(id.equals(temp) == false) {
			return null;
		}
		else {
			return id;
		}
	}

	public String toString() {//Tostring showing the id
		return "Entity [description=" + description + ", id=" + id + "]";
	}

}
