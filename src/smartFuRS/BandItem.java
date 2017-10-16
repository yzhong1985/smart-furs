package smartFuRS;

public class BandItem {
	private int id;
	private String fname;
    private String lname;
    private String gender;
    private int talentLevel;
    private String cat;

    public BandItem(String fname, String lname, String gender, int id, String category, int talent) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.id = id;
        this.cat = category;
        this.talentLevel = talent;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getGender() {
        return gender;
    }
    
    
    public int getId() {
        return id;
    }
    
    public int getTalentLevel() {
    	return talentLevel;
    }
    
    public String getCategory() {
    	//Shortern the category
    	String catoutput = "Unkn";
    	switch (cat) {
        case "Singer":catoutput = "Singer";  
                break;
        case "Drummer":catoutput = "Drummr";    
                break;
        case "Bassist":catoutput = "Basst";    
        		break;
        case "Guitarist":catoutput = "Guitar";    
        		break;
        case "Instrumentalist":catoutput = "Instrm";    
        		break;
        case "Keyboardist":catoutput = "Keybrd";    
        		break;   
    	}
    	
    	return catoutput;
    } 
    
    @Override
    public String toString() {
        return String.format(fname + " " + lname + " " + gender + " " + cat + " " + talentLevel);
    }
}

