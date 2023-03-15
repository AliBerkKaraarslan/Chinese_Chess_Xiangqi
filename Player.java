//***********************************************************************
// Player.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
//
//***********************************************************************


import java.io.Serializable;

public class Player implements Serializable{

	float puan; // her taş yedikçe oyuncunun puanı taşın puanına göre artar.

	Board playerBoard;
	String name;

	public Player(String name,Board board){
		this.name = name;
		playerBoard = board;
	}
}
