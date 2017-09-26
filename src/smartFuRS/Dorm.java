/**
 * 
 */
package smartFuRS;

import java.util.ArrayList;

/**
 * @author Yang Zhong
 *
 */
public class Dorm {
	private int id;

	private ArrayList<Camper> dormCampers;
	private String dormName;
	
	public void AddCamper(Camper camp)
	{
		dormCampers.add(camp);
	}
	
	public Boolean RemoveCamper(Camper camp)
	{
		return dormCampers.remove(camp);
	}
	
	public ArrayList<Camper> GetDormCampers()
	{
		return dormCampers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
}
