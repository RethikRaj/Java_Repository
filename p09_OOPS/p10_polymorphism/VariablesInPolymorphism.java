package p09_OOPS.p10_polymorphism;

public class VariablesInPolymorphism {
    public static void main(String[] args) {
        G g = new H();
        System.out.println(g.x); // 10
    }
}

class G {
    int x = 10;
}

class H extends G {
    int x = 20;
}
