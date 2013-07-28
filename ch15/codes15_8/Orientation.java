package codes15_8;

import java.io.Serializable;

public enum Orientation implements Serializable{
	HORIZONTAL(1),VERTICAL(2);
	private int value;
	private Orientation(int value){
		this.value = value;
	}
}

