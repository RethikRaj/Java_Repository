package p05_loops;

public class Loops {
    public static void main(String[] args) {
        // For loop
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int target = 12;
        int skipValue = 5;

        outerOne : for (int i = 0; i < 5; i++) {
            outerTwo : for (int j = 0; j < 5; j++) {
                outerThree : for (int k = 0; k < 5; k++) {
                    
                    int sum = i + j + k;

                    // Condition 1: If we hit a specific sum, stop processing this 'j' group entirely
                    if (sum == target) {
                        System.out.println("Target reached at i=" + i + ", j=" + j + ". Breaking outerTwo.");
                        break outerTwo; 
                    }

                    // Condition 2: If we hit a skip value, jump to the next 'i' increment
                    if (i == skipValue) {
                        System.out.println("Skip value found. Continuing outerOne.");
                        continue outerOne;
                    }
                    
                    System.out.println("Processing: i=" + i + " j=" + j + " k=" + k);
                }
            }
        }


        // While loop
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        // Do-while loop
        int j = 0;
        do {
            System.out.println(j);
            j++;
        } while (j < 5);
    }    
}
