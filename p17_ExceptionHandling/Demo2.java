package p17_ExceptionHandling;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a/b);

            String name = null;
            System.out.println(name.length());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
