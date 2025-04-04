import java.util.Scanner;

class Student {
    String name;
    int rollno;
    int age;
    String grade;
    Student next;

    Student(int rollno, String name, int age, String grade) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentLinkedList {
    Student head;

    public void addFirst(int rollno, String name, int age, String grade) {
        Student newstudent = new Student(rollno, name, age, grade);
        newstudent.next = head;
        head = newstudent;
    }

    public void addLast(int rollno, String name, int age, String grade) {
        Student newstudent = new Student(rollno, name, age, grade);
        if (head == null) {
            head = newstudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newstudent;
    }

    public void addAtPosition(int index, int rollno, String name, int age, String grade) {
        if (index == 0) {
            addFirst(rollno, name, age, grade);
            return;
        }

        Student newstudent = new Student(rollno, name, age, grade);
        Student current = head;

        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position is out of range");
            return;
        }

        newstudent.next = current.next;
        current.next = newstudent;
    }

    public void deleteByRollno(int roll) {
        if (head == null) return;

        if (head.rollno == roll) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Student current = head;
        while (current.next != null && current.next.rollno != roll) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with Roll No " + roll + " not found.");
        }
    }

    public void searchByRollno(int rollno) {
        Student current = head;
        while (current != null) {
            if (current.rollno == rollno) {
                System.out.println("Found Student: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student Not Found in the List");
    }

    public void updateGrade(int rollno, String newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollno == rollno) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }
            current = current.next;
        }
        System.out.println("Student of " + rollno + " not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }

        Student current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll No: " + current.rollno + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class StudentManagmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList student = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Grade by Roll Number");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int rollNo, age, pos;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    student.addFirst(rollNo, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    student.addLast(rollNo, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position (0-based index): ");
                    pos = sc.nextInt();
                    System.out.print("Enter Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = sc.nextLine();
                    student.addAtPosition(pos, rollNo, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    rollNo = sc.nextInt();
                    student.deleteByRollno(rollNo);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    rollNo = sc.nextInt();
                    student.searchByRollno(rollNo);
                    break;

                case 6:
                    System.out.print("Enter Roll No to update grade: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new grade: ");
                    grade = sc.nextLine();
                    student.updateGrade(rollNo, grade);
                    break;

                case 7:
                    student.display();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        sc.close();
    }
}
