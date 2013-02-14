import java.util.*;

import processing.core.*;

public class PersonM implements Comparable<PersonM>{
	
	// I have lots of methods here which might later be deleted after we know the specifics of how the Kinect will be feeding coordinates
	// I just tried to think of all the methods we might need
	
	private int iD; // stores iD value
	private TreeMap<Integer, MapCoor> kMap = new TreeMap<Integer, MapCoor>(); // TreeMap stores time against its Map Coordinates
	
	public PersonM(int iDi){ // constructor takes iD
		iD = iDi;
	}

	public void addCoor(MapCoor mc){ // used to add a set of coordinates taking a Map Coordinate
		kMap.put(mc.getT(), mc);
	}
	
	public void addCoor(int xi, int yi, int ti){ // if Map Coordinates are readily accessible this will add them to our map
		MapCoor mapc = new MapCoor(xi, yi, ti);
		kMap.put(ti, mapc);
	}
	
	public void addKCoor(int xi, int yi, int di, int ti){ // adds coordinates to our TreeMap taking the coordinates directly from the Kinect
		KCoor kc = new KCoor(xi, yi, di, ti);
		MapCoor mapc = kc.toMapCoor();
		kMap.put(ti, mapc);
	}
	
	// get methods
	
	public int getID(){
		return iD;
	}
	
	public MapCoor getCoor(int ti){ // returns coordinates for a given time
		return kMap.get(ti);
	}
	
	public int getXCoor(int ti){ // returns x coordinate for a given time
		return kMap.get(ti).getX();
	}
	
	public int getYCoor(int ti){ // returns y coordinate for a given time
		return kMap.get(ti).getY();
	}
	
	public TreeMap<Integer, MapCoor> getCoor(){ // returns the Map
		return kMap;
	}
	
	// toString Method
	
	public String toString(){
		String rtn = null;
		rtn = "Person: ( iD: " + iD + "," + kMap.toString() + ")" + "\n";
		return rtn;
	}
	
	@Override
	
	// compares by Id because stored in order of iD in TreeMap of the Map class
	public int compareTo(PersonM p1) {
		if(iD == p1.getID()){
			return 0;
		}
		if(iD < p1.getID()){
			return -1;
		}
		else {
			return 1;
		}
	}
}
