
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		addressBook a1=new addressBook();
		String choice,name,surname,phoneNumber;
		System.out.println("CHOICE OPTIONS EXPLANATION:");
		System.out.println("- Type NEW CONTACT to create a new contact in the address book");
		System.out.println("- Type REMOVE CONTACT to delete a contact of the address book");
		System.out.println("- Type BLACK LIST to add a contact to the black list");
		System.out.println("- Type SHOW ADDRESS BOOK to show all the contactin the chosen addres book");
		System.out.println("- Type EXIT to exit");
		System.out.print("\nTYPE YOUR CHOICE: ");
		choice=scan.nextLine();
		while(!choice.equals("EXIT")) {
			switch(choice) {
			case "NEW CONTACT":
				System.out.print("\tType the name of the person: ");
				name=scan.nextLine();
				System.out.print("\tType the surnname of the person: ");
				surname=scan.nextLine();
				System.out.print("\tType the phone  of the person: ");
				phoneNumber=scan.nextLine();
				a1.newContact(name,surname,phoneNumber);break;
			case "REMOVE CONTACT":
				System.out.print("\tType the phone  of the person: ");
				phoneNumber=scan.nextLine();
				a1.removeContact(phoneNumber);break;
			case "BLACK LIST":
				System.out.print("\tType the phone  of the person: ");
				phoneNumber=scan.nextLine();
				a1.blackList(phoneNumber);break;
			case "SHOW ADDRESS BOOK":a1.showAddressBook();break;
			default:System.out.println("YOU TYPED AN INVALID CHOICE ");
			}
			System.out.print("\nTYPE YOUR CHOICE: ");
			choice=scan.nextLine();	
		}
	}

}
