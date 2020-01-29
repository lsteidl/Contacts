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
    // print in format of: "firstname lastname"
    public String toString(){
        String print = this.firstName + " " + this.lastName;
        return print;
    }
    // used for saving contacts to text file
    public String outputStringFormat(){
        String print = this.firstName + "\n" + this.lastName;
        return print;
    }
}