# container-with-most-water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

https://leetcode.com/problems/container-with-most-water/

First thoughts.
The smaller bar defines the height, the x axis (j - i) defines the length.
Based on the image, we don't have to worry about if the bars in the middle are higher or not. 

Let's try brute forcing. For all combinations of 2 bars, calculate the area and store the max. Fairly simple, just have to think about the starting and end of the for loops (off byu 1 errors):

```
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
```

Let's think about what are we doing ineficiently. Without knowing the heights, we would guess that the bars at the start and end are the best candidates to make the biggest area. Most likely the optimal solution would start by considering the first and last bars. 

Let's say we consider the first and last bar. What would be more optimal to try next? If one of the bars is higher than the other, than we have potencial to get more area by changing the small bar into another that could be higher. 

If we continued like this, we would not try all combinations. But let's think about the cases we would miss. They could only have less area because the tallest so far we have fixed and the smaller ones we skipped. 

This allows us to find the furthest tall bar from the current tall bar we are keeping. If the bar we selected on the right is the tallest, it can form no containers where the water reaches it's top, which means we will move the left pointer the rest of the way, and have calculated all areas that could possibly be maximums. So we are guaranteed to do only O(n) calculations and to find the max area.

```
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
```
