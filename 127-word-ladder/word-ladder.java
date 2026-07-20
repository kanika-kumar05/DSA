class Pair{
    String word;
    int time;
    Pair(String word,int time){
        this.word=word;
        this.time=time;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair>q=new LinkedList<>();
        HashSet<String> hs=new HashSet<String>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        hs.remove(beginWord);
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            String word=q.peek().word;
            int time=q.peek().time;
            q.remove();
            if(word.equals(endWord)==true)return time;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedArray=word.toCharArray();
                    replacedArray[i]=ch;
                    String replacedWord=new String(replacedArray);

                    // if it exists in set
                    if(hs.contains(replacedWord)==true){
                        q.add(new Pair(replacedWord,time+1));
                        hs.remove(replacedWord);
                    }
                    
                }
            }
        }
        return 0;
    }
}