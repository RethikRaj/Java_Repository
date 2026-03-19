package p09_OOPS.p16_enum;

public class BuiltInMethods {
    public static void main(String[] args) {
        // 1. values() 
        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
            System.out.println(direction); // internally calls direction.toString()
            // if toString() is not overrided , then it calls direction.name()
            // if overrided , then that functionality is executed.
        }

        // 2. valueOf()
        Direction d1 = Direction.valueOf("NORTH");
        // Direction d2 = Direction.valueOf("south"); // Error : java.lang.IllegalArgumentExceptio
        System.out.println(d1);
        // System.out.println(d2);

        // 3. name() => cannot be overriden
        System.out.println(d1.name());

        // 4. ordinal()
        System.out.println(d1.ordinal());
    }
}

enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    @Override
    public String toString() {
        return this.name() + " Direction ";
    }
}
