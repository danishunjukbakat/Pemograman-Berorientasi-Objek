import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class StudentCollectionDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Rina", "Computer Science", "Bandung"));
        students.add(new Student("S002", "Andi", 10, "Cimahi"));
        students.add(new Student("S003", "Dewi", "Information Systems", "Garut"));
        students.add(new Student("S004", "Budi", "Computer Science", "Bandung"));
        students.add(new Student("S005", "Citra", 20, "Sumedang"));

        System.out.println("=== ArrayList<Student> ===");
        System.out.println("Jumlah sebelum sort = " + students.size());
        System.out.println("Sebelum sort:");
        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students, Comparator.comparing(Student::getName));

        System.out.println("Setelah sort by name:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Eksperimen operasi List:");
        students.add(new Student("S006", "Eka", 30, "Bogor"));
        System.out.println("Setelah menambah Eka tanpa sort ulang:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("students.get(0) = " + students.get(0));

        int sizeBeforeRemove = students.size();
        Student removedStudent = students.remove(1);
        System.out.println("remove(1) = " + removedStudent);
        System.out.println("size sebelum remove = " + sizeBeforeRemove);
        System.out.println("size sesudah remove = " + students.size());

        Vector<Student> vector = new Vector<>();
        vector.add(new Student("V001", "Alya", "Computer Science", "Bandung"));
        vector.add(new Student("V002", "Raka", "Accounting", "Cimahi"));
        vector.add(new Student("V003", "Sinta", "Computer Science", "Bandung"));
        vector.add(new Student("V004", "Dimas", "Mechanical Engineering", "Garut"));
        vector.add(new Student("V005", "Nadia", "Computer Science", "Sumedang"));

        System.out.println("=== Vector<Student>: Computer Science ===");
        for (Student student : vector) {
            if (student.getDepartment() instanceof String
                    && ((String) student.getDepartment()).equalsIgnoreCase("Computer Science")) {
                System.out.println(student);
            }
        }
    }
}
