import java.util.ArrayList;

public class StudentPromotion {

    //name

    ArrayList<StudentGroup> GroupList = new ArrayList<StudentGroup>();

    void addGroup(StudentGroup G){ this.GroupList.add(G); }
    StudentGroup findGroup(String name){
        for (StudentGroup e : this.GroupList){
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    Student findStudent(StudentGroup G, String first, String last){
/*
        if (this.GroupList == null){
            return null;
        }
*/
        for (Student e : G.studentList){
            if ((e.getFirstName().equals(first))&&(e.getLastName().equals(last))){
                return e;
            }
        }
        return null;
    }
}
