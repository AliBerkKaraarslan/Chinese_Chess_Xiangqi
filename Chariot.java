//************************************************************************
// Chariot.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Override of findPossibleMoves and toString methods"
//
//************************************************************************

import java.util.ArrayList;

public class Chariot extends Item{

    public Chariot(String owner,Board board){
        this.owner = owner;
        itemsBoard=board;
        setPosition("xx");
        itemPoint=9;
    }
    //Override of findPossibleMoves method from Item.java
    public ArrayList<String> findPossibleMoves(String coordinates) {

        if(!getPosition().equals("xx")){
            ArrayList<String> moves = new ArrayList<String>();

            String arrayIndexes = itemsBoard.coordsToArray(getPosition());
            int firstIndex = Integer.parseInt(arrayIndexes.substring(0, 1));
            int secondIndex = Integer.parseInt(arrayIndexes.substring(1));

            //owner->0  opposite ->2  null->1  illegal -> -1

            //Checking right
            for(int i =1; secondIndex+i<9;i++){
                if(checkItem(firstIndex,secondIndex+i) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));
                }else if(checkItem(firstIndex,secondIndex+i) == 2){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));
                    i=10;
                }else{
                    i=10;
                }
            }

            //Checking left
            for(int i =-1; secondIndex+i>=0;i--){
                if(checkItem(firstIndex,secondIndex+i) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));
                }else if(checkItem(firstIndex,secondIndex+i) == 2){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));
                    i=-20;
                }else{
                    i=-20;
                }
            }

            //Checking down
            for(int i =1; firstIndex+i<=9;i++){
                if(checkItem(firstIndex+i,secondIndex) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));
                }else if(checkItem(firstIndex+i,secondIndex) == 2){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));
                    i=10;
                }else{
                    i=10;
                }
            }

            //Checking up
            for(int i =-1; firstIndex+i>=0;i--){
                if(checkItem(firstIndex+i,secondIndex) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));
                }else if(checkItem(firstIndex+i,secondIndex) == 2){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));
                    i=-20;
                }else{
                    i=-20;
                }
            }
            return moves;
        }
        return new ArrayList<>();
    }

    public String toString() {
        if (owner.equals("red")) {
            return "k";
        } else {
            return "K";
        }
    }
}
