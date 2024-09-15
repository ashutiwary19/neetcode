package twoPointer;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] rMax = new int[height.length];
        int[] lMax = new int[height.length];
        rMax[height.length - 1] = height[height.length - 1];
        lMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
            rMax[height.length - 1 - i] = Math.max(height[height.length - 1 - i], rMax[height.length - i]);
        }

        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return water;
    }
}
