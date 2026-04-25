package p16_Optional_Class;

import java.util.Optional;

public class OptionalGetDemo {
    public static String getFallback() {
        System.out.println("Fallback called!");
        return "default";
    }

    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Rethik");
        Optional<String> o2 = Optional.empty();

        // 1. T get()
        String s1 = o1.get();
        // String s2 = o2.get(); // null value -> No such element exception

        System.out.println(s1);

        // 2. boolean isPresent()
        boolean isNotNullValue = o1.isPresent();
        System.out.println(isNotNullValue);
        if(o2.isPresent()) {
            System.out.println(o2.get());
        }

        // 3. void ifPresent(Consumer)
        o1.ifPresent(System.out::println);
        o2.ifPresent((x) -> System.out.println(x + " hello")); // the consumer won't be executed because o2 wraps a null value.

        // 4. T orElse(T DefaultValue)
        // The fallback value is always evaluated, even if the Optional has a value.
        String s11 = o1.orElse(getFallback()); // getFallBack() is executed even though the value wrapped by o1 is not null. But it returns the fallback value only if o1 wraps null. 
        String s21 = o2.orElse(getFallback());

        System.out.println(s11 + "\n" + s21);

        // 5. T orElseGet(Supplier)
        // The fallback is lazily evaluated — only called if the Optional is empty.
        String s12 = o1.orElseGet(() -> getFallback()); // getFallBack() is not called
        String s22 = o2.orElseGet(() -> getFallback()); // getFallBack() is called.

        System.out.println(s12 + "\n" + s22);

        // If the fallback is cheap and has no side effects, orElse is fine.
        // If it's expensive or has side effects, always prefer orElseGet.

        // 6.1) orElseThrow() 
        String s13 = o1.orElseThrow(); 
        // String s23 = o2.orElseThrow();

        // 6.2) orElseThrow(Supplier)
        // String s24 = o2.orElseThrow(() -> new IllegalStateException("Something "));

        // 7. isPresentOrElse()
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("Fallback value"));
        o2.ifPresentOrElse(System.out::println, () -> System.out.println("Fallback value"));

    }
}
