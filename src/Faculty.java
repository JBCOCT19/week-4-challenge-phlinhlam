public class Faculty extends User {

    public Faculty() {
    }


    public Faculty(String id, String name, String email, String password) {
        super(id, name, email, password);
    }
    @Override
    public String toString() {
        return "-------------------------"+"\n"+
                "All Faculties" + "\n"+
                "Faculty ID: " + getId() + "\n"+
                "Name: " + getName() +"\n";
    }


}
