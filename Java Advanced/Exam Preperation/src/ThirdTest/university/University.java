package ThirdTest.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String result = "";
        if (students.size() < capacity) {

            for (Student student1 : students) {
                if (student1.firstName.equals(student.firstName) && student1.lastName.equals(student.lastName)) {
                   return result = "Student is already in the university";

                }
            }
            students.add(student);
            result = String.format("Added student %s %s", student.getFirstName(), student.getLastName());

        } else {
            result = "No seats in the university";
        }
        return result;
    }

    public String dismissStudent(Student student) {
        String result = "Student not found";
        for (Student student1 : students) {
            if (student1.equals(student)) {
                students.remove(student1);
                return result = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(String.format("==First Name = %s, ", student.getFirstName()))
                    .append(String.format("Last Name = %s, ", student.getLastName()))
                    .append(String.format("Best Subject = %s", student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
}
