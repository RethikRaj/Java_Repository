package p10_InputOutput.ConsoleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleInput {

    // InputStream class : Reads stream of bytes
    static void MethodOne() throws IOException {
        // 1. System is a class of java.lang package.(This package is auto-imported by compiler)
        // 2. `in` is a static variable inside System class of type InputStream
        // 3. read() is a method of InputStream class -> only reads a single byte of data from the input OS buffer
        // 4. in  = new BufferedInputStream(new FileInputStream(FileDescriptor.in)) [Conceptual]

        // Example 1 : 
        // System.out.print("Type something : ");
        // int data = System.in.read();
        // System.out.println((char) data);

        // Example 2 :
        System.out.print("Type something : ");
        String s = "";
        char input = (char) System.in.read();
        while (input != '\n') {
            s += input;
            input = (char) System.in.read();
        }
        System.out.println(s);

        // diadv : 
        // 1. Not simple
        // 2. Many operating system calls because InputStream reads from input OS buffer.
    }   

    // Reader class : Reads stream of characters
    static void MethodTwo() throws IOException {
        // 1. System.in is an InputStream which reads from OS buffer in bytes.
        // 2. InputStreamReader : It reads the bytes and converts them to characters.
        InputStreamReader isr = new InputStreamReader(System.in);
        // 3. BufferedReader reads those characters and stores in inside another buffer which is inside program memory and thus less number OS calls.
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Type something : ");
        String s = br.readLine(); // Always give string as output , so we need to typecast if we want other types.
        // System.out.println(Integer.parseInt(s)); 
        // System.out.println(Boolean.parseBoolean(s));
        // System.out.println(Double.parseDouble(s));
        System.out.println(s);
    }

    // Scanner class : Does not belong to java.io package. It belongs to java.util package.
    // Scanner class does tokenization, type casting , ... and thus it is slow than BufferedReader.
    static void MethodThree() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type something : ");
        String s = sc.nextLine();
        int a = sc.nextInt();
        double b = sc.nextDouble();
        System.out.println(s + " " + a + " " + b);
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        // MethodOne();

        // MethodTwo();

        MethodThree();
        
    }
}
