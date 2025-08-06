
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCURD {

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        //Menu
        do {
            System.out.println("\n ---- Student management System ----\n 1.Add student \n 2.View Students\n 3.Update Student\n 4.Delete Student \n 5.Exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 ->
                    addStudent();
                case 2 ->
                    viewStudent();
                case 3 ->
                    updateStudent();
                case 4 ->
                    deleteStudent();
                case 5 -> {
                    System.out.println("Exiting....");
                    return;
                }
                default ->
                    System.out.println("Invalid");

            }

        } while (choice != 5);
    }
    //Adding student record

    static void addStudent() {
        System.out.println("enter id");
        int id = scanner.nextInt();
        System.out.println("enter name");
        String name = scanner.next();
        System.out.println("enter marks");
        double marks = scanner.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("added successfully");
    }
    //View Student Records

    static void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No student are there");
        } else {
            System.out.println("\nStudent records are..");
            for (Student s : studentList) {
                System.out.println(s);

            }
        }
    }

    //Update Student records
    static void updateStudent() {
        System.out.println("Enter student ID ....");
        int id = scanner.nextInt();
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.println("enter name");
                s.setName(scanner.next());
                System.out.println("enter marks");
                s.setMarks(scanner.nextDouble());
                System.out.println("Updated sucessfully");
                return;

            }
        }
        System.out.println("Student with id " + id + " not found");
    }

    //Delete Student Record
    static void deleteStudent() {
        System.out.println("Enter Student id");
        int id = scanner.nextInt();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student deleted successfully.");
                return;

            }
        }

        System.out.println(id + "id not found ");

    }

}
//create student class

class Student {

    private int id;
    private String name;
    private double marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    

    //Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Id :" + id + " name :" + name + " marks :" + marks;
    }

}
