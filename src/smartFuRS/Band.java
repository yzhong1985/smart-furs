/**
 * 
 */
package smartFuRS;

import java.util.ArrayList;

/**
 * @author Yang Zhong
 *
 */
public class Band {

	private int id;
	private ArrayList<Camper> bandCampers;
	private String bandName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void AddCamper(Camper camp)
	{
		bandCampers.add(camp);
	}
	
	public Boolean RemoveCamper(Camper camp)
	{
		return bandCampers.remove(camp);
	}
	
	public ArrayList<Camper> GetDormCampers()
	{
		return bandCampers;
	}

	public String getDormName() {
		return bandName;
	}

	public void setDormName(String bandName) {
		this.bandName = bandName;
	}
}
