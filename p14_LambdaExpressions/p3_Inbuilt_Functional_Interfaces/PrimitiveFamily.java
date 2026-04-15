package p14_LambdaExpressions.p3_Inbuilt_Functional_Interfaces;

import java.util.function.IntFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFamily {
    public static void main(String[] args) {
        // 1. Function

        // 1.1) IntFunction : int -> R
        IntFunction<Integer> square = (x) -> x*x;
        System.out.println(square.apply(10));

        // 1.2) LongFunction : long -> R

        // 1.3) DoubleFunction : double -> R

        // 1.4) ToIntFunction : T -> int , ToIntBiFunction : (T t, U u) -> int
        // 1.5) To

        // 2. Consumer 

        

    }
}