package p19_Multithreading.p01_Basics_of_threads;

public class ThreadCreation {
    public static void main(String[] args) {
        // Method 1 :
        MyThread t1 = new MyThread(); // just an object at heap

        t1.start(); // OS creates thread , allocates stack + PC, pushes run() method into this new thread's stack memory.

        // Method 2 :
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start();

        // Short way : Runnable is a functional interface -> can use lambdas to provide defintion for run() method
        Thread t3 = new Thread(() -> {
            System.out.println("Lambda task is executed by thread : " + Thread.currentThread().getName());
        });
        t3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My thread : " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("My task is executed by thread : " + Thread.currentThread().getName());
    }
}
