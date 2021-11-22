import java.util.ArrayList;
import java.util.Scanner;
public class addressBook {
	private int id;
	private ArrayList<Contact> addressBook=new ArrayList<>();
	private static int registered;
	/*
	 ARRAYLIST
	 - nn vengono usate su tipi primitivi
	 - nomearraylist.add(Object) x istanziare
	 - nomearraylist.add(Index,Object) x istanziare all'indice Index
	 - nomearraylist.get(Index) x ottenere un oggetto all'indice Index
	 - nomearraylist.set(Index,Object) x settare l'ogetto all'indice Index
	 - nomearraylist.remove(Index) x rimuovere l'ogetto all'indice Index
	 - nomearraylist.size() x ottenere lunghezza arraylist
	 */
	//constructors
	public addressBook() {
		id=++registered;
	}
	//methods
	public String getContact(int i) {
		return addressBook.get(i).toString();
	}
	public void newContact(String name,String surname,String phoneNumber) {
		if(addressBook.size()>0)
			addressBook.add(binarySearch(name,surname),new Contact(name,surname,phoneNumber));
		else {
			addressBook.add(new Contact(name,surname,phoneNumber));
		}
			
	}
	public int binarySearch(String name,String surname) {
		int min=0,max=addressBook.size()-1,mid;
		while(min<=max) {
			mid=(min+max)/2;
			if(mid==0) {
				if(surname.compareTo(addressBook.get(mid).getSurname())<0||(surname.compareTo(addressBook.get(mid).getSurname())==0&&name.compareTo(addressBook.get(mid).getName())<0))
					return mid;
			}
			else if(mid==addressBook.size()-1) {
				if(surname.compareTo(addressBook.get(mid).getSurname())>0||(surname.compareTo(addressBook.get(mid).getSurname())==0&&name.compareTo(addressBook.get(mid).getName())>0))
					return mid+1;
			}
			else {
				if((surname.compareTo(addressBook.get(mid).getSurname())<0&&surname.compareTo(addressBook.get(mid-1).getSurname())>0)||(surname.compareTo(addressBook.get(mid).getSurname())==0&&name.compareTo(addressBook.get(mid).getName())<0))
					return mid;
			}
			if(surname.compareTo(addressBook.get(mid).getSurname())>0)
				min=mid+1;
			else
				max=mid-1;
		}
		return -1;
	}
	
	public void removeContact(String phoneNumber) {
		for(int i=0;i<addressBook.size();i++) {
			if(addressBook.get(i).getPhoneNumber().equals(phoneNumber))
				addressBook.remove(i);
		}
	}
	public void blackList(String phoneNumber) {
		for(int i=0;i<addressBook.size();i++) {
			if(addressBook.get(i).getPhoneNumber().equals(phoneNumber))
				addressBook.get(i).setBlackList(true);
		}
	}
	public void showAddressBook() {
		//sort();
		for(int i=0;i<addressBook.size();i++) {
			if(!addressBook.get(i).getBlackListed())
				System.out.println(getContact(i));
		}
	}
	public void sort() {
		Contact tmp;
		for(int i=0;i<addressBook.size();i++) {
			for(int j=0;j<(addressBook.size()-1);j++) {
				if((addressBook.get(j).getSurname().compareTo(addressBook.get(j+1).getSurname()))>0) {
					tmp=addressBook.get(j);
					addressBook.set(j,addressBook.get(j+1));
					addressBook.set(j+1,tmp);
				}
				if(addressBook.get(j).getSurname().compareTo(addressBook.get(j+1).getSurname())==0) {
					if(addressBook.get(j).getName().compareTo(addressBook.get(j+1).getName())>0) {
						tmp=new Contact(addressBook.get(j));
						addressBook.set(j,addressBook.get(j+1));
						addressBook.set(j+1,tmp);
					}
				}
			}
		}
	}
}
