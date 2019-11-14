import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Class> classes = new ArrayList<>();
    public static ArrayList<Faculty> faculties = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<StudentClassConnection> studentClassConnections = new ArrayList<>();
    public static ArrayList<FacultyClassConnection> facultyClassConnections = new ArrayList<>();

    public static void main(String[] args) {
        //populate Admin account
        Admin admin = new Admin();
        admin.setId("Ad-001");
        admin.setEmail("adminemail@bee.edu");
        admin.setName("Leeo Bee");
        admin.setPassword("password");
        admins.add(admin);

        Scanner kb = new Scanner(System.in);
        String yesNo = " ";
        String choose = " ";
        System.out.println("Welcome to Bee's School System!");
        System.out.println("Would you like to log in? (Y/N)");
        yesNo = kb.next();
        String em = " ";
        String pass = " ";
        if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("Would you like to log in as an (A)dmin, (F)aculty, or (S)tudent?");
            System.out.println("Please choose A");
            choose = kb.next();
        }
            if(choose.equalsIgnoreCase("a"))
            {
                System.out.println("Welcome admin ");
                System.out.println("Please enter your email:");
                em = kb.next();
                System.out.println("Please enter your password");
                pass = kb.next();
                //check log in credentials
                for(Admin a : admins)
                {
                    if (!a.getEmail().equalsIgnoreCase(em) || !a.getPassword().equalsIgnoreCase(pass))
                    {
                        System.out.println("Invalid email and/or password");
                        break;
                    }
                    else if(a.getEmail().equalsIgnoreCase(em) || a.getPassword().equalsIgnoreCase(pass))
                    {
                        System.out.println("Admin " + admin.getName());
                        System.out.println("You have successfully logged in");
                        System.out.println(" ");
                        do{
                        admin.showOptions();
                        int choice = kb.nextInt();
                        switch (choice) {
                            case 1:
                                addStudent();
                                break;
                            case 2:
                                System.out.println("Add faculty method");
                                break;
                            case 3:
                                System.out.println("Edit student");
                                break;
                            case 4:
                                System.out.println("edit cfaculty");
                                break;
                            case 5:
                                System.out.println("add class");
                                break;
                            case 6:
                                System.out.println("edit class");
                                break;
                            case 7:
                                System.out.println("enroll student");
                                break;
                            case 8:
                                System.out.println("Hire a faculty");
                                break;
                            case 9:
                                System.out.println("View all information");
                                showInformation();
                                break;
                            case 10:
                                System.out.println("Quit");
                                break;
                        }//end switch
                            System.out.println("Do you want to continue? (Y/N)");
                            yesNo = kb.next();
                            System.out.println("");
                        } while (yesNo.equalsIgnoreCase("y"));
                    }//end else if
                }//end for

        }//end big if


    }//end main

        public static void addStudent()
        {
                Student s = new Student();
                Scanner kb = new Scanner(System.in);
                System.out.println("Please enter the student ID (S-####)");
                String id = kb.nextLine();
                s.setId(id);
                System.out.println("Student Name");
                String name = kb.nextLine();
                s.setName(name);
                students.add(s);//add student info in students database
            }

            public static void showInformation()
            {

                System.out.println("All students");
                for(Student s:students)
                {
                    System.out.println(s.getId());
                    System.out.println(s.getName());
                    System.out.println(" ");
                }
            }

}
