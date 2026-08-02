class Solution {
    public void swap(int[] nums,int mid,int left){
        int temp=nums[mid];
        nums[mid]=nums[left];
        nums[left]=temp;
    }
    public void sortColors(int[] nums) {
        int left=0;
        int mid=0;
        int right=nums.length-1;
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,mid,left);
                left++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,right);
                right--;
            }
        }
    }
}