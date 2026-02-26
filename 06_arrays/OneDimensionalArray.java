public class OneDimensionalArray {
    public static void main(String[] args) {
        int[] rollNumbers; // Declaring
        // rollNumbers[0] = 10; // Error
        rollNumbers = new int[3]; // Definiton , new keyword allocates memory in heap
        // initialization
        rollNumbers[0] = 101;
        rollNumbers[1] = 102;
        rollNumbers[2] = 103;

        for(int i = 0; i < rollNumbers.length; i++) { // length is a property of array
            System.out.println(rollNumbers[i]);
        }

        for( int rollNumber : rollNumbers) {
            System.out.println(rollNumber);
        }

        System.out.println(rollNumbers); // [I@24d46ca6
        // [ -> array
        // I -> integer
        // @ -> separator
        // 24d46ca6 -> the object's hashcode in hex (memory address-ish)
    }
}
