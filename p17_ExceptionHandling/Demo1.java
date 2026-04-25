package p17_ExceptionHandling;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a/b); 
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        // at p17_ExceptionHandling.Demo1.main(Demo1.java:12)
    }
}
