import java.util.*;

// Address book object. Maintains linked list of Person objects
//
public class Book {
    private LinkedList<Person> list;

    //Create a person
    Book() {
        this.list = new LinkedList<Person>();
    }
    public void addPerson(Person person){
        this.list.add(person);
        System.out.println("Book - Added " + person.toString() + " to List");
    }
    public void printList(){
       int size = this.list.size();
       if(size == 0){
           System.out.println("Error: List is Empty");
       }
       else{
            // iterator of linked list contents
           ListIterator<Person> itr = this.list.listIterator();
         // Person head = list.getFirst();
         // Person curr = head;  
          // loop through all items in list
            while(itr.hasNext()){
                // print each as string
                Person person = itr.next();
                System.out.println(person);
            }
       }

    }
}