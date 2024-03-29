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
    public static String em = " ";
    public static String pass = " ";
    public static void main(String[] args) {
        //populate Admin account
        Admin admin = new Admin("Ad-001","Victor","admin1@email.com","password");
        admins.add(admin);
        //populate classes,students,and faculties
        populateDatabase();
        Scanner kb = new Scanner(System.in);
        String yesNo = " ";
        String choose = " ";

        System.out.println("Welcome to Bee's School System!");
        System.out.println("Would you like to log in? (Y/N)");
        yesNo = kb.next();

        if(yesNo.equalsIgnoreCase("n"))
        {
            System.out.println("Thank you for using Bee's School System");
        }
        else if (yesNo.equalsIgnoreCase("y")) {
            System.out.println("Would you like to log in as an (A)dmin, (F)aculty, or (S)tudent?");
            System.out.println("Please choose A");
            choose = kb.next();
        }
            if(choose.equalsIgnoreCase("a")) {
                System.out.println("Welcome Admin");
                System.out.println("Please enter your email:");
                em = kb.next();
                System.out.println("Please enter your password");
                pass = kb.next();
                //check log in credentials
                for (Admin a : admins) {
                   while (!a.getEmail().equalsIgnoreCase(em) || !a.getPassword().equalsIgnoreCase(pass)) {
                       System.out.println("Invalid email and/or password");
                       System.out.println(" ");
                       System.out.println("Please re-enter your email:");
                       em = kb.next();
                       System.out.println("Please re-enter your password");
                       pass = kb.next();
                   }//end while
                    if (a.getEmail().equalsIgnoreCase(em) && a.getPassword().equalsIgnoreCase(pass)) {
                        System.out.println("==========================================");
                        System.out.println("Admin "+a.getName()+" - You have successfully logged in");
                        System.out.println(" ");
                        do {
                            admin.showOptions();
                            int choice = kb.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Adding Student");
                                    addStudent();
                                    showStudent();
                                    break;
                                case 2:
                                    System.out.println("Adding Faculty");
                                    addFaculty();
                                    showFaculty();
                                    break;
                                case 3:
                                    System.out.println("Editing Student Information");
                                    editStudent();
                                    showStudent();
                                    break;
                                case 4:
                                    System.out.println("Editing Faculty Information");
                                    editFaculty();
                                    showFaculty();
                                    break;
                                case 5:
                                    System.out.println("Adding classes");
                                    addClasses();
                                    showClasses();
                                    break;
                                case 6:
                                    System.out.println("Editing Classes Description");
                                    editClasses();
                                    showClasses();
                                    break;
                                case 7:
                                    System.out.println("Enrolling student in a class");
                                    enrollStudent();
                                    break;
                                case 8:
                                    System.out.println("Assigning faculty to a class");
                                    assignFacultyToClass();
                                    break;
                                case 9:
                                    System.out.println("View all information");
                                    showInformation();
                                    break;
                                case 10:
                                    System.out.println(a.getName() + ", you have successfully logged out");
                                    System.out.println("Thank you for using Bee's School Systems");
                                    System.exit(0);
                                    break;
                            }//end switch

                            System.out.println("Do you want to continue with other options? (Y/N)");
                            yesNo = kb.next();
                            System.out.println("");
                        } while (yesNo.equalsIgnoreCase("y"));

                        System.out.println(a.getName() + ", you have successfully logged out");
                        System.out.println("Thank you for using Bee's School Systems");

                    }//end if log in is correct
                }//end for to loop through admin database
            }//end if user choose 'a'
    }//end main

    public static void populateDatabase()
    {
        Faculty f1 = new Faculty();
        f1.setId("F-001");
        f1.setName("George Karabatis");
        faculties.add(f1);
        Faculty f2 = new Faculty();
        f2.setId("F-002");
        f2.setName("Tate Redding");
        faculties.add(f2);

        Student s1 = new Student();
        s1.setId("S-001");
        s1.setName("Shannon W.");
        students.add(s1);
        Student s2 = new Student();
        s2.setId("S-002");
        s2.setName("Madison Santizo");
        students.add(s2);

        Class c1 = new Class("C-001","Database Management","Introduction to Database");
        classes.add(c1);
        Class c2 = new Class("C-002","Data Analytics","Collecting Data and stuff");
        classes.add(c2);
    }//end populate database method

    public static void enrollStudent(){
        StudentClassConnection studClassC = new StudentClassConnection();
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter ID for Student-Class connection");
        String conID = kb.nextLine();
        studClassC.setStudConID(conID);
        System.out.println("Please enter Student ID");
        String facID = kb.nextLine();
        studClassC.setStudConID(facID);
        System.out.println("Please enter Class ID");
        String classID = kb.nextLine();
        studClassC.setClassConID(classID);
        System.out.println("Please enter Date of enrollment (MM/DD/YYYY)");
        String date = kb.nextLine();
        studClassC.setDateEnroll(date);
        studentClassConnections.add(studClassC);
    }
    public static void assignFacultyToClass(){
        FacultyClassConnection fcc = new FacultyClassConnection();
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter ID for Faculty-Class connection");
        String conID = kb.nextLine();
        fcc.setFcConnID(conID);
        System.out.println("Please enter Faculty ID");
        String facID = kb.nextLine();
        fcc.setFacID(facID);
        System.out.println("Please enter Class ID");
        String classID = kb.nextLine();
        fcc.setFacClassConID(classID);
        facultyClassConnections.add(fcc);
    }//end assigning faculty method

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
    }//end add class method

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
        }//end add faculty method

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
            }//end add student method

        public static void editFaculty() {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter the ID of the Faculty that you wish to edit their name (F-###)");
            String id = kb.nextLine();
            for (Faculty f : faculties) {//go into faculties database,
                if (f.getId().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                    System.out.println("Enter new name of Faculty:");
                    f.setName(kb.nextLine());
                    break;
                }
            }//end for loop
        }//end edit faculty method

        public static void editStudent() {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter the ID of the Student that you wish to edit their name(S-###)");
            String id = kb.nextLine();
            for (Student s : students) {//go into students database,
                if (s.getId().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                    System.out.println("Enter new name of student:");
                    s.setName(kb.nextLine());
                    break;
                }
            }//end for loop
        }//end edit student method

        public static void editClasses()
        {
            Scanner kb = new Scanner(System.in);
            System.out.println("Please enter the ID of the class that you wish to edit its description (C-###)");
            String id = kb.nextLine();
            for(Class c : classes) {//go into classes database,
                if(c.getClassID().equalsIgnoreCase(id)) {//compare is with user id, if it's equal, do the execution
                    System.out.println("Enter new description for " +c.getClassName());
                    c.setDescription(kb.nextLine());
                    break;
                }
            }//end for loop
        }//end edit student method

            public static void showStudent()
            {
                System.out.println("---------------------------------");
                System.out.println("All Students");
                for (Student s : students) {
                    System.out.println(s.toString());
                }
            }//end show student method

            public static void showFaculty()
            {
                System.out.println("---------------------------------");
                System.out.println("All Faculties");
                for (Faculty f : faculties) {
                    System.out.println(f.toString());
                }
            }//end show faculty method

            public static void showClasses()
            {
                System.out.println("---------------------------------");
                System.out.println("All Classes");
                for (Class c : classes) {
                    System.out.println(c.toString());
                }
            }//end show classes method

            public static void showInformation() {
                System.out.println("---------------------------------");
                System.out.println("ALL STUDENTS");
                for (Student s : students) {
                    System.out.println(s.toString());
                }
                System.out.println("---------------------------------");
                System.out.println("ALL FACULTIES");
                for (Faculty f : faculties) {
                    System.out.println(f.toString());
                }
                System.out.println("---------------------------------");
                System.out.println("ALL CLASSES");
                for (Class c : classes) {
                    System.out.println(c.toString());
                }

                System.out.println("---------------------------------");
                System.out.println("CLASSES TAUGHT BY FACULTIES");
                for (FacultyClassConnection fcc : facultyClassConnections) {
                    for (Faculty f : faculties) {
                        if (fcc.getFacID().equalsIgnoreCase(f.getId())) {
                            System.out.println("Faculty iD: " + f.getId());
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
                    System.out.println(" ");
                }//end big for faculty-class

                System.out.println("---------------------------------");
                System.out.println("STUDENT ENROLLMENT");
                for (StudentClassConnection scc : studentClassConnections) {
                    for (Student s: students) {
                        if (scc.getStudConID().equalsIgnoreCase(s.getId())) {
                            System.out.println("Student Name: " + s.getName());
                            break;
                        }
                    }
                    for (Class c : classes) {
                        if (scc.getClassConID().equalsIgnoreCase(c.getClassID())) {
                            System.out.println("Class: " + c.getClassName());
                            break;
                        }
                    }
                    System.out.println("Date enrolled: "+scc.getDateEnroll());
                    System.out.println(" ");
                }//end big for student-class
            }//end showInfo method

}
