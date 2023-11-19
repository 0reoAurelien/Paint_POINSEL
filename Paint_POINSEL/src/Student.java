public class Student {
    private final String firstName;
    private final String lastName;
    static private int totalNumberOfStudents;

    public Student(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        totalNumberOfStudents++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static int getTotalNumberOfStudents() {
        return totalNumberOfStudents;
    }

    @Override
    public String toString(){
        return "The student is "+ this.getFirstName() +" "+ this.getLastName();
    }


    public static void main(String[] args){
        Student bidule = new Student("Bidule", "Truc");
        System.out.println("The student " + getTotalNumberOfStudents() + " is " + bidule);
        Student machin = new Student("Machin", "Truc");
        System.out.println("The student " + getTotalNumberOfStudents() + " is " + machin);
    }


    /*
    @Override
    protected void finalize(){
        totalNumberOfStudents--;
    }*/


}
