package dbManager.models;
import java.sql.Date;

public class Partner {

	private int ID;
	private String forename;
	private String surname;
	
	public Partner(int ID, String forename, String surname)	{
		this.ID = ID;
		this.forename = forename;
		this.surname = surname;
	}
	
	public int getID()	{
		return ID;
	}
	
	public String getForename()	{
		return forename;
	}
	
	public String getSurname()	{
		return surname;
	}

}
