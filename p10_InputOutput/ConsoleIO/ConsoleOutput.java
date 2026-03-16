package p10_InputOutput.ConsoleIO;


public class ConsoleOutput {
    public static void main(String[] args) {
        // 1. System is a class of java.lang package.(This package is auto-imported by compiler)
        // 2. out is a static variable inside System class of type PrintStream
        // 3. println , print , printf are methods of PrintStream class
        // 4. static PrintStream out = new PrintStream(new BufferedOutputStream(FileDescriptor.out)) [Conceptual]
    
        System.out.println("Hello I am Rethik.");
        System.out.print("Hello ");
        System.out.print("\n");
        System.out.printf("Hello %s. \n", "Rethik");

        // err is a static variable inside System class of type PrintStream
        // err = new PrintStream(new BufferedOutputStream(FileDescriptor.err))
        System.err.println("This ia an error.");

    }
}
