class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int maxCount=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')count++;
            else if(s.charAt(i)==')'){
                maxCount=Math.max(count,maxCount);
                count--;
            }
        }
        // maxCount=Math.max(count,maxCount);
        return maxCount;
    }
}