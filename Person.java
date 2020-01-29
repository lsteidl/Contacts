public class Person {
    private String firstName;
    private String lastName;
    private Person next;

    //Create a person
    Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        System.out.println("Creating contact: " + first + " " + last);
    }
    // overriding default toString method
    // print in format of: "lastname, firstname"
    public String toString(){
        String print = this.lastName + ", " + this.firstName;
        return print;
    }
}