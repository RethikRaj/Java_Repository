package p19_Multithreading.p04_ClassicProblems.Producer_Consumer;

public class SolutionOne {
    public static void main(String[] args) {
        Box b = new Box();

        Thread p1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                try{
                    Thread.sleep(1000);
                }catch(Exception e) {}
                b.produce(i);
            }
        });

        Thread c1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                try{
                    Thread.sleep(700);
                }catch(Exception e) {}
                b.consume();
            }
        });

        p1.start();
        c1.start();
    }
}


class Box {
    private volatile Integer item = null;
    private volatile boolean isEmpty = true;

    void produce(int value) {
        while(!isEmpty) {
            // busy waiting
        }
        item = value;
        isEmpty = false;
        System.out.println("Produced : " + value);
    }

    Integer consume() {
        while(isEmpty) {
            // busy waiting
        }
        Integer value = item;
        item = null;
        isEmpty = true;
        System.out.println("Consumed: " + value);
        return value;
    }
}
