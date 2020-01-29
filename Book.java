import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

// Address book object. Maintains linked list of Person objects
//
public class Book {
    private LinkedList<Person> list;

    // Create a person
    Book() {
        this.list = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        this.list.add(person);
        System.out.println("Book - Added " + person.toString() + " to List");
    }

    public void loadFile() {
        // creating File instance to reference text file
        File text = new File("addressBook.txt");
        
        try {
            Scanner scnr = new Scanner(text);
            while (scnr.hasNextLine()) {
                String first = scnr.nextLine();
                String last = scnr.nextLine();
                Person person = new Person(first, last);
                addPerson(person);
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    // gets person from given index
    public Person getPerson(int index){
        Person person = this.list.get(index);
        return person;
    }
    // removes person at given index
    public void removePerson(int index){
        Person person = list.remove(index);
        System.out.println(person + " has been deleted!");
    }
    // displays list of contacts for user to view
    public void printList() {
        int size = this.list.size();
        if (size == 0) {
            System.out.println("No contacts found.");
        } else {
            // iterator of linked list contents
            ListIterator<Person> itr = this.list.listIterator();
            // loop through all items in list
            while (itr.hasNext()) {
                // print each as string
                Person person = itr.next();
                System.out.println(person);
            }
        }
    }
    // displays numbered list of contacts
    public void printNumberedList() {
        int size = this.list.size();
        int index = 1; // index counter
        if (size == 0) {
            System.out.println("No contacts found.");
        } else {
            // iterator of linked list contents
            ListIterator<Person> itr = this.list.listIterator();
            // loop through all items in list
            while (itr.hasNext()) {
                // print each as string
                Person person = itr.next();
                System.out.print(index + ") ");
                System.out.println(person);
                index++;
            }
        }
    }
    // saves list of contacts to output file
    //
    public void printListToFile(FileWriter fileWriter) {
        int size = this.list.size();
        if (size == 0) {
            System.out.println("Error: No contacts to save");
        } else {
            // iterator of linked list contents
            ListIterator<Person> itr = this.list.listIterator();
            // loop through all items in list
            while (itr.hasNext()) {
                // print each as string
                Person person = itr.next();
                try {
                    fileWriter.write(person.outputStringFormat());
                    fileWriter.write("\n");
                } catch (Exception IOException) {
                    System.out.println("I/O Exception");
                }

            }
        }

    }
}