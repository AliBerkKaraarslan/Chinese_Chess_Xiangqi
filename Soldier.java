//************************************************************************
// Soldier.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Override of findPossibleMoves and toString methods"
//
//************************************************************************

import java.util.ArrayList;

public class Soldier extends Item{

    public Soldier(String owner,Board board){
        this.owner = owner;
        itemsBoard=board;
        setPosition("xx");
        itemPoint=1;
    }
    //Override of findPossibleMoves method from Item.java
    public ArrayList<String> findPossibleMoves(String coordinates) {
        if(!getPosition().equals("xx")) {
            ArrayList<String> moves = new ArrayList<String>();

            String arrayIndexes = itemsBoard.coordsToArray(getPosition());
            int firstIndex = Integer.parseInt(arrayIndexes.substring(0, 1));
            int secondIndex = Integer.parseInt(arrayIndexes.substring(1));

            if (owner.equals("red")) {
                //If soldier didn't pass the river
                if (firstIndex >= 5) {

                    if (checkItem(firstIndex - 1, secondIndex) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex - 1, secondIndex));
                    }

                }//If soldier pass the river
                else if (firstIndex < 5) {
                    //Checks the upper
                    if (checkItem(firstIndex - 1, secondIndex) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex - 1, secondIndex));
                    }
                    if (checkItem(firstIndex, secondIndex - 1) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex - 1));
                    }
                    if (checkItem(firstIndex, secondIndex + 1) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex + 1));
                    }
                }
            } else if (owner.equals("black")) {
                //If soldier didn't pass the river
                if (firstIndex <= 4) {

                    if (checkItem(firstIndex + 1, secondIndex) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex + 1, secondIndex));
                    }

                }//If soldier pass the river
                else if (firstIndex > 4) {
                    //Checks the upper
                    if (checkItem(firstIndex + 1, secondIndex) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex + 1, secondIndex));
                    }
                    if (checkItem(firstIndex, secondIndex - 1) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex - 1));
                    }
                    if (checkItem(firstIndex, secondIndex + 1) >= 1) {
                        moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex + 1));
                    }
                }
            }
            return moves;
        }
        return new ArrayList<>();
    }
    public String toString() {
        if (owner.equals("red")) {
            return "p";
        } else {
            return "P";
        }
    }
}
