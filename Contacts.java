import java.io.FileWriter;
import java.util.Scanner;

public class Contacts {
    // Runs the tests for HW3
    public static void main(final String[] args) {
        int n = 0; // user input
        final Scanner reader = new Scanner(System.in); // scanner for user input
        Book book = new Book();
        while (true) { // infinte loop with menu options
            System.out.println();
            System.out.println("1) Load Contacts");
            System.out.println("2) View Contacts");
            System.out.println("3) New Contact");
            System.out.println("4) Edit/Delete Contact");
            System.out.println("5) Save session");
            System.out.println("0) Exit session");
            System.out.println();

            if (reader.hasNextInt()) { // error prevention
                n = reader.nextInt(); // get next integer from scanner
            } else {
                // print error
                System.out.println("Invalid Input");
                n = -1;
            }
            
            if (n == 1) {
                // load contacts
                load(book);
            } else if (n == 2) {
                // display contacts
                print(book);
            } else if (n == 3) {
                // add new contact
                newContact(book, reader);
            } else if(n == 4){
                // edit contact
                edit(book, reader);
            }else if (n == 5) {
                // save current contacts
                save(book);
            } else if (n == 0) {
                // exit
                break;
            }

            // reader.nextLine(); // clear extra data from buffer

        }
        reader.close(); // close scanner
    }

    // load contacts from text file
    public static void load(Book book) {
        System.out.println("Contact loading...");
        // create book.isEmpty method to avoid reloading?
        book.loadFile(); // load from text file
        System.out.println("Contacts loaded...");

    }

    // save contacts to text file
    public static void save(Book book) {
        System.out.println("Saving contacts...");
        try {
            FileWriter fileWriter = new FileWriter("addressBook.txt");
            book.printListToFile(fileWriter); // print current contacts to text file
            fileWriter.close();
        } catch (Exception IOException) {
            System.out.println("I/O Exception");
        }

    }

    // print contact list to screen
    public static void print(Book book) {
        System.out.println("Printing contacts...");
        book.printList(); // display current contacts to user
    }
    // edit / delete contact
    public static void edit(Book book, Scanner reader) {
        System.out.println("Contact List...");
        book.printNumberedList(); // show contacts with indexing
        System.out.print("Enter number of contact to edit...");
        if(reader.hasNextInt()){
            int index = reader.nextInt() - 1;
            // print edit/delete options
            System.out.println();
            System.out.println("You chose: " + book.getPerson(index));
            System.out.println("0) Delete Contact");
            System.out.println("1) Edit Contact");
            if(reader.hasNextInt()){ // get valid user input
                int choice = reader.nextInt();
                if(choice == 0){ // delete contact
                    book.removePerson(index);
                }
                else if(choice == 1){ // edit contact
                    book.editPerson(index, reader);
                }
            }
        }
    }
    // add new contact
    public static void newContact(Book book, Scanner reader) {
        String firstName = "";
        String lastName = "";
        System.out.println("Adding new contact...");
       //TESTING
        // Person newPerson = new Person("Apple", "Jack");
        // Person newPerson2 = new Person("Dave", "Bear");
        // book.addPerson(newPerson);
        // book.addPerson(newPerson2);

        System.out.print("Please enter First and Last name...");
        if (reader.hasNext()) {
            firstName = reader.next(); // get user input 
        }
        if (reader.hasNext()) {
            lastName = reader.next(); // get user input
        }
        
        reader.nextLine(); // clear extra data from buffer
        Person newPerson3 = new Person(firstName, lastName); // create person
        book.addPerson(newPerson3); // add person to list

    }
}