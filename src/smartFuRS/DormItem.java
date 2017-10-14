package smartFuRS;

public class DormItem {
	private int id;
	private String fname;
    private String lname;
    private String gender;
    private int age;

    public DormItem(String fname, String lname, String gender, int age, int id) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.age = age;
        this.id = id;
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
    
    public int getAge() {
        return age;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return String.format(fname + " " + lname);
    }
}
