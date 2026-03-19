package p09_OOPS.p16_enum;

public class EnumsWithAbstract {
    
}

// Problem Statemnt : We need an direction enum and move method assoicated with each direction. on calling that we move 1step in that direction.
enum Direction {
    NORTH {
        @Override
        public void move() {
            System.out.println("Moving North : y + 1");
        }
    },
    SOUTH {
        @Override
        public void move() {
            System.out.println("Moving South : y - 1");
        }
    },
    EAST {
        @Override
        public void move() {
            System.out.println("Moving East : x + 1");
        }
    },
    WEST {
        @Override
        public void move() {
            System.out.println("Moving West : x - 1");
        }
    };

    public abstract void move();
}
