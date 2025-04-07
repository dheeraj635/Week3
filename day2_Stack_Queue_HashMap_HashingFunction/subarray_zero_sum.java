
import java.util.*;

public class subarray_zero_sum {
    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int cumulativeSum = 0;

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

           
            if (sumMap.containsKey(cumulativeSum)) {
                List<Integer> indices = sumMap.get(cumulativeSum);
                for (int index : indices) {
                    System.out.println("Subarray from index " + (index + 1) + " to " + i);
                }
            }

           
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findZeroSumSubarrays(arr);
        sc.close();
    }
}



