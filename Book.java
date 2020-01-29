import java.util.*;
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

    // displays list of contacts for user to view
    public void printList() {
        int size = this.list.size();
        if (size == 0) {
            System.out.println("Error: List is Empty");
        } else {
            // iterator of linked list contents
            ListIterator<Person> itr = this.list.listIterator();
            // Person head = list.getFirst();
            // Person curr = head;
            // loop through all items in list
            while (itr.hasNext()) {
                // print each as string
                Person person = itr.next();
                System.out.println(person);
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
                    fileWriter.write(person.toString());
                    fileWriter.write("\n");
                } catch (Exception IOException) {
                    System.out.println("I/O Exception");
                }

            }
        }

    }
}