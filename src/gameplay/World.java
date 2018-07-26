package gameplay;

import java.util.Scanner;

/**
 * this is simple text game for assginment3 
 * @author Ruotong Xu ID: 16935995
 *
 */
public class World {//initialize the valuable that will be used in this class
	Scanner sc = new Scanner(System.in);
	private boolean gameInProgress;
	private PlayMode mode;
	private Typesituation type;
	Player player;
	private String inputCmd;
	Room room;
	Pickup[] items;

	public enum PlayMode {//define the play mode
		battle, explore;
	}
	public enum Typesituation{//define the type of object that player will command in
		food,key,lockpick,treasurechest,fistoffury,mobile,weapon,
		warchest,nu,nothing,valuable;
	}
	public void dependtype(String inputCmd){//A method to depend case by input value

		String[] tokens = inputCmd.toLowerCase().split(" ");//make the input string to two words by recognize the space in two word, to lower case means all the letters are lowercase 
	
		if(tokens[1].equals("axe")) {//tokens[1] means that the second word that player type in
			this.type = Typesituation.weapon;
		}
		else if(tokens[1].equals("bread")) {
			this.type = Typesituation.food;
		}
		else if(tokens[1].equals("chalice")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("coin")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("fistoffury")) {
			this.type = Typesituation.fistoffury;
		}
		else if(tokens[1].equals("goldbar")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("jewel")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("key")) {
			this.type = Typesituation.key;
		}
		else if(tokens[1].equals("lockpick")) {
			this.type = Typesituation.lockpick;
		}
		else if(tokens[1].equals("mead")) {
			this.type = Typesituation.food;
		}
		else if(tokens[1].equals("moneybag")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("ring")) {
			this.type = Typesituation.valuable;
		}
		else if(tokens[1].equals("roastboar")) {
			this.type = Typesituation.food;
		}
		else if(tokens[1].equals("sword")) {
			this.type = Typesituation.weapon;
		}
		else if(tokens[1].equals("treasurechest")) {
			this.type = Typesituation.treasurechest;
		}
		else if(tokens[1].equals("warchest")) {
			this.type = Typesituation.warchest;
		}
		else if(tokens[1] == null) {
			this.type = Typesituation.nu;
			System.out.println("Sorry what does "+this.inputCmd+" means");
		}
		else {
			this.type = Typesituation.nothing;
			System.out.println("Sorry I can not find "+tokens[1]);
		}
	}
/*
 * this method used to get how many doors can player get in 
 */
	private void door(String[] tokens) {
		if (null == tokens || tokens.length < 2) {//the door number should not be null and player can not input more than two words
			System.out.println("Please tell me the door number");
			return;
		}
		int n;
		try {
			n = Integer.parseInt(tokens[1]);
		} catch (Throwable t) {
			System.out.println("Please tell me the door number");
			return;
		}
		if (null != this.room.getConnectingRooms()[n - 1] && this.room.getConnectingRooms().length >= n
				&& null != this.room.getConnectingRooms()) {//this showing the number that user type in can not larger than the number of the door, and the number of the door get from how many room does it connected
			this.room = this.room.getConnectingRooms()[n - 1];//room is an array so it starts from 0, the number of player type in is always larger it than 1
			System.out.println(player.getName() + " bravely opens door " + n);
			this.onEnterRoom();
		} else {
			System.out.println("Sorry, no such door");
		}
	}

	public World(Room startRoom) {//define the room by the start file
		this.room = startRoom;
	}
/*
 * this method used to depend which type of mode will happen in this room, if this room has monster, it will be battle mode, otherwise is the explore mode.
 */
	private void onEnterRoom() {//
		gameInProgress = true;
		if (room.getMonster() == null || room.getMonster().getHealpoint() == 0) {
			mode = PlayMode.explore;
		} else {
			mode = PlayMode.battle;
			System.out.println("Opps, a " + room.getMonster().getDescription() + " get out!");
		}
	}
/*
 * this method is used to get the player input to pickup the object that the room have
 */
	private void pickup() {
		String[] tokens = this.inputCmd.toLowerCase().split(" ");
		for(Pickup p:room.getPickupsInRoom().getItems()) {//this is checking the room have this item or not by using for loop, the room has a inventory which is a array, so the for loop can check one by one
			if(p.compareID(tokens[1])!=null) {//if we can compare the thing that player input, we add this thing to players' inventory and delete it from room's inventory
				player.getInventory().add(p);
				room.getPickupsInRoom().remove(p);
				System.out.println(player.getName() + " pick up the " + tokens[1]);
				return;
			}
		}
		System.out.println("Warning: I couldn't find " + tokens[1]);//if we can not compare it just return this
	}
/*
 * this method is used to get the player input to admire the object that they have
 */
	private void admire() {
		String[] tokens = this.inputCmd.toLowerCase().split(" ");
		for(Pickup p:player.getInventory().getItems()) {//the same as pickup 
			if(p.compareID(tokens[1])!=null) {
		this.dependtype(this.inputCmd);//depend which type of things that user use
		switch(type) {
		case nu:
			System.out.println("Sorry you do not have" + tokens[1]);
			break;
		case food:
			Food food =(Food) p;//this one shows the pickup is a food, so that we can call the food function
			player.setHealpoint(player.getHealpoint() + food.getFoodheal());
			System.out.println(
					player.getName() + " ate the " + food.getDescription() + " and heal " + food.getFoodheal());
			player.getInventory().remove(p);
			break;
		case valuable:
			Valuables valuable = (Valuables) p;//same as food
			if (valuable.isConsumed() == true) {//check valuable is used or not
				System.out.println("Sorry this object has been used");
			} else {
				this.player.admire(valuable);
				player.setConfidence(player.getConfidence() + valuable.getValue());
				System.out.println(player.getName() + " use the " + valuable.getDescription());
				System.out.println("Bravely " + player.getName() + " confidence increase by " + valuable.getValue());
			}
			break;
		case mobile://call the mobile class to get the tweeter information
			Mobile mobile = (Mobile) p;
			player.setConfidence(player.getConfidence() + mobile.getValue());
			System.out.println("What you want to do with mobile phone? ");
			inputCmd = sc.nextLine();
			String result = mobile.showLatestTweetFrom(tokens[2]);//to get the lastest message that the person post
			System.out.println(result);
			break;
		case treasurechest:
			player.getInventory().remove(p);
			break;
		case warchest:
			player.getInventory().remove(p);
			break;
		
		case weapon:
			Wieldable weapon =(Wieldable) p;
			player.setWeapon(weapon);
			break;
		default:
			break;
		}
			}return;
		}System.out.println("Sorry you do not have that");
	}
/*
 * this method is used to process the user will do in explore mode by depending what user input
 */
	private void processExploreUserInput() {
		String[] tokens = this.inputCmd.toLowerCase().split(" ");
		if (tokens[0].equals("pickup") == true) {
			this.pickup();
		} else if (this.inputCmd.equals("exit") == true) {
			gameInProgress = false;
			System.out.println(
					player.getName() + " searched everywhere for the exit....\n" + "     ...and behold, found it.");
		} else if (this.inputCmd.equals("describe") == true) {
			System.out.println(room.getDescription());
			for (Pickup item : room.getPickupsInRoom().getItems()) {
				System.out.println("There is " + item.getDescription() + " on the floor");
			}
			System.out.println("There are " + room.getConnectingRooms().length + " doors");
			System.out.println(player);
		} else if (tokens[0].equals("admire") == true) {
			this.admire();
		} else if (tokens[0].equals("eat") == true) {
			this.admire();
		} else if (this.inputCmd.equals("help") == true) {
			System.out.println(
					"Explore commands: admire, describe, door, eat, exit, help, mobile, open, pickup, quit, stats, wield");
		} else if (this.inputCmd.equals("stats") == true) {
			System.out.println(player);
			System.out.println(player.getInventory().getItems().toString());
		} else if (tokens[0].equals("wield") == true) {
			this.admire();
			System.out.println(player.getName() + " has been wielded the " + tokens[1]);
		} else if (tokens[0].equals("mobile") == true) {
			if (player.getInventory().select(tokens[0]) == null) {
				System.out.println("Sorry you do not have a mobile");
			} else {
				this.admire();
			}
		} else if (tokens[0].equals("door") == true) {
			this.door(tokens);
		} else if (tokens[0].equals("open") == true) {
			Pickup pchest = player.getInventory().select(tokens[1]);
			Openable o = (Openable) pchest;
			if (o.isLocked() == true) {
			}
			if (tokens[1].equals("warchest")) {
				player.getInventory();
			}
		} else if (tokens[0].equals("door") == true) {
			door(tokens);
		} else {
			System.out.println("Sorry what does " + this.inputCmd + " means?");
		}
	}
	/*
	 * this method is used to process the user will do in battle mode by depending what user input
	 */
	private void processBattleUserInput() {
		String[] tokens = this.inputCmd.toLowerCase().split(" ");
		if (tokens[0].equals("attack") == true) {
			int x = player.defendAttack(room.getMonster());
			room.getMonster().defendAttack(player);
			System.out.println(room.getMonster().getDescription() + " sustains " + x + " damages");
			System.out.println(" ");
			System.out.println(player.getName() + " is wearing " + player.getArmour());
			System.out.println(player);
			if (room.getMonster().getHealpoint() != 0) {
				int y = room.getMonster().defendAttack(player);
				player.defendAttack(room.getMonster());
				System.out.println("Bravely " + player.getName() + " sustains " + y + " damages");
			}
		} else if (tokens[0].equals("wield") == true) {
			if(tokens[1].equals("fist")==false) {
			this.admire();
			} else {
				player.setFist();
				System.out.println(player.getName() + " has been wielded the Fist");
			}
		} else if (this.inputCmd.equals("help") == true) {
			System.out.println("Battle commands: attack, wield");
			this.inputCmd = sc.nextLine();
			this.processBattleUserInput();
		} else {
			System.out.println("Sorry what does " + this.inputCmd + " means?");
			this.inputCmd = sc.nextLine();
			this.processBattleUserInput();
		}
	}
/*
 * this method is used to define a player and his status, game mode
 */
	private void play(Player player) {
		this.player = player;
		System.out.println("Welcome player " + player.getName());

		System.out.println(player);
		this.onEnterRoom();//start the game by putting gameInProgress to true
		while (gameInProgress) {//a loop to keep the player playing the game by commanding 
			switch (mode) {
			case explore:
				this.inputCmd = sc.nextLine();
				processExploreUserInput();
				if (player.getHealpoint() == 0) {
					gameInProgress = false;
				} else {
					gameInProgress = true;
				}

				break;
			case battle:
				this.inputCmd = sc.nextLine();
				processBattleUserInput();
				if (player.getHealpoint() == 0) {//when the player is defeated
					System.out.println(
							"Alas! " + player.getName() + "has been defeated!\n" + "You have failed your quest");
					gameInProgress = false;
				} else if (room.getMonster().getHealpoint() == 0) {//when monster is defeated
					System.out.println("Bravely " + player.getName() + " kill the monster!");
					this.mode = PlayMode.explore;
				} else if (this.inputCmd.equals("exit")) {//when player do not want to play this game
					gameInProgress = false;
					System.out.println(player.getName() + " searched everywhere for the exit....\n"
							+ "     ...and behold, found it.");
				} else {//keep looping when it is true
					gameInProgress = true;
				}
				break;
			}
		}
	}

	// --------------------------------------------------------
	public static void main(String[] args) {
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("RTX", "Shiny Armour", 100, 200);
		world.play(playerOne);
	}
	// --------------------------------------------------------
}
