package p09_OOPS.p15_ObjectClass;

public class InstanceOf_and_getClass {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new SmartPhone();

        SmartPhone sp1 = new SmartPhone();
        
        // objName instanceof ClassName  : It checks whether `objName` is an instance of ClassName or any of its subclasses. It checks at runtime. Use this when you want to check hierarchy.
        System.out.println(p1 instanceof Product); // true
        System.out.println(p1 instanceof SmartPhone); // false
        System.out.println(p2 instanceof Product); // true
        System.out.println(p2 instanceof SmartPhone); // true

        System.out.println(sp1 instanceof Product); // true
        System.out.println(sp1 instanceof SmartPhone); // true

        // getClass : Use this when you want exact type match 
        System.out.println(p1.getClass().getName() == p2.getClass().getName()); // Product == SmartPhone ? => false
        System.out.println(p1.getClass().getName() == sp1.getClass().getName()); // Product == SmartPhone ? => false
        System.out.println(p2.getClass().getName() == sp1.getClass().getName()); // SmartPhone == SmartPhone ? => true


    }
}

class Product {
}

class SmartPhone extends Product {
}

