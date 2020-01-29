public class Person {
    private String firstName;
    private String lastName;
    private Person index;

    //Create a person
    Person(String first, String last) {
        this.firstName = first;
        this.lastName = last;
      //  System.out.println("Creating contact: " + first + " " + last);

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
    public void updateFirst(String update){
        String temp = this.firstName;
        this.firstName = update;
        System.out.println("Updated First Name from " + temp + " to " + this.firstName);

    }
    public void updateLast(String update){
        String temp = this.lastName;
        this.lastName = update;
        System.out.println("Updated Last Name from " + temp + " to " + this.lastName);
    }
}