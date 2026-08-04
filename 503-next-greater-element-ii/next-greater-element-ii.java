class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        List<ArrayList> arr=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--){
            if(st.isEmpty()){
                res[i%n]=-1;
                st.push(nums[i%n]);
            }
            else{
                while(!st.isEmpty() && st.peek()<=nums[i%n]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i%n]=st.peek();
                }
                else{
                    res[i%n]=-1;
                }
                st.push(nums[i%n]);
            }
        }
        return res;
    }
}