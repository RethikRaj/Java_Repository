package p14_LambdaExpressions.p2_Custom;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class ExampleTwo {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a*b;

        System.out.println(add.calculate(5, 10));
        System.out.println(subtract.calculate(10,5));
        System.out.println(multiply.calculate(-10, 5));
    }
}
