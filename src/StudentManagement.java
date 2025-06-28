import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;



    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add the student
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    Student student = new Student(id, name, marks);
                    students.add(student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // To view the student detail
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Update student detail
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            scanner.nextLine();
                            System.out.print("Enter new name: ");
                            s.setName(scanner.nextLine());
                            System.out.print("Enter new marks: ");
                            s.setMarks(scanner.nextDouble());
                            System.out.println("Student updated successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 4:
                    // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    Student toRemove = null;
                    for (Student s : students) {
                        if (s.getId() == deleteId) {
                            toRemove = s;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        students.remove(toRemove);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
nxcn