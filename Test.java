//**********************************************************************
// Test.java         Author:Ali Berk Karaarslan     Date:09.03.2023
//
// One of the classes of Xiangqi Project.
//
//**********************************************************************

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game("P1","P2");
        game.board.print();

        //To play game interactive
        while(true){
            System.out.println("Turn: "+game.turn);
            System.out.println("Red's Point: "+game.red.puan);
            System.out.println("Black's Point: "+game.black.puan);
            System.out.println();
            System.out.println("Enter coordinates:");
            String coordinates = scan.nextLine();
            game.play(coordinates.substring(0,2),coordinates.substring(3));
            game.board.print();
        }

        /* nice game(mate with flying general mate)
        game.play("c8","j8");
        game.play("h2","a2");
        game.play("a1","a2");
        game.play("j1","h1");
        game.play("j8","j6");
        game.play("j9","i9");
        game.play("j6","j4");
        game.play("j5","j4");
        game.play("a8","c7");
        game.play("h1","h4");
        game.play("c7","b5");
        game.play("h4","a4");
         */

        /*
        game.play("h2","h5");
        game.play("j5","j6");
        game.play("h5","h6");
        game.play("j6","j5");
        game.play("h6","h5");
        game.play("j5","j6");
        game.play("h5","h6");
        System.out.println("Turn: "+game.turn);
        System.out.println("Red's Point: "+game.red.puan);
        System.out.println("Black's Point: "+game.black.puan);
        System.out.println(game.repetitiveCoords);
        System.out.println("threat: " +game.threat);
        System.out.println("count: "+game.count);
        System.out.println("cannotMove: "+game.cannotMove);
        System.out.println("firstMove: "+game.firstMove);
        game.getBoard().print();
        System.out.println("saving: ");
        //game.save_binary("saveAsBinary.txt");
        game.save_text("saveText.txt");

        Game game2 = new Game("xdd","omegalul");
        System.out.println("Turn: "+game2.turn);
        System.out.println("Red's Point: "+game2.red.puan);
        System.out.println("Black's Point: "+game2.black.puan);
        System.out.println(game2.repetitiveCoords);
        System.out.println("threat: " +game2.threat);
        System.out.println("count: "+game2.count);
        System.out.println("cannotMove: "+game2.cannotMove);
        System.out.println("firstMove: "+game2.firstMove);
        game2.getBoard().print();
        System.out.println("save geri getiriliyor");
        //game2.load_binary("saveAsBinary.txt");
        game2.load_text("saveText.txt");
        System.out.println("Turn: "+game2.turn);
        System.out.println("Red's Point: "+game2.red.puan);
        System.out.println("Black's Point: "+game2.black.puan);
        System.out.println(game2.repetitiveCoords);
        System.out.println("threat: " +game2.threat);
        System.out.println("count: "+game2.count);
        System.out.println("cannotMove: "+game2.cannotMove);
        System.out.println("firstMove: "+game2.firstMove);
        game2.getBoard().print();*/

        /*
        game.play("d3","e3");
        game.play("h2","h3");
        game.play("c2","c3");
        game.play("j2","h1");
        game.play("c3","g3");
        game.play("h1","h3");
        game.play("h1","g3");
        game.play("a1","c1");
        game.play("j1","j2");
        game.play("a2","c3");
        game.play("j8","h7");
        game.play("c8","g8");
        game.play("g3","f1");
        game.play("g8","g5");
        game.play("f1","d2");
        game.play("c1","c2");
        game.play("d2","c4");
        game.play("a7","c9");
        game.play("a5","b5");
        game.play("c4","d6");
        game.play("b5","a5");
        game.play("d6","b7");
        game.play("a5","b5");
        game.getBoard().print();
        game.play("h8","b8");
        game.getBoard().print();*/

        /*
        //To play game manually (coding)
        game.board.print();
        game.play("a1","b1");
        game.play("h2","h4");
        game.play("a5","b5");
        game.play("g9","f9");
        System.out.println("this board will be saved: ");
        game.board.print();
        //game.save_text("saveText.txt");
        game.save_binary("saveAsBinary.txt");
        game.play("d7","e7");
        game.play("j4","i5");
        System.out.println("this board should be gone: ");
        game.board.print();

        System.out.println("new game");
        Game game2 = new Game("o1","o2");
        game2.play("d1","e1");
        game2.play("j8","h9");
        game2.play("a7","c9");
        game2.board.print();
        System.out.println("eski save getiriliyor");

        //game2.load_text("saveText.txt");
        game2.load_binary("saveAsBinary.txt");
        game2.board.print();
        System.out.println(game2.turn);
        System.out.println(game2.red.name);
        System.out.println(game2.black.name);

        game2.play("d3","e3");
        game2.board.print();
*/

        /*System.out.println(game.red.name);
        game.play("d1","d2");
        game.play("d1","e1");
        game.play("g1","g2");
        game.play("g1","g10");
        game.play("g1","11");
        game.play("g1","f1");
        game.play("e1","f1");
        game.play("h2","h9");
        game.getBoard().print();
        game.save_binary("saveBinary");
        game.play("h2","h1");
        game.play("a1","e1");
        game.play("h1","e1");
        game.play("f1","e1");
        game.play("f1","f3");
        game.play("f1","f2");
        game.play("e1","e5");
        game.play("c2","d2");
        game.play("c2","c5");
        game.play("j4","i5");
        game.play("c5","e5");
        game.save_text("savetext");
        game.getBoard().print();
        System.out.println(game.getBoard().items[0].getPosition());

        Game game2 = new Game("oyuncu1","oyuncu2");
        System.out.println(game2.black.name);
        System.out.println("----------------------------loading binary----------");
        game2.load_binary("saveBinary");
        System.out.println(game2.black.name);
        game2.getBoard().print();
        System.out.println(game2.getBoard().items[0].getPosition());
        System.out.println("----------------------------loading text----------");
        game2.load_text("savetext");
        game2.getBoard().print();
        System.out.println(game2.getBoard().items[0].getPosition());*/
    }

    public static void printPositions(Game game){

        for(int i=0;i<game.getBoard().items.length;i++){
            System.out.println(game.getBoard().items[i]+ " and " + game.getBoard().items[i].getPossibleMoves());
        }
    }

    public static void printRepetitiveStats(Game game){

        System.out.println(game.repetitiveCoords);
        System.out.println("threat: " +game.threat);
        System.out.println("count: "+game.count);
        System.out.println("cannotMove: "+game.cannotMove);
        System.out.println("firstMove: "+game.firstMove);
    }
}
