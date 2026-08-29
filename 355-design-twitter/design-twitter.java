class Twitter {

    HashMap<Integer,HashSet<Integer>>following;
    HashMap<Integer,List<int[]>> tweets;
    int time;

    public Twitter() {
        following=new HashMap<>();
        tweets=new HashMap<>();
        time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId,time});
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((e1,e2)->{
            return e2[1]-e1[1];
        });

        if(tweets.containsKey(userId)){
            for(int[] tweet:tweets.get(userId)){
                pq.add(tweet);
            }
        }
        if(following.containsKey(userId)){
            for(int followee:following.get(userId)) {
                if(tweets.containsKey(followee)){
                    for(int[] tweet:tweets.get(followee)){
                        pq.add(tweet);
                    }
                }
            }
        }

        List<Integer> ans=new ArrayList<>();
        int count=0;
        while(!pq.isEmpty() && count<10){
            int[] tweet=pq.poll();
            ans.add(tweet[0]);
            count++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId,new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */