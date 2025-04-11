import java.util.Arrays;
import java.util.Random;

public class SearchTargetInLargeDataset {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = -1; 

        for (int size : datasetSizes) {
            int[] data = generateDataset(size);

            
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            System.out.println("Linear Search on dataset size " + size + ": " + (endTime - startTime) / 1_000_000.0 + " ms");

            
            Arrays.sort(data); 
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            System.out.println("Binary Search on dataset size " + size + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        }
    }

    
    private static int[] generateDataset(int size) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size * 10); 
        }
        return data;
    }

    
    private static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    private static int binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }
}
