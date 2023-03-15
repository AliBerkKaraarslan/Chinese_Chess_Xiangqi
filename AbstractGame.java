//******************************************************************************
// AbstractGame.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Initializing all the items of game" operation
//
//******************************************************************************
import java.io.Serializable;

public abstract class AbstractGame implements Serializable {

	//Initializing all the elements of the game
	Board board;
	Player red;
	Player black;

	Soldier redSoldier1,redSoldier2,redSoldier3,redSoldier4,redSoldier5,blackSoldier1,blackSoldier2,blackSoldier3,blackSoldier4,blackSoldier5;
	Chariot redChariot1,redChariot2,blackChariot1,blackChariot2;
	Elephant redElephant1,redElephant2,blackElephant1,blackElephant2;
	Advisor redAdvisor1,redAdvisor2,blackAdvisor1,blackAdvisor2;
	General redGeneral,blackGeneral;
	Horse redHorse1,redHorse2,blackHorse1,blackHorse2;
	Cannon redCannon1,redCannon2,blackCannon1,blackCannon2;

	
	//Moves the item from "from" to "to" 
	//If the move is illegal then prints "Wrong Move!" and doesn't change the turn
	//If one of the players win the game prints "CHECK MATE! X win the game. X's point is: A, Y's point is: B". Where X and Y are the player names , A and B are points that players get
	abstract void play(String from, String to);  
	
	
	//Saves the current game to the specified file as binary.
	abstract void save_binary(String address);  
	
	
	// Saves the current game to the specified file as text.
	abstract void save_text(String address);  
	
	
	//Loads a game from specified text file
	abstract void load_text(String address);  
	
	
	//Loads a game from specified binary file
	abstract void load_binary(String address);  
	
	

}
