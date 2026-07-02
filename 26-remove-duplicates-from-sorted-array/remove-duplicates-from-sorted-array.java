class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]!=nums[i]){
                nums[i+1]=nums[j];
                i++;
                k++;
            }
            j++;
        }
        return k;
    }
}