class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int n=s.length();
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(r<n){
            char ch=s.charAt(r);

            if(map.containsKey(ch)){
                l=Math.max(l,map.get(ch)+1);
            }
            map.put(ch,r);
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}