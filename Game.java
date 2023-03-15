//******************************************************************************************************************
// Game.java         Author:Ali Berk Karaarslan     Date:09.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Creating a new game.Playing the game. Saving and Loading as binary and normal text files" operations
//
//******************************************************************************************************************

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends AbstractGame{

    //General Game Variables
    String turn = "red";
    Item[] redItems = new Item[16];
    Item[] blackItems = new Item[16];
    Boolean gameOver = false;

    //Repetitive Check Variables
    ArrayList<String> repetitiveCoords = new ArrayList<String>();
    int count=1;
    String threat="";
    String cannotMove="";
    boolean firstMove=true;

    //Game constructor. Creates board,players,items. Then sets the items' position to their default position
    public Game(String player1,String player2){

        board = new Board();
        red = new Player(player1,board);
        black = new Player(player2,board);

        red.puan=0;
        black.puan=0;

        board.players = new Player[]{red,black};

        //Creating all items
        redSoldier1 = new Soldier("red",board);
        redSoldier2 = new Soldier("red",board);
        redSoldier3 = new Soldier("red",board);
        redSoldier4 = new Soldier("red",board);
        redSoldier5 = new Soldier("red",board);

        blackSoldier1 = new Soldier("black",board);
        blackSoldier2 = new Soldier("black",board);
        blackSoldier3 = new Soldier("black",board);
        blackSoldier4 = new Soldier("black",board);
        blackSoldier5 = new Soldier("black",board);

        redChariot1 = new Chariot("red",board);
        redChariot2 = new Chariot("red",board);

        blackChariot1 = new Chariot("black",board);
        blackChariot2 = new Chariot("black",board);

        redElephant1 = new Elephant("red",board);
        redElephant2 = new Elephant("red",board);

        blackElephant1 = new Elephant("black",board);
        blackElephant2 = new Elephant("black",board);

        redAdvisor1 = new Advisor("red",board);
        redAdvisor2 = new Advisor("red",board);

        blackAdvisor1 = new Advisor("black",board);
        blackAdvisor2 = new Advisor("black",board);

        redHorse1 = new Horse("red",board);
        redHorse2 = new Horse("red",board);

        blackHorse1 = new Horse("black",board);
        blackHorse2 = new Horse("black",board);

        redCannon1 = new Cannon("red",board);
        redCannon2 = new Cannon("red",board);

        blackCannon1 = new Cannon("black",board);
        blackCannon2 = new Cannon("black",board);

        redGeneral = new General("red",board);

        blackGeneral = new General("black",board);


        //Setting all items positions
        redSoldier1.setPosition("d1");
        redSoldier2.setPosition("d3");
        redSoldier3.setPosition("d5");
        redSoldier4.setPosition("d7");
        redSoldier5.setPosition("d9");

        blackSoldier1.setPosition("g1");
        blackSoldier2.setPosition("g3");
        blackSoldier3.setPosition("g5");
        blackSoldier4.setPosition("g7");
        blackSoldier5.setPosition("g9");

        redChariot1.setPosition("a1");
        redChariot2.setPosition("a9");

        blackChariot1.setPosition("j1");
        blackChariot2.setPosition("j9");

        redElephant1.setPosition("a3");
        redElephant2.setPosition("a7");

        blackElephant1.setPosition("j3");
        blackElephant2.setPosition("j7");

        redAdvisor1.setPosition("a4");
        redAdvisor2.setPosition("a6");

        blackAdvisor1.setPosition("j4");
        blackAdvisor2.setPosition("j6");

        redHorse1.setPosition("a2");
        redHorse2.setPosition("a8");

        blackHorse1.setPosition("j2");
        blackHorse2.setPosition("j8");

        redCannon1.setPosition("c2");
        redCannon2.setPosition("c8");

        blackCannon1.setPosition("h2");
        blackCannon2.setPosition("h8");

        redGeneral.setPosition("a5");

        blackGeneral.setPosition("j5");

        //Filling the item arrays
        board.items = new Item[]{redSoldier1,redSoldier2,redSoldier3,redSoldier4,redSoldier5,blackSoldier1,blackSoldier2
                ,blackSoldier3,blackSoldier4,blackSoldier5,redChariot1,redChariot2,blackChariot1,blackChariot2,redElephant1,
                redElephant2,blackElephant1,blackElephant2,redAdvisor1,redAdvisor2, blackAdvisor1,blackAdvisor2,redHorse1,
                redHorse2,blackHorse1,blackHorse2,redCannon1,redCannon2,blackCannon1,blackCannon2,redGeneral,blackGeneral,};

        redItems = new Item[]{redSoldier1,redSoldier2,redSoldier3,redSoldier4,redSoldier5,redChariot1,redChariot2,redElephant1,
                redElephant2,redAdvisor1,redAdvisor2,redHorse1,redHorse2,redCannon1,redCannon2,redGeneral};

        blackItems = new Item[]{blackSoldier1,blackSoldier2,blackSoldier3,blackSoldier4,blackSoldier5,blackChariot1,blackChariot2,
                blackElephant1,blackElephant2,blackAdvisor1,blackAdvisor2,blackHorse1,blackHorse2,blackCannon1,blackCannon2,blackGeneral};

    }

    //Returns board
    public Board getBoard(){
        return board;
    }

    //Moves the item if there is no obstacle
    void play(String from, String to) {

        //Checks if it is gameover
        if(!gameOver) {

            //Is given coordinates valid(do they exist)
            if (board.isValid(from) && board.isValid(to)) {

                //Is given coordinate empty
                if (!board.printItem(from).equals("-")) {
                    Item currentItem = board.getItem(from);

                    //Is it currentItem's owner's turn
                    if (currentItem.owner.equals(turn)) {

                        //Is the destination is in possible moves
                        if (currentItem.getPossibleMoves().contains(to)) {

                            //If there is no pin after move
                            if (!checkPin(from, to)) {

                                //If there is no repetitive check
                                if(!isThereRepetitive(from,to)) {

                                    //Moves the item
                                    currentItem.move(to);
                                    //If there is check then calls the checkAll() method (If the game is over) and checks repetitive check
                                    if (check()) {

                                        //Checks all items for possible checkmate
                                        checkAll();

                                        //finding threat (who made the check)
                                        if (turn.equals("red")) {
                                            threat = "red";
                                        } else {
                                            threat = "black";
                                        }

                                        //cannotMove is coordinate of repetitive check.(Most of the time it's null)
                                        cannotMove = checkRepetitive();

                                    //If there is no repetitive check then resets all the values
                                    } else if (!threat.equals("") && threat.equals(turn)) {
                                        count = 1;
                                        repetitiveCoords.clear();
                                        firstMove = true;
                                        threat = "";
                                        cannotMove = "";
                                    }

                                    //Changes the turn
                                    if (turn.equals("red")) {
                                        turn = "black";
                                    } else {
                                        turn = "red";
                                    }

                                }else {
                                    System.out.println("hatali hareket");
                                }
                            } else {
                                System.out.println("hatali hareket");
                            }
                        } else {
                            System.out.println("hatali hareket");
                        }
                    } else {
                        System.out.println("hatali hareket");
                    }
                } else {
                    System.out.println("hatali hareket");
                }
            } else {
                System.out.println("hatali hareket");
            }
        }else {
            System.out.println("hatali hareket");
        }
    }

    //Checks the probability of check AFTER move. If there is check then returns true.(Means you can't move)
    public boolean checkPin(String from,String to){
        //Simulates the move then checks is there is check.

        Item currentItem = board.getItem(from);
        Item possibleOpposite= board.getItem(to);

        //If the coordinate where user wants to go has another item. Sets its position to "xx".Simulates like it's captured
        if(possibleOpposite!=null){
            possibleOpposite.setPosition("xx");
        }
        //Sets the current item's coordinate to "to". Simulates like it's moved to that point
        currentItem.setPosition(to);

        //If user moves a red item then checks all the black items' possibleMoves.
        if(currentItem.owner.equals("red")) {

            for (Item item : blackItems) {

                //If item's coordinate matches with red general's coordinate then cancels the move(returns true)
                if (item.getPossibleMoves().contains(redGeneral.getPosition())) {

                    //Setting to old coordinates
                    currentItem.setPosition(from);

                    if (possibleOpposite != null) {
                        possibleOpposite.setPosition(to);
                    }

                    return true;
                }
            }
            //If user moves a black item then checks all the red items' possibleMoves.
        }else if(currentItem.owner.equals("black")) {

            for (Item item : redItems) {

                //If item's coordinate matches with black general's coordinate then cancels the move(returns true)
                if (item.getPossibleMoves().contains(blackGeneral.getPosition())) {

                    //Setting to old coordinates
                    currentItem.setPosition(from);

                    if (possibleOpposite != null) {
                        possibleOpposite.setPosition(to);
                    }
                    return true;
                }
            }
        }

        //Setting to old coordinates
        currentItem.setPosition(from);

        if (possibleOpposite != null) {
            possibleOpposite.setPosition(to);
        }

        //Checks the flying general rule by calling checkFlyingGeneral(). (Works if user wants to move an item horizontally)
        if(checkFlyingGeneral(currentItem,to)) {

            return true;
        }
        return false;
    }

    //Is there is check
    public boolean check(){

        //Checks for check opportunity after playing red
        if(turn.equals("red")){
            //Checking all red items
            for (Item item : redItems) {

                //If one of the move's coordinate matches with other general's coordinate then returns true.(Means there is check)
                if(item.getPossibleMoves().contains(blackGeneral.getPosition())){
                    return true;
                }
            }
            //Checks for check opportunity after playing black
        }else if(turn.equals("black")){
            for (Item item : blackItems) {

                //If one of the move's coordinate matches with other general's coordinate then returns true.(Means there is check)
                if(item.getPossibleMoves().contains(redGeneral.getPosition())){
                    return true;
                }
            }
        }
        return false;
    }

    //Finds the restricted coordinate (cannotMove) by filling repetitiveCoords ArrayList.
    //If user tries to check same coordinates MORE THAN three times then it returns the restricted coordinate(The coordinate that you can't make check)
    //The very first check DOESN'T COUNT as repetitive. Therefore, it called "firstMove"
    public String checkRepetitive(){

        //Red made a check
        if(turn.equals("red")){

            //If it is not first check
            if(!firstMove) {

                if(repetitiveCoords.size()<2){
                    repetitiveCoords.add(blackGeneral.getPosition());

                }else{
                    //If user wants to recheck the first position (it affects count)
                    if(repetitiveCoords.get(0).equals(blackGeneral.getPosition())){
                        repetitiveCoords.add(blackGeneral.getPosition());
                        count++;

                    //If user wants to recheck the second position (it doesn't affect count)
                    }else if(repetitiveCoords.get(1).equals(blackGeneral.getPosition())) {
                        repetitiveCoords.add(blackGeneral.getPosition());
                    }
                    //Resetting the values
                    else{
                        repetitiveCoords.clear();
                        count=1;
                        firstMove=true;
                    }
                }
            }else{
                firstMove=false;
            }

        //Black made a check
        }else if(turn.equals("black")){

            //If it is not first check
            if(!firstMove) {

                if(repetitiveCoords.size()<2){
                    repetitiveCoords.add(redGeneral.getPosition());

                }else{
                    //If user wants to recheck the first position (it affects count)
                    if(repetitiveCoords.get(0).equals(redGeneral.getPosition())){
                        repetitiveCoords.add(redGeneral.getPosition());
                        count++;

                    //If user wants to recheck the second position (it doesn't affect count)
                    }else if(repetitiveCoords.get(1).equals(redGeneral.getPosition())) {
                        repetitiveCoords.add(redGeneral.getPosition());
                    }
                    //Resetting the values
                    else{
                        repetitiveCoords.clear();
                        count=1;
                        firstMove=true;
                    }
                }
            }else{
                firstMove=false;
            }
        }
        //If user tries to check the same coordinates MORE THAN 3 times returns the coordinates
        if(count>2){
            return repetitiveCoords.get(0);
        }
        return "";
    }

    //Checks if item's destination is restricted (repetitive check). If yes then returns true (means item can't move to that coordinate)
    public boolean isThereRepetitive(String from,String to){

        //If it is threat's turn
        if(!threat.equals("") && threat.equals(turn)){

            //If threat try to move restricted area
            if(!cannotMove.equals("") && checkCannotMove(from,to,cannotMove)){
                return true;

            //If there is no restricted move
            }else if(cannotMove.equals("")){
                return false;

            //If it is a normal move
            }else{
                return false;
            }
        //If there is no threat OR it is not treat's turn
        }else if(threat.equals("") || !threat.equals(turn)){
            return false;
        }
        return true;
    }

    //Simulates the move then checks if it is restricted move (repetitive check) (So similar to checkPin() method)
    public boolean checkCannotMove(String from,String to,String cannotMove){

        Item currentItem = board.getItem(from);
        Item possibleOpposite= board.getItem(to);

        //If the coordinate where user wants to go has another item. Sets its position to "xx".Simulates like it's captured
        if(possibleOpposite!=null){
            possibleOpposite.setPosition("xx");
        }
        //Sets the current item's coordinate to "to". Simulates like it's moved to that point
        currentItem.setPosition(to);

        //If item's new coordinate's possible moves matches with restricted coordinate (repetitive check) cancels the move(returns true)
        if (currentItem.getPossibleMoves().contains(cannotMove)) {

            //Setting to old coordinates
            currentItem.setPosition(from);

            if (possibleOpposite != null) {
                possibleOpposite.setPosition(to);
            }
            return true;
        }
        //Setting to old coordinates
        currentItem.setPosition(from);
        if (possibleOpposite != null) {
            possibleOpposite.setPosition(to);
        }
        return false;
    }

    //Checking all items and controls if there is escape opportunity for general
    //Checking all possible moves for threatened team. Simulates them. If there is opportunity then returns false.If no then calls checkMate()
    public boolean checkAll(){

        boolean checkMateStatus = true;

        //If black general is threatened.
        if(turn.equals("red")) {
            //Checking all black items
            for (Item item : blackItems) {

                for(int i=0;i<item.getPossibleMoves().size();i++) {

                    //If one of the moves can remove the threat
                    if (!checkPin(item.getPosition(), item.getPossibleMoves().get(i))) {
                        checkMateStatus= false;
                    }
                }
            }
            //If red general is threatened
        }else if(turn.equals("black")) {
            //Checking all black items
            for (Item item : redItems) {

                for(int i=0;i<item.getPossibleMoves().size();i++) {

                    //If one of the moves can remove the threat
                    if (!checkPin(item.getPosition(), item.getPossibleMoves().get(i))) {
                        checkMateStatus= false;
                    }
                }
            }
        }
        //If there is no opportunity then calls checkMate()
        if(checkMateStatus)
            checkMate();
        return checkMateStatus;
    }

    //Prints the winner and the points
    public void checkMate(){
        //Red wins
        if(turn.equals("black")) {
            System.out.println("ŞAH MAT! " + black.name + " oyunu kazandı. " + black.name + "'in puanı: " + black.puan + ", " + red.name + "'nin puanı: " + red.puan);
        }//Black wins
        else if(turn.equals("red")) {
            System.out.println("ŞAH MAT! " + red.name + " oyunu kazandı. " + red.name + "'in puanı: " + red.puan + ", " + black.name + "'nin puanı: " + black.puan);
        }
        gameOver = true;
    }

    //Checks the flying general rule(two generals can't face to face without any items between)
    public boolean checkFlyingGeneral(Item currentItem,String to){
        int itemCount=0;

        //If user is trying to move general
        if(currentItem.equals(redGeneral) || currentItem.equals(blackGeneral)){
            Item otherGeneral = null;

            //Detecting the other general
            if(currentItem.equals(redGeneral)) {
                otherGeneral = blackGeneral;
            }else{
                otherGeneral = redGeneral;
            }

            //If current general's will's second index equals to other general's second index then returns true(Means they cant move)
            if(to.substring(1).equals(otherGeneral.getPosition().substring(1))) {

                int secondDigit = Integer.parseInt(otherGeneral.getPosition().substring(1))-1;
                int blackGeneralPos = Integer.parseInt(board.coordsToArray(blackGeneral.getPosition()).substring(0,1));
                int redGeneralPos = Integer.parseInt(board.coordsToArray(redGeneral.getPosition()).substring(0,1));

                //Counting the items between two generals
                for(int i=blackGeneralPos+1;i<redGeneralPos;i++){
                    if(board.getItem(board.arrayToCoords(i,secondDigit))!=null){
                        itemCount++;
                    }
                }

                //If general want's to move vertical
                if(Integer.parseInt(currentItem.getPosition().substring(1)) == (Integer.parseInt(to.substring(1)))){
                    return false;
                }

                if(itemCount<1){
                    return true;
                }else{
                    return false;
                }

            }else{
                return false;
            }
        }

        //If user is trying to move another item
        //If two generals' second index is same
        if(redGeneral.getPosition().substring(1).equals(blackGeneral.getPosition().substring(1))){

            //If user wants to move an item that has the same secondIndex with generals
            if(currentItem.getPosition().substring(1).equals(blackGeneral.getPosition().substring(1))){

                int secondDigit = Integer.parseInt(currentItem.getPosition().substring(1))-1;
                int blackGeneralPos = Integer.parseInt(board.coordsToArray(blackGeneral.getPosition()).substring(0,1));
                int redGeneralPos = Integer.parseInt(board.coordsToArray(redGeneral.getPosition()).substring(0,1));
                int currentItemPos = Integer.parseInt(board.coordsToArray(currentItem.getPosition()).substring(0,1));
                int destinationPos= Integer.parseInt(board.coordsToArray(to).substring(0,1));

                //Counting the items between two generals
                for(int i=blackGeneralPos+1;i<redGeneralPos;i++){
                    if(board.getItem(board.arrayToCoords(i,secondDigit))!=null){
                        itemCount++;
                    }
                }

                //If user wants to move vertical
                if(Integer.parseInt(currentItem.getPosition().substring(1)) == (Integer.parseInt(to.substring(1)))){

                    //If item is between generals and wants to move outside them (cannon move)
                    if(currentItemPos>blackGeneralPos || currentItemPos<redGeneralPos) {
                        if (destinationPos < blackGeneralPos || destinationPos > redGeneralPos) {
                            if (itemCount < 2) {
                                return true;
                            }
                        }
                    }
                    return false;
                }

                //If item is outside generals
                if(currentItemPos<blackGeneralPos || currentItemPos>redGeneralPos){
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }

        //If there is less than 2 items in between generals returns true.(Means you can't move)
        if(itemCount<2){
            return true;
        }
        return false;
    }

    //Saving current game as binary file
    void save_binary(String address) {
        ObjectOutputStream binaryWriter = null;

        try{
            binaryWriter = new ObjectOutputStream(new FileOutputStream(address));

            //Saving red and black player
            binaryWriter.writeObject(red);
            binaryWriter.writeObject(black);

            //Saving current items
            binaryWriter.writeObject(board.items);
            binaryWriter.writeObject(redItems);
            binaryWriter.writeObject(blackItems);

            //Saving current turn
            binaryWriter.writeUTF(turn);

            //Saving repetitive check variables
            binaryWriter.writeObject(repetitiveCoords);
            binaryWriter.writeInt(count);
            binaryWriter.writeUTF(threat);
            binaryWriter.writeUTF(cannotMove);
            binaryWriter.writeBoolean(firstMove);


            binaryWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Saving current game as text file
    void save_text(String address) {
        PrintWriter textWriter = null;

        try{
            textWriter = new PrintWriter(new FileOutputStream(address));

            //Saving player red's variables
            textWriter.println(red.name);
            textWriter.println(red.puan);

            //Saving player black's variables
            textWriter.println(black.name);
            textWriter.println(black.puan);

            //Saving current items (moving across arrays)
            for(int i =0;i<board.items.length;i++){
                textWriter.println(board.items[i].getPosition());
            }

            for(int i =0;i<redItems.length;i++){
                textWriter.println(redItems[i].getPosition());
            }

            for(int i =0;i<blackItems.length;i++){
                textWriter.println(blackItems[i].getPosition());
            }

            //Saving current turn
            textWriter.println(turn);


            //Saving repetitive variables

            textWriter.println(repetitiveCoords.size());

            for(int i =0;i<repetitiveCoords.size();i++){
                textWriter.println(repetitiveCoords.get(i));
            }
            textWriter.println(count);
            textWriter.println(threat);
            textWriter.println(cannotMove);
            textWriter.println(firstMove);

            textWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Loading a game from text file
    void load_text(String address) {
        Scanner textLoader = null;

        try{
            textLoader = new Scanner(new FileInputStream(address));

            //Loading player red's variables
            red.name = textLoader.nextLine();
            red.puan = Float.parseFloat(textLoader.nextLine());

            //Loading player black's variables
            black.name = textLoader.nextLine();
            black.puan = Float.parseFloat(textLoader.nextLine());

            //Loading items (moving across arrays)
            for(int i =0;i<board.items.length;i++){
                board.items[i].setPosition(textLoader.nextLine());
            }

            for(int i =0;i<redItems.length;i++){
                redItems[i].setPosition(textLoader.nextLine());
            }

            for(int i =0;i<blackItems.length;i++){
                blackItems[i].setPosition(textLoader.nextLine());
            }

            //Loading turn
            turn = textLoader.nextLine();

            //Loading repetitive variables

            int repetitiveCoordsSize = Integer.parseInt(textLoader.nextLine());

            for(int i =0;i<repetitiveCoordsSize;i++){
                repetitiveCoords.add(i,textLoader.nextLine());
            }
            count=Integer.parseInt(textLoader.nextLine());
            threat = textLoader.nextLine();
            cannotMove = textLoader.nextLine();
            firstMove = Boolean.parseBoolean(textLoader.nextLine());

            textLoader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //Loading a game from text file
    void load_binary(String address) {
        ObjectInputStream binaryReader = null;

        try{
            binaryReader = new ObjectInputStream(new FileInputStream(address));

            //Loading player red and black
            red= (Player) binaryReader.readObject();
            black= (Player) binaryReader.readObject();

            //Loading items
            board.items = (Item[]) binaryReader.readObject();
            redItems = (Item[]) binaryReader.readObject();
            blackItems= (Item[]) binaryReader.readObject();

            //Loading turn
            turn= binaryReader.readUTF();

            //Loading repetitive check variables
            repetitiveCoords= (ArrayList<String>) binaryReader.readObject();
            count=binaryReader.readInt();
            threat = binaryReader.readUTF();
            cannotMove = binaryReader.readUTF();
            firstMove = binaryReader.readBoolean();

            binaryReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}