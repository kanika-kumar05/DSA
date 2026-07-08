class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            //phle ki faaltu space htao
            while(i>=0 && s.charAt(i)==' ')i--;

            // if i<0 ho gya then beak
            if(i<0)break;

            //j ko set kro and add substring
            int j=i;
            while(j>=0 && s.charAt(j)!=' ')j--;

            sb.append(s.substring(j+1,i+1));

            // beech ke faaltu space htao
            while(j>=0 && s.charAt(j)==' ')j--;

            // ek space add kro between words
            if(j>=0) sb.append(' ');

            i=j;

        }
        return sb.toString();
    }
}