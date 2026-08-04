class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            // destroying condition
            while(!st.isEmpty() && asteroid<0 && st.peek()>0){
                if(st.peek()<Math.abs(asteroid)){
                    st.pop();
                    continue;
                }
                if(st.peek()==Math.abs(asteroid)){
                    st.pop();
                    destroyed=true;
                    break;
                }
                else{
                    destroyed=true;
                    break;  
                }
            }
            if(!destroyed){
                st.push(asteroid);
            }
        }
        int[] arr=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}