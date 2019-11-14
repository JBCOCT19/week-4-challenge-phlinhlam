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
        admin.setEmail("admin1@email.com");
        admin.setName("Leeo Bee");
        admin.setPassword("password");
        admins.add(admin);
        Faculty f1 = new Faculty();
        f1.setId("F-005");
        f1.setName("George Karabatis");
        faculties.add(f1);
        Student s1 = new Student();
        s1.setId("S-005");
        s1.setName("Shannon W.");
        students.add(s1);
        Class c1 = new Class("C-005","Databse Management","Introduction to Database");
        classes.add(c1);


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
                                addFaculty();
                                break;
                            case 3:
                                editStudent();
                                break;
                            case 4:
                                editFaculty();
                                break;
                            case 5:
                                addClasses();
                                break;
                            case 6:
                                editClasses();
                                break;
                            case 7:
                                System.out.println("enroll student");
                                break;
                            case 8:
                                assignFacultyToClass();
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
                        System.out.println("Thank you for using Bee's School Systems");
                    }//end else if
                }//end for

        }//end big if


    }//end main


    public static void assignFacultyToClass(){
        FacultyClassConnection fcc = new FacultyClassConnection();
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter ID for Faculty-Class connection");
        String conID = kb.nextLine();
        fcc.setFcConnID(conID);
        System.out.println("Faculty ID");
        String facID = kb.nextLine();
        fcc.setFacID(facID);
        System.out.println("Class ID");
        String classID = kb.nextLine();
        fcc.setFacClassConID(classID);
        facultyClassConnections.add(fcc);
    }
    public static void editFaculty() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the ID of the Faculty that you wish to edit (F-###)");
        String id = kb.nextLine();
        for (Faculty f : faculties) {//go into faculties database,
            if (f.getId().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                System.out.println("Enter new name of Faculty:");
                f.setName(kb.nextLine());
                break;
            }
        }//end for loop
    }
    public static void editStudent() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the ID of the Student that you wish to edit (S-###)");
        String id = kb.nextLine();
        for (Student s : students) {//go into students database,
            if (s.getId().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                System.out.println("Enter new name of student:");
                s.setName(kb.nextLine());
                break;
            }
        }//end for loop
    }
    public static void editClasses()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the ID of the class that you wish to edit (C-###)");
        String id = kb.nextLine();
        for(Class c : classes) {//go into classes database,
                if(c.getClassID().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                        System.out.println("Enter new name of the class:");
                        c.setClassName(kb.nextLine());
                        break;
                    }
        }//end for loop
    }
    public static void addClasses()
    {
        Class c = new Class();
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the Class ID (C-###)");
        String id = kb.nextLine();
        c.setClassID(id);
        System.out.println("Class Name");
        String name = kb.nextLine();
        c.setClassName(name);
        System.out.println("Class Description");
        String desc = kb.nextLine();
        c.setDescription(desc);
        classes.add(c);//add class to database
    }
        public static void addFaculty()
        {
            Faculty f = new Faculty();
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter the Faculty ID (F-###)");
            String id = kb.nextLine();
            f.setId(id);
            System.out.println("Faculty Name");
            String name = kb.nextLine();
            f.setName(name);
            faculties.add(f);//add faculty into faculties database
        }
        public static void addStudent()
        {
                Student s = new Student();
                Scanner kb = new Scanner(System.in);
                System.out.println("Please enter the student ID (S-###)");
                String id = kb.nextLine();
                s.setId(id);
                System.out.println("Student Name");
                String name = kb.nextLine();
                s.setName(name);
                students.add(s);//add student info in students database
            }

            public static void showInformation() {
                System.out.println("-------------------------");
                System.out.println("All students");
                for (Student s : students) {
                    System.out.println("Student ID: " + s.getId());
                    System.out.println("Student Name " + s.getName());
                    System.out.println(" ");
                }
                System.out.println("-------------------------");
                System.out.println("All faculties");
                for (Faculty f : faculties) {
                    System.out.println("Faculty ID: " + f.getId());
                    System.out.println("Faculty Name: " + f.getName());
                    System.out.println(" ");
                }
                System.out.println("-------------------------");
                System.out.println("All classes");
                for (Class c : classes) {
                    System.out.println("Class ID: " + c.getClassID());
                    System.out.println("Class Name: " + c.getClassName());
                    System.out.println("Class Description: " + c.getDescription());
                    System.out.println(" ");
                }
                System.out.println("-------------------------");
                System.out.println("Faculties and Classes that they teach");
                for (FacultyClassConnection fcc : facultyClassConnections) {
                    for (Faculty f : faculties) {
                        if (fcc.getFacID().equalsIgnoreCase(f.getId())) {
                            System.out.println("Faculty Name: " + f.getName());
                            break;
                        }
                    }
                    for (Class c : classes) {
                        if (fcc.getFacClassConID().equalsIgnoreCase(c.getClassID())) {
                            System.out.println("Class: " + c.getClassName());
                            break;
                        }
                    }
                }//end big for
            }//end showInfo method


}
