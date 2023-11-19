public class Launcher {

    public static void main(String[] args){
        StudentPromotion p = new StudentPromotion();
        StudentGroup a = null;
        try {
            a= new StudentGroup("1G1TD1TP1");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        p.addGroup(a);
        
    }
}
