package p09_OOPS.p03_CallByValue;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println("Before calling incrementTenPrimitive:");
        System.out.println("x: " + x + ", y: " + y);

        incrementTenPrimitive(x, y);

        System.out.println("After calling incrementTenPrimitive:");
        System.out.println("x: " + x + ", y: " + y);

        Point p1 = new Point(10, 20);
        
        System.out.println("Before calling incrementTenNonPrimitive:");
        System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);

        incrementTenNonPrimitive(p1);

        System.out.println("After calling incrementTenNonPrimitive:");
        System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);

    }   

    static void incrementTenPrimitive(int x, int y) {
        x += 10;
        y += 10;
    } 

    static void incrementTenNonPrimitive(Point p) {
        p.x += 10;
        p.y += 10;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


