package binarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (target > nums[(i + j) / 2]) {
                i = ((i + j) / 2) + 1;
            } else if (target < nums[(i + j) / 2]) {
                j = ((i + j) / 2) - 1;
            } else {
                return (i + j) / 2;
            }
        }

        return -1;
    }
}
