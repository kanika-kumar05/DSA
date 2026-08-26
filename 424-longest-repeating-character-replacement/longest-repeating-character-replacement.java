class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxLen=0,maxFreq=0;
        int n=s.length();
        int[] hash=new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,hash[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                maxFreq=0;
                for(int i=0;i<26;i++){
                    maxFreq=Math.max(maxFreq,hash[i]);
                    
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;

        }
        return maxLen;
    }
}