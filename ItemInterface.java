//*****************************************************************************
// ItemInterface.java         Author:Ali Berk Karaarslan     Date:06.03.2023
//
// One of the classes of Xiangqi Project.
//
//*****************************************************************************

import java.io.Serializable;

public interface ItemInterface extends Serializable {
	
	void move(String destination); // Taşı belirtilen konuma götürür (eğer kural dışı bir durum yoksa)

}
