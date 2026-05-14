package p19_Multithreading.p03_Problems.Visibility;

public class ExampleOne {
    public static void main(String[] args) {
        Flag f = new Flag();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

            f.flag = true;
        });

        Thread t2 = new Thread(()->{
            while(f.flag == false) {
                // do nothing
            }
            System.out.println("T2 ends");
        });

        t1.start();
        t2.start();
    }
}

class Flag {
    boolean flag = false;
}
