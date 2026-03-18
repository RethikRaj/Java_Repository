package p09_OOPS.p15_ObjectClass;

public class WithoutOverrided implements Cloneable {
    String name;
    int age;

    public WithoutOverrided(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
