//**************************************************************************
// Elephant.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Override of findPossibleMoves and toString methods"
//
//**************************************************************************

import java.util.ArrayList;

public class Elephant extends Item{

    public Elephant(String owner,Board board){
        this.owner = owner;
        itemsBoard=board;
        setPosition("xx");
        itemPoint=2;
    }
    //Override of findPossibleMoves method from Item.java
    public ArrayList<String> findPossibleMoves(String coordinates) {
        if(!getPosition().equals("xx")) {
            ArrayList<String> moves = new ArrayList<String>();

            String arrayIndexes = itemsBoard.coordsToArray(getPosition());
            int firstIndex = Integer.parseInt(arrayIndexes.substring(0, 1));
            int secondIndex = Integer.parseInt(arrayIndexes.substring(1));

            if (owner.equals("red")) {
                if (firstIndex <= 6) {
                    if (checkItem(firstIndex + 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex + 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex - 2));
                        }
                    }
                } else {
                    if (checkItem(firstIndex + 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex + 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex - 2));
                        }
                    }
                    if (checkItem(firstIndex - 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex - 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex - 2));
                        }
                    }
                }
            } else if (owner.equals("black")) {

                if (firstIndex >= 3) {
                    if (checkItem(firstIndex - 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex - 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex - 2));
                        }
                    }
                } else {
                    if (checkItem(firstIndex + 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex + 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex + 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex + 2, secondIndex - 2));
                        }
                    }
                    if (checkItem(firstIndex - 1, secondIndex + 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex + 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex + 2));
                        }
                    }
                    if (checkItem(firstIndex - 1, secondIndex - 1) == 1) {
                        if (checkItem(firstIndex - 2, secondIndex - 2) >= 1) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex - 2, secondIndex - 2));
                        }
                    }
                }
            }
            return moves;
        }
        return new ArrayList<>();
    }
    public String toString() {
        if (owner.equals("red")) {
            return "f";
        } else {
            return "F";
        }
    }
}
