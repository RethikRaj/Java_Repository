package p14_LambdaExpressions.p3_Inbuilt_Functional_Interfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NonPrimitiveFamily {
    public static void main(String[] args) {
        // 1. Function : T -> R ,  R apply(T t)
        Function<Integer, Integer> square = (x) -> x*x;
        System.out.println(square.apply(5));

        // 2. Consumer : T -> void ,  void accept(T t)
        Consumer<Integer> printer = (x) -> System.out.println(x);
        printer.accept(5);

        // 3. Supplier : void -> T ,  T get()
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        // 4. Predicate : T -> boolean , boolean test(T t)
        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        System.out.println(isEven.test(6));   
    }
}