//********************************************************************************
// Advisor.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Override of findPossibleMoves ,checkItem and toString methods"
//
//********************************************************************************

import java.util.ArrayList;

public class Advisor extends Item{

    public Advisor(String owner, Board board) {
        this.owner = owner;
        itemsBoard = board;
        setPosition("xx");
        itemPoint=2;
    }
    //Override of findPossibleMoves method from Item.java
    //Moves only diagonally in the palace
    public ArrayList<String> findPossibleMoves(String coordinates) {

        if(!getPosition().equals("xx")) {
            ArrayList<String> moves = new ArrayList<String>();

            String arrayIndexes = itemsBoard.coordsToArray(getPosition());
            int firstIndex = Integer.parseInt(arrayIndexes.substring(0, 1));
            int secondIndex = Integer.parseInt(arrayIndexes.substring(1));

            if (checkItem(firstIndex + 1, secondIndex + 1) >= 1) {
                moves.add(itemsBoard.arrayToCoords(firstIndex + 1, secondIndex + 1));
            }
            if (checkItem(firstIndex + 1, secondIndex - 1) >= 1) {
                moves.add(itemsBoard.arrayToCoords(firstIndex + 1, secondIndex - 1));
            }
            if (checkItem(firstIndex - 1, secondIndex + 1) >= 1) {
                moves.add(itemsBoard.arrayToCoords(firstIndex - 1, secondIndex + 1));
            }
            if (checkItem(firstIndex - 1, secondIndex - 1) >= 1) {
                moves.add(itemsBoard.arrayToCoords(firstIndex - 1, secondIndex - 1));
            }

            return moves;
        }
        return new ArrayList<>();
    }

    public String toString() {
        if (owner.equals("red")) {
            return "v";
        } else {
            return "V";
        }
    }
    //Override of checkItem() method from Item.java
    public int checkItem(int firstIndex, int secondIndex) {

        //returns: owner->0  opposite ->2  null->1  illegal -> -1

        String coordinates = itemsBoard.arrayToCoords(firstIndex, secondIndex);
        if(firstIndex>=0 && firstIndex<=9 && secondIndex>=0 && secondIndex<=8){

            Item currentItem = itemsBoard.getItem(coordinates);

            if (owner.equals("red")) {

                //Checking if it is in palace
                if (firstIndex >= 7 && secondIndex >= 3 && secondIndex <= 5) {
                    if (itemsBoard.isValid(coordinates)) {
                        if (currentItem != null) {
                            if (currentItem.owner.equals(owner)) {
                                return 0;
                            } else {
                                return 2;
                            }
                        } else {
                            return 1;
                        }
                    } else {
                        return -1;
                    }
                }
            }else if (owner.equals("black")) {

                //Checking if it is in palace
                if (firstIndex <= 2 && secondIndex >= 3 && secondIndex <= 5) {
                    if (itemsBoard.isValid(coordinates)) {
                        if (currentItem != null) {
                            if (currentItem.owner.equals(owner)) {
                                return 0;
                            } else {
                                return 2;
                            }
                        } else {
                            return 1;
                        }
                    } else {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }
}