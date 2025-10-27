import java.util.Arrays;
import java.util.Scanner;

public class HighSchoolPart {

    static double[] sort(int size, double[] array) {
        for (int i = 0; i < size - 1; i++) {
            int minVal = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minVal]) {
                    minVal = j;
                }
            }
            double temp = array[i];
            array[i] = array[minVal];
            array[minVal] = temp;
        }
        return array;
    }

    static double median(int size, double[] stat_arr) {
        if (size % 2 == 0) {
            return (stat_arr[size / 2 - 1] + stat_arr[size / 2]) / 2.0;
        } else {
            return stat_arr[size / 2];
        }
    }

    static double arith_mean(int size, double[] stat_arr) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += stat_arr[i];
        }
        return sum / size;
    }

    static double geo_mean(int size, double[] stat_arr) {
        double product = 1.0;
        for (int i = 0; i < size; i++) {
            product *= stat_arr[i];
        }
        return Math.pow(product, 1.0 / size);
    }

    static double formula(double[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return (1.0 / arr[index]) + formula(arr, index + 1);
    }

    static double harmonic_mean(int size, double[] stat_arr) {
        double sum = formula(stat_arr, 0);
        return size / sum;
    }

    static void stat_info_arr(Scanner user) {
        System.out.println("Enter the array size: ");
        int size = user.nextInt();
        double[] stat_arr = new double[size];
        int count = 1;
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the " + count + " number");
            stat_arr[i] = user.nextDouble();
            count++;
        }

        user.nextLine();

        sort(size, stat_arr);

        System.out.println("Median: " + median(size, stat_arr));
        System.out.println("Arithmetic mean: " + arith_mean(size, stat_arr));
        System.out.println("Geometric mean: " + geo_mean(size, stat_arr));
        System.out.println("Harmonic mean: " + harmonic_mean(size, stat_arr));
    }

    static double euclid_dist(int[] array1, int[] array2) {
        double sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += Math.pow(array1[i] - array2[i], 2);
        }
        return Math.sqrt(sum);
    }

    static int manhattan_dist(int[] array1, int[] array2) {
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += Math.abs(array1[i] - array2[i]);
        }
        return sum;
    }

    static double cos_similar(int[] array1, int[] array2) {
        double dotProduct = 0;
        double normA = 0;
        double normB = 0;

        for (int i = 0; i < array1.length; i++) {
            dotProduct += array1[i] * array2[i];
            normA += Math.pow(array1[i], 2);
            normB += Math.pow(array2[i], 2);
        }

        if (normA == 0 || normB == 0) {
            return 0.0;
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    static void dist_btwn_arr(Scanner user) {
        System.out.println("Enter the dimension: ");
        int dimension = user.nextInt();
        int[] array1 = new int[dimension];
        int[] array2 = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            System.out.println("Enter the " + (i + 1) + "st" + " element of the array 1: ");
            int number = user.nextInt();
            array1[i] = number;
        }
        for (int i = 0; i < dimension; i++) {
            System.out.println("Enter the " + (i + 1) + "st" + " element of the array 2: ");
            int number = user.nextInt();
            array2[i] = number;
        }

        user.nextLine();

        System.out.println("Manhattan distance: " + manhattan_dist(array1, array2));
        System.out.println("Euclidean distance: " + euclid_dist(array1, array2));
        System.out.println("Cosine similarity: " + cos_similar(array1, array2));

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    static void optionC(Scanner user) {
        boolean breaker = true;

        while (breaker) {
            System.out.println("\n[A] Statistical information about an Array");
            System.out.println("[B] Distance between Two Arrays");
            System.out.println("[C] Return to Main Menu");
            String input = user.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input! Please enter only a single character: A, B, or C.");
                continue;
            }
            char charinput = input.charAt(0);
            switch (charinput) {
                case 'A':
                    stat_info_arr(user);
                    break;
                case 'B':
                    dist_btwn_arr(user);
                    break;
                case 'C':
                    breaker = false;
                    break;
                default:
                    System.err.println("Invalid input! Please choose again.");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner user = new Scanner(System.in)) {
            optionC(user);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e);
        }
    }
}