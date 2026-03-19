package p09_OOPS.p16_enum;

public class EnumsWithConstructors {
    public static void main(String[] args) {
        Direction d = Direction.EAST;
        System.out.println(d.getDegree());
    }
}

// Problem Statemnt : We need an direction enum but each direction should have a degree associated with it.
enum Direction {
    NORTH(0),
    SOUTH(180), 
    EAST(90),
    WEST(270);

    private int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }
}