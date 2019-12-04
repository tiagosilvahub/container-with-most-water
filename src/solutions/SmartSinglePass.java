package src.solutions;

public class SmartSinglePass implements Solution {
    @Override
    public int solve(int[] height) {
        int max = 0;
        int area;
        int i = 0;
        int j = height.length -1;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(max, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
