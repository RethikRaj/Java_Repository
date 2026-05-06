package p19_Multithreading.p01_Basics_of_threads;

public class Start_vs_Run {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> {
            System.out.println("Helloo .. I am executed by thread : " + Thread.currentThread().getName());
        });

        t1.start();
        t1.run(); // it just executes the run method on the main thread.
    }
}
