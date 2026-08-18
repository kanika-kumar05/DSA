class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum=0,rSum=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            lSum+=cardPoints[i];
        }
        int maxSum=lSum;
        int rIndex=n-1;
        for(int i=k-1;i>=0;i--){
            lSum-=cardPoints[i];
            rSum+=cardPoints[rIndex];
            rIndex--;
            maxSum=Math.max(lSum+rSum,maxSum);
        }
        return maxSum;
    }
}