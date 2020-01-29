import java.util.Scanner;

public class Contacts {
	// Runs the tests for HW3
	public static void main(final String[] args) {
        int n = 0; // user input
        final Scanner reader = new Scanner(System.in); // scanner for user input
        Book book = new Book();
        while(true){ // infinte loop with menu options
        System.out.println();
        System.out.println("1) Load Contacts");
        System.out.println("2) Print Contacts");
        System.out.println("3) New Contact");
        System.out.println();
        
        if (reader.hasNextInt()) { // error prevention
            n = reader.nextInt(); // get next integer from scanner
        }
        else{
            System.out.println("Invalid Input");
            n = -1;
        }
        // load contacts
        if(n == 1){
            load();
        }
        else if(n == 2){
            print(book);
        }
        else if(n == 3){
            newContact(book);
        }
        else if(n == 0){
            break;
        }
        reader.nextLine(); // clear extra data from bufferr
    }

          reader.close(); // close scanner
    }
    // load contacts from text file
    public static void load(){
        System.out.println("Contact loading...");

    }
    // print contact list to screen
    public static void print(Book book){
        System.out.println("Printing contacts...");
        book.printList();

    }
    // add new contact
    public static void newContact(Book book){
        System.out.println("Adding new contact...");
        Person newPerson = new Person("Apple", "Jack");
        Person newPerson2 = new Person("Dave", "Bear");
        book.addPerson(newPerson);
        book.addPerson(newPerson2);

    }
}