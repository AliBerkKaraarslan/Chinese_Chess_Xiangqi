//******************************************************************************
// AbstractGame.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
// Contains:"Initializing all the items of game" operation
//
//******************************************************************************
import java.io.Serializable;

public abstract class AbstractGame implements Serializable {

	//Initializing all the elements of the game
	Board board;
	Player red;
	Player black;

	Soldier redSoldier1,redSoldier2,redSoldier3,redSoldier4,redSoldier5,blackSoldier1,blackSoldier2,blackSoldier3,blackSoldier4,blackSoldier5;
	Chariot redChariot1,redChariot2,blackChariot1,blackChariot2;
	Elephant redElephant1,redElephant2,blackElephant1,blackElephant2;
	Advisor redAdvisor1,redAdvisor2,blackAdvisor1,blackAdvisor2;
	General redGeneral,blackGeneral;
	Horse redHorse1,redHorse2,blackHorse1,blackHorse2;
	Cannon redCannon1,redCannon2,blackCannon1,blackCannon2;

	/*
	 * from pozisyonundaki taşı to pozisyonuna taşır.
	 * Eğer hareket kural dışı ise, ekrana "hatali hareket" mesajı ekrana yazılır ve oyuncunun tekrar oynaması için sırayı değiştirmez.
	 * Eğer hareket sonucu biri oyunu kazandı ise, "ŞAH MAT! X oyunu kazandı. X'in puanı: A, Y'nin puanı: B" yazar. X ve Y oyuncuların ismidir. A ve B aldıkları puanlardır.
	 * Eğer hareket sonucu pat oldu ise (şahın hiç bir yere hareket edememesi ve başka yapacak hareketinin olmaması durumu), "PAT" mesajı ekrana yazılır ve oyun sonlanır. 
	 * */
	abstract void play(String from, String to);  
	
	/*
	 * Oyunun o anki hali belirtilen dosyaya binary olarak kaydedilir.
	 * */
	abstract void save_binary(String address);  
	
	/*
	 * Oyunun o anki hali belirtilen dosyaya metin dosyası olarak kaydedilir.
	 * */
	abstract void save_text(String address);  
	
	/*
	 * Belirtilen adreste kaydedilen metin dosyasına göre oyunu yükler ve oyun kaldığı yerden devam eder. 
	 * Dosyanın doğru dosya olduğunu varsayabilirsiniz.
	 * */
	abstract void load_text(String address);  
	
	
	/*
	 * Belirtilen adreste kaydedilen binary dosyaya göre oyunu yükler ve oyun kaldığı yerden devam eder.
	 * Dosyanın doğru dosya olduğunu varsayabilirsiniz.
	 * 
	 * */
	abstract void load_binary(String address);  
	
	

}
