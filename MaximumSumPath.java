import java.util.Scanner;

public class MaximumSumPath {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for array X
        System.out.println("Enter the size of array X:");
        int sizeX = scanner.nextInt();
        int[] X = new int[sizeX];
        System.out.println("Enter the elements of array X:");
        for (int i = 0; i < sizeX; i++) {
            X[i] = scanner.nextInt();
        }

        // Input for array Y
        System.out.println("Enter the size of array Y:");
        int sizeY = scanner.nextInt();
        int[] Y = new int[sizeY];
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < sizeY; i++) {
            Y[i] = scanner.nextInt();
        }

        // Calculate the maximum sum path
        int maximumSum = maxSumPath(X, Y);
        System.out.println("The maximum sum path is: " + maximumSum);
    }

    public static int maxSumPath(int[] X, int[] Y) {
        int sumX = 0, sumY = 0;
        int result = 0, i = 0, j = 0;

        while (i < X.length && j < Y.length) {
            // Add elements of X[] and Y[] to their respective sum variables
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                // Common element found, pick the maximum sum path up to this point
                result += Math.max(sumX, sumY) + X[i];
                sumX = sumY = 0; // Reset the sums for the next common element
                i++; j++;
            }
        }

        // Add remaining elements of X[]
        while (i < X.length) {
            sumX += X[i++];
        }
        // Add remaining elements of Y[]
        while (j < Y.length) {
            sumY += Y[j++];
        }

        // Add the maximum of remaining sums to the result
        result += Math.max(sumX, sumY);
        return result;
    }
}