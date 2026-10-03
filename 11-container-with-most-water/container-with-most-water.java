class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int max=Integer.MIN_VALUE;


        while(left<right){
            int h=Math.min(height[left],height[right]);
            int width=right-left;
            int area=h*width;

            max=Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            }
            else right--;
        }
        return max;
    }
}