package p14_LambdaExpressions.p4_MethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,-5,6,-7,8,9));

        // 1. Static method reference
        list.forEach(Math::abs);
        
        // 2. Instance method via ObjectName
        list.forEach(System.out::println);

        // 3. Instance method via ClassName
        // Predicate<String> isEmpty = (str) -> str.isEmpty();
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("abc"));

        // 4. Constructor 
        // Supplier<List<Integer>> s = () -> new ArrayList<>();
        Supplier<List<Integer>> s = ArrayList::new;

        List<Integer> l1 = s.get();
        List<Integer> l2 = s.get();

        
    }
}
