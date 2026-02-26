public class IfElse {
    public static void main(String[] args) {
        int age = 18;
        if (age >= 18) {
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("You are not eligible to vote");
        }

        // if-elseif-else
        int marks = 90;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 70) {
            System.out.println("Grade C");
        } else if (marks >= 60) {
            System.out.println("Grade D");
        } else if (marks >= 50) {
            System.out.println("Grade E");
        } else {
            System.out.println("Grade F");
        }

    }
}
