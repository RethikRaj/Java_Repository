package p09_OOPS.p15_ObjectClass;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Default behaviour
        WithoutOverrided wo1 = new WithoutOverrided("rethik", 28);
        WithoutOverrided wo2 = new WithoutOverrided("rethik", 28);
        WithoutOverrided wo3 = wo1;

        // 1. toString() => returns className@hashcode
        System.out.println(wo1.toString());
        System.out.println(wo1); // println internally calls toString()

        // 2. equals() => compares references and return boolean
        System.out.println(wo1.equals(wo2)); // false
        System.out.println(wo1.equals(wo3)); // true

        // 3.hashCode() => returns an integer 
        System.out.println(wo1.hashCode());
        System.out.println(wo1.hashCode() == wo2.hashCode());
        System.out.println(wo1.hashCode() == wo3.hashCode()); // Since wo1.equal(wo3) is true , therefore wo1.hashCode() == wo3.hashCode() must be true.

        // 4. getClass() => returns the runtime class of an object. It is a final method and thus cannot be overrided.
        Class c = wo1.getClass();
        System.out.println(c);
        System.out.println(c.getName());
        System.out.println(wo1.getClass().getName() == wo2.getClass().getName());

        // 5. clone => does shallow copy meaning a new object is created but nested references are shared but here we have no nested references . Refer shallowCopy for more details
        WithoutOverrided clonewo1 = (WithoutOverrided) wo1.clone();
        System.out.println(clonewo1 == wo1); // false
        


        // overrided behaviour
        WithOverrided wio1 = new WithOverrided("rethik", 28);
        WithOverrided wio2 = new WithOverrided("rethik", 28);
        WithOverrided wio3 = new WithOverrided(null, 29);

        // 1. toString()
        System.out.println(wio1.toString());
        System.out.println(wio1); // println internally calls toString()

        // 2. equals()
        System.out.println(wio1.equals(wio2)); // true
        System.out.println(wio1.equals(wio3)); // false

        // 3. hashCode()
        System.out.println(wio1.hashCode());
        System.out.println(wio1.hashCode() == wio2.hashCode()); // since wio1.equals(wio2) is true , therefore wio1.hashCode() == wio2.hashCode() must be true.
        System.out.println(wio1.hashCode() == wio3.hashCode());

        // 4. getClass() => cannot be overriden so we get default behavior.
        System.out.println(wio1.getClass().getName());

        // 5. clone
        WithOverrided clonewio1 = (WithOverrided) wio1.clone();
        System.out.println(clonewio1 == wio1); // false


    }
}
