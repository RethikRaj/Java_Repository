public class ShallowCopyExampleTwo {
    public static void main(String[] args) {
        PersonWithString original = new PersonWithString("Rethik");
        PersonWithString shallowCopy = new PersonWithString(original);

        shallowCopy.name = "Raj"; // Since string is immutable -> creates a NEW String object, original untouched

        System.out.println(original.name);
        System.out.println(shallowCopy.name);

        PersonWithStringBuilder original2 = new PersonWithStringBuilder(new StringBuilder("Rethik"));
        PersonWithStringBuilder shallowCopy2 = new PersonWithStringBuilder(original2);

        shallowCopy2.name.append(" Raj"); // MUTATES the existing StringBuilder object

        System.out.println(original2.name);
        System.out.println(shallowCopy2.name);
    }
}

class PersonWithString {
    String name;

    PersonWithString(String name) {
        this.name = name;
    }

    // Shallow Copy Constructor
    PersonWithString(PersonWithString other) {
        this.name = other.name; // Strings are immutable, but this is still a reference copy
    }
}

class PersonWithStringBuilder {
    StringBuilder name;

    PersonWithStringBuilder(StringBuilder name) {
        this.name = name;
    }

    PersonWithStringBuilder(PersonWithStringBuilder other) {
        this.name = other.name;
    }
}
