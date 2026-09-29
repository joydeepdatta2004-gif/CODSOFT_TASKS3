import java.util.Scanner;

public class StudentGradeCalculator {

    // Method to calculate grade
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("        STUDENT GRADE CALCULATOR");

        // Student details
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int numberOfSubjects = sc.nextInt();
        sc.nextLine();

        String[] subjects = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];

        int totalMarks = 0;

        // Input subject names and marks
        for (int i = 0; i < numberOfSubjects; i++) {

            System.out.print("\nEnter Subject " + (i + 1) + " Name: ");
            subjects[i] = sc.nextLine();

            while (true) {
                System.out.print("Enter marks in " + subjects[i] + " (0-100): ");
                marks[i] = sc.nextInt();

                if (marks[i] >= 0 && marks[i] <= 100) {
                    break;
                }

                System.out.println(
                    "Invalid marks! Please enter marks between 0 and 100."
                );
            }

            sc.nextLine();
            totalMarks += marks[i];
        }

        double averagePercentage =
                (double) totalMarks / numberOfSubjects;

        String grade = calculateGrade((double) totalMarks / numberOfSubjects);

        System.out.println("\n\n==========================================");
        System.out.println("              STUDENT RESULT");
        System.out.println("==========================================");

        System.out.println("Student Name : " + studentName);

        System.out.println("------------------------------------------");

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("%-20s : %d/100%n",
                    subjects[i], marks[i]);
        }

        System.out.println("------------------------------------------");

        System.out.println("Total Marks  : " +
                totalMarks + "/" + (numberOfSubjects * 100));

        System.out.printf("Percentage   : %.2f%%%n",
                averagePercentage);

        System.out.println("Grade        : " + grade);

        System.out.println("==========================================");

        sc.close();
    }
}
