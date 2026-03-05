public class ReferenceCopy {
    public static void main(String[] args) {
        Point p1 = new Point(100, 200); // In heap a object is created and p1 points to it
        Point p2 = p1; // No new object is created , p2 just points to same object because p2 holds the value stored in p1 which is the memory address of that object

        System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);
        System.out.println("p2.x: " + p2.x + ", p2.y: " + p2.y);

        p1.x += 100;
        p1.y += 200;
        p2.x += 100;
        p2.y += 200;

        System.out.println("p1.x: " + p1.x + ", p1.y: " + p1.y);
        System.out.println("p2.x: " + p2.x + ", p2.y: " + p2.y);
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
