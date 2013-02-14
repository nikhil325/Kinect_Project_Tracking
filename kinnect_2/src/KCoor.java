import java.util.*;

import processing.core.*;

public class KCoor implements Comparable<KCoor> {

	private int x; // x coordinate
	private int y; // y coordinate
	private int d; // depth coordinate
	private int t; // time coordinate
	

	// get methods
	public int getX(){
		return x;
	}
	
	public int getY(){ 
		return y;
	}
	
	public int getD(){
		return d;
	}
	
	public int getT(){
		return t;
	}
	

	// export into coordinate class usable on density map
	public MapCoor toMapCoor(){
		
		int xM = d; // algorithm for adjusting coordinates TBD
		int yM = y; // algorithm for adjusting coordinates TBD
		
		MapCoor map1 = new MapCoor(xM, yM, t);
		return map1;
	}
	
	// constructor
	public KCoor(int xi, int yi, int di, int ti){
		x = xi;
		y = yi;
		d = di;
		t = ti;
		
	}
	
	
	// toString method
	public String toString(){
		String rtn = null;
		rtn = "Kinect: ( X: " + x + ", Y: " + y + ", D: " + d + ", T: " + t + ")";
		return rtn;
	}

	@Override
	public int compareTo(KCoor k1) {
		
		// comapring by time 
			if(t == k1.getT()){
				return 0;
			}
			else if(t < k1.getT()){
				return -1;
			}
			else {
				return 1;
			}
		
	}
	

	
}
