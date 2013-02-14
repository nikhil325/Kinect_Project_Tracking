import java.util.*;

import processing.core.*;

public class MapCoor implements Comparable<MapCoor>{
	//set of coordinates that can be used on the density map

	private int x; // x coordinate
	private int y; // y coordinate
	private int t; // time coordinate
	
	// get methods
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getT(){
		return t;
	}
	
	
	// constructor
	public MapCoor(int xi, int yi, int ti){
		x = xi;
		y = yi;
		t = ti;
		
	}

	// toString Method
	public String toString(){
		String rtn = null;
		rtn = "( X: " + x + ", Y: " + y + ", T: "  + t + ")";
		return rtn;
	}
	
	@Override
	public int compareTo(MapCoor m1) {
	
		// comparing by time
		
		// no need to check anything else because these coordinates will only be compared to coordinates of the
		// same person because of the implementation of the person class
		
		if(t == m1.getT()){
			return 0;
		}
		else if(t < m1.getT()){
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
}
