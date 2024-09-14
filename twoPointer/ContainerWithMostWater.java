package twoPointer;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            maxWater = Math.max(maxWater, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
