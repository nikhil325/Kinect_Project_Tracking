
import java.util.*;

import processing.core.*;

public class Map {

	// Again, a lot of unnecessary methods. We will know which ones to delete once get the Kinect integrated
	
	private TreeMap<Integer, PersonM> aMap = new TreeMap<Integer, PersonM>(); // Map of people stored against their iD

	public Map(){ //constructor
		
	}
	
	public void addCoor(MapCoor mc, int iD){ // adds a set of coordinates of the Map coordinate class to the person with the right iD
		getPer(iD).addCoor(mc);
	}
	
	public void addCoor(int xi, int yi, int ti, int iD){ // same as above, except it takes adjusted coordinates in teh parameter
		MapCoor mapc = new MapCoor(xi, yi, ti);
		getPer(iD).addCoor(mapc);
	}
	
	public void addKCoor(int xi, int yi, int di, int ti, int iD){ // same as above but take unadjusted coordinates
		KCoor kc = new KCoor(xi, yi, di, ti);
		MapCoor mapc = kc.toMapCoor();
		getPer(iD).addCoor(mapc);
	}
	
	
	public void addPer(int iDi){
		PersonM per = new PersonM(iDi);
		aMap.put(iDi, per);
	}
	
	//get methods
	
	public PersonM getPer(int iDi){ // gets person of a given iD
		return aMap.get(iDi);
	}
	
	public TreeMap<Integer, MapCoor> getCoor(int iDi){ // returns Map of coordinates from a person of a given iD
		return aMap.get(iDi).getCoor();
	}
	
	public MapCoor getCoor(int iDi, int ti){ // returns coordinates of a person of a given iD at a given time
		return aMap.get(iDi).getCoor(ti);
	}
	
	// toString method
	
	public String toString(){
		String rtn = null;
		rtn = "Map: (" +  aMap.toString() + ")";
		return rtn;
	}
	
}
