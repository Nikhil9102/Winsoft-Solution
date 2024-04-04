import java.util.Scanner;

public class MergeSortedArraysInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for size of array X (including vacant cells) and Y
        System.out.println("Enter the total size of array X (including vacant spaces):");
        int sizeX = scanner.nextInt();
        System.out.println("Enter the number of non-vacant elements in array X:");
        int m = scanner.nextInt(); // Non-vacant elements in X[]
        System.out.println("Enter the size of array Y:");
        int n = scanner.nextInt(); // Size of Y[]

        int[] X = new int[sizeX];
        int[] Y = new int[n];

        // Input for elements of array X (assuming 0 as vacant)
        System.out.println("Enter the elements of array X (use 0 for vacant spaces):");
        for (int i = 0; i < m; i++) { // Only taking m inputs for non-vacant elements
            X[i] = scanner.nextInt();
        }

        // Input for elements of array Y
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        // Moving non-vacant elements of X[] to the end and merging Y[] into X[]
        moveToEnd(X, m + n);
        merge(X, Y, m, n);

        // Printing the merged array
        System.out.println("Merged array:");
        for (int i = 0; i < sizeX; i++) {
            System.out.print(X[i] + " ");
        }
    }

    public static void moveToEnd(int[] X, int size) {
        int j = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[j] = X[i];
                if (j != i) {
                    X[i] = 0; // Mark as vacant
                }
                j--;
            }
        }
    }

    public static void merge(int[] X, int[] Y, int m, int n) {
        int i = n; // Index for non-vacant elements of X
        int j = 0; // Index for elements of Y
        int k = 0; // Index to start inserting in X

        while (j < n && i < m + n) {
            if (i >= m + n || Y[j] < X[i]) {
                X[k++] = Y[j++];
            } else {
                X[k++] = X[i++];
            }
        }

        // No need to insert remaining X[i] elements as they are already in place
    }
}