
public class Contact {
	public final int id;
	private String name;
	private String surname;
	private String phoneNumber;
	private boolean blackListed;
	private static int registered;
	//constructors
	public Contact(String name, String surname, String phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		id=++registered;
	}
	public Contact(Contact c) {
		this.name = c.name;
		this.surname = c.surname;
		this.phoneNumber = c.phoneNumber;
		id=++registered;
	}
	//getters e setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBlackListed(boolean condition) {
		this.blackListed = condition;
	}
	public boolean getBlackListed() {
		return blackListed;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setBlackList(boolean b) {
		this.blackListed = b;
	}
	//methods
	public String toString() {
		return "SURNAME: "+surname+"\tNAME: "+name+"\tPHONENUMBER: "+phoneNumber;
	}
	
}
