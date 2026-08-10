class Solution {
    public int trap(int[] height) {
        // we'll use a left and right pointer
        // starting leftMax height is height[l], and height[r] for right
        // find which max height is smaller (left or right)
        // iterate pointer for smaller max
        // find new max height
        // add maxheight - current height to result
        // keep doing this until u get to end
        if (height == null || height.length == 0){
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        
        while (l < r){
            if (leftMax < rightMax){
                l++; // iterate to find a new height
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
    return res;
    }
}
