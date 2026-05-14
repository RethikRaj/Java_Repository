package p19_Multithreading.p03_Problems.Atomicity;

public class SolutionOne {
    public static void main(String[] args) throws InterruptedException {
        Counter c1 = new Counter(0);

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10000;i++) c1.increment();
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10000;i++) c1.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c1.count);
    }
}

class Counter {
    int count;

    Counter(int count) {
        this.count = count;
    }

    synchronized void increment() {
        this.count++;
    }
}