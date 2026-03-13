package p09_OOPS.p11_wrapper_classes;

public class WrapperClass {
    public static void main(String[] args) {
        // Integer i1 = new Integer(10); 

        Integer i2 = Integer.valueOf(10);
        Integer i3 = 20; // Autoboxing : 20(int) => 20(Integer)
        System.out.println(i2 + " " + i3);


        // Double d1 = new Double(20.001);
        Double d2 = Double.valueOf(20.001);
        Double d3 = 30.002; // Autoboxing : 30.002(double) => 30.002(Double)
        System.out.println(d2 + " " + d3);

    }
}
