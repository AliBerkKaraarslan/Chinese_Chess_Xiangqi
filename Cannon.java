//**************************************************************************
// Cannon.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Override of findPossibleMoves and toString methods"
//
//**************************************************************************

import java.util.ArrayList;

public class Cannon extends Item {

    public Cannon(String owner,Board board){
        this.owner = owner;
        itemsBoard=board;
        setPosition("xx");
        itemPoint=4.5f;
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
            for(int i =1; secondIndex+i<=9;i++){

                if(checkItem(firstIndex,secondIndex+i) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));

                }else if((checkItem(firstIndex,secondIndex+i) == 2) || (checkItem(firstIndex,secondIndex+i) == 0)){

                    for(int j=i+1; secondIndex+j<=9;j++){

                        if(checkItem(firstIndex,secondIndex+j) == 0) {
                            i=20;
                            j=20;
                        }else if(checkItem(firstIndex,secondIndex+j) == 2) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex + j));
                            i=20;
                            j=20;
                        }else if(checkItem(firstIndex,secondIndex+j+1) == -1){
                            i=20;
                            j=20;
                        }
                    }
                }else{
                    i=20;
                }
            }

            //Checking left
            for(int i =-1; secondIndex+i>=0;i--){
                if(checkItem(firstIndex,secondIndex+i) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex+i));

                }else if((checkItem(firstIndex,secondIndex+i) == 2) || (checkItem(firstIndex,secondIndex+i) == 0)){

                    for(int j=i-1; secondIndex+j>=0;j--){

                        if(checkItem(firstIndex,secondIndex+j) == 0) {
                            i=-20;
                            j=-20;
                        }else if(checkItem(firstIndex,secondIndex+j) == 2) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex, secondIndex + j));
                            i=-20;
                            j=-20;
                        }else if(checkItem(firstIndex,secondIndex+j-1) == -1){
                            i=-20;
                            j=-20;
                        }
                    }
                }else{
                    i=-20;
                }
            }

            //Checking down
            for(int i =1; firstIndex+i<=9;i++){
                if(checkItem(firstIndex+i,secondIndex) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));

                }else if((checkItem(firstIndex+i,secondIndex) == 2) || (checkItem(firstIndex+i,secondIndex) == 0)){

                    for(int j=i+1; firstIndex+j<=9;j++){

                        if(checkItem(firstIndex+j,secondIndex) == 0) {
                            i=20;
                            j=20;
                        }else if(checkItem(firstIndex+j,secondIndex) == 2) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex+j, secondIndex));
                            i=20;
                            j=20;
                        }else if(checkItem(firstIndex+j+1,secondIndex) == -1){
                            i=20;
                            j=20;
                        }
                    }
                }else{
                    i=20;
                }
            }

            //Checking up
            for(int i =-1; firstIndex+i>=0;i--){
                if(checkItem(firstIndex+i,secondIndex) == 1){
                    moves.add(itemsBoard.arrayToCoords(firstIndex+i, secondIndex));

                }else if((checkItem(firstIndex+i,secondIndex) == 2) || (checkItem(firstIndex+i,secondIndex) == 0)){

                    for(int j=i-1; firstIndex+j>=0;j--){

                        if(checkItem(firstIndex+j,secondIndex) == 0) {
                            i=-20;
                            j=-20;
                        }else if(checkItem(firstIndex+j,secondIndex) == 2) {
                            moves.add(itemsBoard.arrayToCoords(firstIndex+j, secondIndex));
                            i=-20;
                            j=-20;
                        }else if(checkItem(firstIndex+j-1,secondIndex) == -1){
                            i=-20;
                            j=-20;
                        }
                    }
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
            return "t";
        } else {
            return "T";
        }
    }
}
