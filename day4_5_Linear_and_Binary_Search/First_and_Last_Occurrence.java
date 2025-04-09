import java.util.Arrays;

public class First_and_Last_Occurrence {
    public static int[] findFirstAndLastOccurrence(int[] nums, int target) {
        int first = findOccurrence(nums, target, true);
        int last = findOccurrence(nums, target, false);
        return new int[]{first, last};
    }

    private static int findOccurrence(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println(Arrays.toString(findFirstAndLastOccurrence(nums, target)));
    }
}