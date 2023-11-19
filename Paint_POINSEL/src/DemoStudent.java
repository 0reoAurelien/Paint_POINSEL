
//import java.util.concurrent.TimeUnit;

public class DemoStudent {

    private final String firstName;
    private final String lastName;
    static private int totalNumberOfStudents;

    public DemoStudent(String firstName, String lastName) {
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


    public static void main (String args[]){
        DemoStudent tauvel = new DemoStudent("Antoine", "Tauvel");
        DemoStudent bares = new DemoStudent("Christophe", "Bares");
        DemoStudent argument = new DemoStudent(args[0], args[1]);

        System.out.println(tauvel);
        System.out.println(bares);
        System.out.println(argument);

        System.out.println("Total number of student "+tauvel.getTotalNumberOfStudents());

        bares = argument;

        System.gc();

        System.out.println(tauvel);
        System.out.println(bares);
        System.out.println(argument);

        System.out.println("Total number of students : " + tauvel.getTotalNumberOfStudents());
    }
}

// Les arguments 1 et 2 doivent donner le prénom et nom de l'étudiant

// Avant la ligne 45, il y a 3 références d'objet DemoStudent qui existent, et aussi 3 instances.

// Après la ligne 45, il y autant d'instances mais plus que 2 références, celle de bares étant écrasée par la référence de argument.
// Le garbage collector permet quand à lui d'éliminer l'instance qui n'est plus accessible par la référence détruite.