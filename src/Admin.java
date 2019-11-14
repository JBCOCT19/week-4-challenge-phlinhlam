public class Admin extends User {
    public Admin() {
    }

    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void showOptions()
    {
        System.out.println("Options: ");
        System.out.println("1. Add student");
        System.out.println("2. Add faculty");
        System.out.println("3. Edit student");
        System.out.println("4. Edit faculty");
        System.out.println("5. Add class");
        System.out.println("6. Edit class");
        System.out.println("7. Enroll student in a class");
        System.out.println("8. Assign faculty to a class");
        System.out.println("9. View all information");
        System.out.println("10. to quit");
    }
}
