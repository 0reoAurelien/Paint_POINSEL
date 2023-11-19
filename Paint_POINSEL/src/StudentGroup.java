import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class StudentGroup {
    private final String name;
    protected ArrayList<Student> studentList = new ArrayList<Student>();
    private static int totalNumberOfGroups;

    public static int getTotalNumberOfGroups() {
        return totalNumberOfGroups;
    }


    public StudentGroup(String name) throws IllegalArgumentException{
        this.name = name;
        //this.studentList =(ArrayList<Student>) [];
        if (!Pattern.matches("[1-2]G[1-3]TD[1-3]TP[1-6]", name)) {
            throw new IllegalArgumentException(name + " is not a real ENSEA name...");
        }
        totalNumberOfGroups++;
    }

    @Override
    public String toString(){
        return "The group " + this.name + " has " + this.studentList.size() + " students.";
    }

    public void addStudent(Student s){
        this.studentList.add(s);
    }

    public void displayPresenceList(){
        int tot = this.studentList.size();
        if (tot == 0) {
            System.out.println("Le groupe " + this.name + " est vide.");
        }
        else {
            System.out.println("Le groupe " + this.name + " est constitué de " + this.studentList.size() + " étudiants :");
            for (Student e : this.studentList) {
                System.out.println(e.getFirstName() + " " + e.getLastName());
            }
        }
    }

    public String getName() {return this.name;}

    public static void main(String[] args){

        StudentGroup a = null, b = null, c = null, d = null;
        try {

            a = new StudentGroup("1G2TD2TP3");
            System.out.println(a);
            b = new StudentGroup("2G1TD1TP2");
            System.out.println(b);
            c = new StudentGroup("4G2TD2TP3");
            System.out.println(c);
            d = new StudentGroup("5G1TD15TP27");
            System.out.println(d);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Il y a finalement " + getTotalNumberOfGroups() + " groupe(s)");

        Student Oreo = new Student("Aurélien", "Poinsel");
        System.out.println("The student " + Student.getTotalNumberOfStudents() + " is " + Oreo.getFirstName());
        Student bidule = new Student("Bidule", "Truc");
        System.out.println("The student " + Student.getTotalNumberOfStudents() + " is " + bidule.getFirstName());
        Student machin = new Student("Machin", "Truc");
        System.out.println("The student " + Student.getTotalNumberOfStudents() + " is " + machin.getFirstName());
        a.addStudent(Oreo);
        a.addStudent(machin);
        a.addStudent(bidule);
        a.displayPresenceList();

        b.displayPresenceList();

        /*
        catch (Exception e){
            System.out.println("Il y a un truc qui coince...");
        }
        */
    }
}

// Il faut placer les déclarations de groupes "StudentGroup a = null, b = null, c = null;"
// pour que ces derniers soient bien initialisés (pour une éventuelle suite du code).
// En effet, le parcours du bloc catch s'interromp lors de la rencontre d'une exception.
