package p19_Multithreading.p02_Methods_in_Thread;

public class Sleep {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " starts");

        Thread t1 = new Thread(() -> {
            System.out.println("Helloo .. I am executed by thread : " + Thread.currentThread().getName());
        });

        t1.start();

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName() + " ends.");
    }
}
