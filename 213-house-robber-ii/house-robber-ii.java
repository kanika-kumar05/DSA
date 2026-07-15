class Solution {
    public static int find(ArrayList<Integer> nums){
        int n=nums.size();
        int prev=nums.get(0);
        int prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums.get(i)+prev2;
            int notPick=0+prev;
            int curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        ArrayList<Integer> temp1=new ArrayList<>();
        ArrayList<Integer> temp2=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i!=0)temp1.add(nums[i]);
            if(i!=n-1)temp2.add(nums[i]);
        }
        return Math.max(find(temp1),find(temp2));
    }
}