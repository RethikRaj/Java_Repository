package p09_OOPS.p13_NestedClass;

public class AnonymousClass {
    public static void main(String[] args) {
        Greet g = new Greet();
        g.greet();

        // method 2 : anonymous class
        Greet formal = new Greet() {
            // 2. Instance variables/methods of this anonymous can only be accessed inside this class because the reference type of `formal` is Greet which don't have the instance variables/methods of anonymous class.

            int x = 20;

            void someMethod() {System.out.println("someMethod");}

            // 1. Override parent methods
            @Override
            void greet() {
                System.out.println("Formal Greet : Good Morning Sir / Madam");
                // Can access inside the class
                System.out.println(x);
                someMethod();
            }
        };
        formal.greet();
        System.out.println(formal.name);
        // formal.x; // Can't do since type of `formal` is Greet 
        // formal.someMethod(); // Can't do since type of `formal` is Greet.


        Greet casual = new Greet() {
            @Override
            void greet() {
                System.out.println("Casual Greet : Hey, what's up!");
            }
        };
        casual.greet();

        Greet farewell = new Greet() {
            @Override
            void greet() {
                System.out.println("Farewell Greet : Bye Bye");
            }
        };
        farewell.greet();   
    }
}


// Problem Statement : suppose let's say we have use case of formal greet , casual greet , farewell greet and it's a one time use case

class Greet {
    String name = "Rethik";
    void greet() {
        System.out.println("Default Greet : Hello " + name);
    }
}


// Method 1 : Inheritance -> Problem is that for one time use we are writing more classes which are reusable
// class FormalGreet extends Greet {
//     @Override
//     void greet() {
//         System.out.println("Formal Greet : Good Morning Sir / Madam" + name);
//     }
// }

// class CasualGreet extends Greet {
//     @Override
//     void greet() {
//         System.out.println("Casual Greet : Hey, what's up! " + name);
//     }
// }

// class FarewellGreet extends Greet {
//     @Override
//     void greet() {
//         System.out.println("Farewell Greet : Bye Bye " + name);
//     }
// }




