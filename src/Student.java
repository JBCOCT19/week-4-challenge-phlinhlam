public class Student extends User {
    public Student() {
    }

    public Student(String id, String name) {

    }

    public Student(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public String toString() {
        return
                "Student ID:     " + getId() +"\n"+
                "Student Name:   " + getName() + "\n";
    }
}
