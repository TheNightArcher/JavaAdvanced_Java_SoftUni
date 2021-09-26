import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String nameStudent = input[0];
            double grade = Double.parseDouble(input[1]);

            studentGrades.putIfAbsent(nameStudent, new ArrayList<>());
            List<Double> gradeStudent = studentGrades.get(nameStudent);
            gradeStudent.add(grade);
        }

        studentGrades.forEach((k,v) -> {
            StringBuilder grades = new StringBuilder();
            double sum = 0;
            for (var num: v) {
                sum += num;
                grades.append(String.format("%.2f ",num));
            }
            double average = sum / v.size();
            // Stephan -> 5.20 3.20 (avg: 4.20)
            System.out.printf("%s -> %s(avg: %.2f)%n",k,grades,average);
        });

    }
}
