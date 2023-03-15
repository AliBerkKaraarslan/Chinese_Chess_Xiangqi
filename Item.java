//*******************************************************************************************************************
// Item.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Moving the item, Checking an Item. Finding possible moves of item. Setting item's position" operations
//
//*******************************************************************************************************************

import java.util.ArrayList;

public class Item extends AbstractItem{

	Board itemsBoard;
	String owner="";
	private ArrayList<String> possibleMoves;
	float itemPoint=0;

	{
		//Default position is "xx".
		setPosition("xx");
	}
	//Setting the owner. "red" or "black"
	public void setOwner(String owner) {
		this.owner = owner;
	}

	//This helps to use board's methods
	public void setItemsBoard(Board itemsBoard) {
		this.itemsBoard = itemsBoard;
	}

	//Moving the current item to destination
	public void move(String destination) {

		//Capturing the opposite team's item
		String arrayIndexes = itemsBoard.coordsToArray(destination);
		int firstIndex = Integer.parseInt(arrayIndexes.substring(0,1));
		int secondIndex = Integer.parseInt(arrayIndexes.substring(1));

		//If there is opposite team's item in the destination
		if(checkItem(firstIndex,secondIndex) ==2){

			//Adding the point of captured item to currentItem's team.

			//itemsBoard.players[0] is red player and itemsBoard.players[1] is black player

			//If red player captures a black Item
			if(itemsBoard.getItem(destination).owner.equals("black")){
				itemsBoard.players[0].puan+=itemsBoard.getItem(destination).itemPoint;

			}//If black player captures a red Item
			else{
				itemsBoard.players[1].puan+=itemsBoard.getItem(destination).itemPoint;
			}

			//Setting opposite team's position to "xx"
			itemsBoard.getItem(destination).setPosition("xx");

		}
		//Setting currentItem's position to destionation
		setPosition(destination);
	}

	//Checks the given coordinates. And returns if there is owner's item->0  opposite's item->2  null->1  illegal(outside board) -> -1
	public int checkItem(int firstIndex,int secondIndex){
		//returns: owner->0  opposite ->2  null->1  illegal -> -1

		String coordinates = itemsBoard.arrayToCoords(firstIndex,secondIndex);
		if(firstIndex>=0 && firstIndex<=9 ){

			if(secondIndex>=0 && secondIndex<=8) {
				Item currentItem = itemsBoard.getItem(coordinates);

				if (itemsBoard.isValid(coordinates)) {

					if (currentItem != null) {
						//Same team
						if (currentItem.owner.equals(this.owner)) {
							return 0;
						}//Opposite team
						else {
							return 2;
						}
					}//There is no item
					else {
						return 1;
					}
				}
			}
		}
		return -1;
	}

	//Returns all possible moves as arraylist
	public ArrayList<String> getPossibleMoves(){
			return findPossibleMoves(getPosition());
	}

	//Finds all possibleMoves.(Has to be overridden in all kind of items)
	public ArrayList<String> findPossibleMoves(String coordinates) {
		return null;
	}

}
