package p19_Multithreading.p04_ClassicProblems.Producer_Consumer;

public class Problem {
    public static void main(String[] args) {
        Box b = new Box();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try{
                    Thread.sleep(1000);
                }catch(Exception e) {}
                b.produce(i);
            }
        });

        Thread conumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try{
                    Thread.sleep(700);
                }catch(Exception e) {}
                b.consume();
            }
        });

        producer.start();
        conumer.start();
    }
}

class Box {
    private Integer item = null;
    private boolean isEmpty = true;

    void produce(int value) {
        item = value;
        isEmpty = false;
        System.out.println("Produced : " + value);
    }

    Integer consume() {
        Integer value = item;
        item = null;
        isEmpty = true;
        System.out.println("Consumed: " + value);
        return value;
    }
}
