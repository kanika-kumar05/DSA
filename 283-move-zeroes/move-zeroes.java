class Solution {
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        int index=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,i,j);
                index++;
                i++;
            }
        }
        while(index<nums.length){
            nums[index++]=0;
        }
        
    }
}