package p03_operators;

public class BitwiseShift {

    public static void BitwsieLeftShift() {
        // Left shift 
        // Example 1
        byte b = -2;
        b = (byte) (b << 1); 
        System.out.println(b);
        b = (byte) (b << 6);
        System.out.println(b);

        // Example 2
        byte b2 = -2;
        b2 = (byte) (b2 << 1); 
        System.out.println(b2);
        int i =  (b2 << 6); 
        System.out.println(i);

        // Example 3:
        int j = 1;
        j = j << 31;
        System.out.println(j);
        j = j << 1;
        System.out.println(j);

        // Example 4:
        int z = 1;
        z = z << 33; //=> z << (33 % 32) => z << 1
        System.out.println(z);
    }


    
    public static void main(String[] args) {
        

    }
}
