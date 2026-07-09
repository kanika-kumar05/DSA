class Solution {
    public int romanToInt(String s) {
        int[] values=new int[26];
        values['I'-'A']=1;
        values['V'-'A']=5;
        values['X'-'A']=10;
        values['L'-'A']=50;
        values['C'-'A']=100;
        values['D'-'A']=500;
        values['M'-'A']=1000;
        
        int fValue=0,preValue=0;
        for(int i=s.length()-1;i>=0;i--){
            int value=values[s.charAt(i)-'A'];
            if(value<preValue){
                fValue-=value;
            }
            else{
                fValue+=value;
            }
            preValue=value;
        }
        return fValue;

    }
}