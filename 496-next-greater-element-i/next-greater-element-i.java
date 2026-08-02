class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        int i=nums2.length-1;
        while(i>=0){
            if(st.isEmpty()){
                hm.put(nums2[i],-1);
                st.push(nums2[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()<=nums2[i]){
                    st.pop();

                }
                if(!st.isEmpty())hm.put(nums2[i],st.peek());
                else hm.put(nums2[i],-1);
                
            }
            st.push(nums2[i]);
            i--;
            
        }
        int[] res=new int[nums1.length];
        for(int j=0;j<nums1.length;j++){
            if(hm.containsKey(nums1[j])){
                res[j]=hm.get(nums1[j]);
            }
            else{
                res[j]=-1;
            }
        }
        return res;
    }
}