package p09_OOPS.p15_ObjectClass;

import java.util.Objects;

public class WithOverrided implements Cloneable {
    String name;
    int age;

    public WithOverrided(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "WithOverrided{" +"name='" + this.name + '\'' +", age=" + age +'}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) { // optimization
            return true;
        }

        if (obj == null) {
            return false;
        }

        // check whether o is of same class so that we won't get ClassCastException.
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        WithOverrided o = (WithOverrided) (obj);

        return (this.name.equals(o.name) && this.age == o.age);
    }

    @Override
    public int hashCode() {
        // Rule : if two objects of this class are equal according to equals method , then their hash code must be equal. Vice versa need not be true.
        // Since we overrided the equals method it is our responsibility to follow the above rule.
        // We know that the overrided equals method compares based on name and age, so we create hash based on name and age then we can guarantee rule.

        // Manual Implementation
        // int result = 17;
        // result = 31 * result + age;
        // result = 31 * result + (name == null ? 0 : name.hashCode());
        // return result; 

        // util method
        // Objects.hash takes in Object type so when age(int) is passed it is autoboxed to Integer. 
        return Objects.hash(age, name);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // return super.clone();
        return new WithOverrided(name, age); // Does the same as super.clone() . We can implement deep copy if we have any nested references.
    }
}
