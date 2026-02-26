public class TwoDimensionalArray {
    public static void main(String[] args) {
        // int[][] studentMarks = new int[3][4];

        // Jagged Arrays
        // int[][] studentMarks = new int[3][];
        // studentMarks[0] = new int[4];
        // studentMarks[1] = new int[3];
        // studentMarks[2] = new int[2];


        int[][] studentMarks = {{10,20,30,40}, {50,60,70}, {0,100}}; // Jagged array

        for(int i = 0; i < studentMarks.length; i++) {
            for (int j = 0; j < studentMarks[i].length; j++) {
                System.out.println(studentMarks[i][j]);
            }
        }

        System.out.println(studentMarks);
        System.out.println(studentMarks[0]);
        System.out.println(studentMarks[1]);
    }
}
