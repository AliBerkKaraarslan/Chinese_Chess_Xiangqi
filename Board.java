//*************************************************************************
// Board.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"General methods of game. Printing the board" operations
//
//*************************************************************************

public class Board extends AbstractBoard{

	//Printing the whole board
	public void print() {
		System.out.println("j\t"+ printItem("j1")+ "--" +printItem("j2")+ "--" +printItem("j3")+ "--" +printItem("j4")+ "--" +printItem("j5")+ "--" +printItem("j6")+ "--" +printItem("j7")+ "--" +printItem("j8")+ "--" +printItem("j9"));
		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
		System.out.println("i\t"+ printItem("i1")+ "--" +printItem("i2")+ "--" +printItem("i3")+ "--" +printItem("i4")+ "--" +printItem("i5")+ "--" +printItem("i6")+ "--" +printItem("i7")+ "--" +printItem("i8")+ "--" +printItem("i9"));
		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
		System.out.println("h\t"+ printItem("h1")+ "--" +printItem("h2")+ "--" +printItem("h3")+ "--" +printItem("h4")+ "--" +printItem("h5")+ "--" +printItem("h6")+ "--" +printItem("h7")+ "--" +printItem("h8")+ "--" +printItem("h9"));
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.println("g\t"+ printItem("g1")+ "--" +printItem("g2")+ "--" +printItem("g3")+ "--" +printItem("g4")+ "--" +printItem("g5")+ "--" +printItem("g6")+ "--" +printItem("g7")+ "--" +printItem("g8")+ "--" +printItem("g9"));
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.println("f\t"+ printItem("f1")+ "--" +printItem("f2")+ "--" +printItem("f3")+ "--" +printItem("f4")+ "--" +printItem("f5")+ "--" +printItem("f6")+ "--" +printItem("f7")+ "--" +printItem("f8")+ "--" +printItem("f9"));
		System.out.println(" \t|                       |");
		System.out.println("e\t"+ printItem("e1")+ "--" +printItem("e2")+ "--" +printItem("e3")+ "--" +printItem("e4")+ "--" +printItem("e5")+ "--" +printItem("e6")+ "--" +printItem("e7")+ "--" +printItem("e8")+ "--" +printItem("e9"));
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.println("d\t"+ printItem("d1")+ "--" +printItem("d2")+ "--" +printItem("d3")+ "--" +printItem("d4")+ "--" +printItem("d5")+ "--" +printItem("d6")+ "--" +printItem("d7")+ "--" +printItem("d8")+ "--" +printItem("d9"));
		System.out.println(" \t|  |  |  |  |  |  |  |  |");
		System.out.println("c\t"+ printItem("c1")+ "--" +printItem("c2")+ "--" +printItem("c3")+ "--" +printItem("c4")+ "--" +printItem("c5")+ "--" +printItem("c6")+ "--" +printItem("c7")+ "--" +printItem("c8")+ "--" +printItem("c9"));
		System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
		System.out.println("b\t"+ printItem("b1")+ "--" +printItem("b2")+ "--" +printItem("b3")+ "--" +printItem("b4")+ "--" +printItem("b5")+ "--" +printItem("b6")+ "--" +printItem("b7")+ "--" +printItem("b8")+ "--" +printItem("b9"));
		System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
		System.out.println("a\t"+ printItem("a1")+ "--" +printItem("a2")+ "--" +printItem("a3")+ "--" +printItem("a4")+ "--" +printItem("a5")+ "--" +printItem("a6")+ "--" +printItem("a7")+ "--" +printItem("a8")+ "--" +printItem("a9"));
		System.out.println();
		System.out.println(" \t1--2--3--4--5--6--7--8--9");

	}

	//Returns the Item's toString method by given coordinates.( If place is empty then returns "-" )
	public String printItem(String coordinates){

		for (Item item : items) {
			if (item != null) {

				if (item.getPosition().equals(coordinates)) {
					return item.toString();
				}

			} else {
				return "-";
			}
		}
		return "-";
	}

	//Returns the Item by given coordinates.
	public Item getItem(String coordinates){

		//Gets the array Indexes and parses them Into two numbers
		if(!coordinates.equals("xx")) {
			for (Item item : items) {
				if (item != null) {
					if (item.getPosition().equals(coordinates)) {
						return item;
					}

				} else {
					return null;
				}
			}
		}
		return null;
	}

	//Returns the array Indexes of coordinates. For example "e1" -> "50"
	public String coordsToArray(String coordinates){

		char firstDigit = coordinates.charAt(0);
		int secondDigit = Integer.parseInt(coordinates.substring(1));

		// 'a' unicode/ASCII number is 97, j->106
		return ( ""+ Math.abs(firstDigit-106 ) + (secondDigit-1));
	}

	//Returns the coordinates of arrayIndexes. For example "50" -> "e1"
	public String arrayToCoords(int firstDigit,int secondDigit){

		// 'a' unicode/ASCII number is 97, j->106
		return (""+(char)(106-firstDigit)+(secondDigit+1));
	}

	//Checks if given coordinates is valid (Do they exist)
	public boolean isValid(String coordinates){

		char firstDigit = coordinates.charAt(0);
		int secondDigit=-1;

		if(coordinates.charAt(1)<='9' && coordinates.charAt(1)>='0') {
			secondDigit = Integer.parseInt(coordinates.substring(1));
		}

		if (firstDigit<='j' && firstDigit>= 'a'){
			if(secondDigit <=9 && secondDigit >=1){
				return true;
			}
		}
		return false;
	}
}
