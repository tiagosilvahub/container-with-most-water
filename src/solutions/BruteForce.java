package src.solutions;

public class BruteForce implements Solution {
    @Override
    public int solve(int[] height) {
        int max = 0;
        int area;
        for (int i = 0; i < height.length -1; i++) {
            for (int j = i+1; j < height.length; j++) {
                area = Math.min(height[i], height[j]) * (j-i);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
