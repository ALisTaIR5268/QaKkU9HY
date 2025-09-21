// 代码生成时间: 2025-09-22 01:34:50
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SortingService class provides methods for sorting an array of integers.
 * It uses Java's built-in sort method for simplicity and efficiency.
 */
public class SortingService {

    /**
     * Sorts the given array of integers in ascending order.
     * @param numbers The array of integers to be sorted.
     * @return A sorted array of integers.
     * @throws IllegalArgumentException If the input array is null.
     */
    public int[] sortAscending(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        return Arrays.copyOf(numbers, numbers.length); // Copy the array to avoid modifying the original array
    }

    /**
     * Sorts the given array of integers in descending order.
     * @param numbers The array of integers to be sorted.
     * @return A sorted array of integers.
     * @throws IllegalArgumentException If the input array is null.
     */
    public int[] sortDescending(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        }

        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        Collections.reverse(Arrays.asList(copy));
        return copy;
    }

    // Test the sorting methods
    public static void main(String[] args) {
        SortingService service = new SortingService();
        int[] numbers = {5, 2, 8, 3, 1, 6, 4};

        try {
            int[] ascendingSorted = service.sortAscending(numbers);
            System.out.println("Ascending sorted array: " + Arrays.toString(ascendingSorted));

            int[] descendingSorted = service.sortDescending(numbers);
            System.out.println("Descending sorted array: " + Arrays.toString(descendingSorted));

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}