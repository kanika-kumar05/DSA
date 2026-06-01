class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] bucket=new List[nums.length+1];

        for(int num:hm.keySet()){
            int freq=hm.get(num);

            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] ans=new int[k];
        int index=0;

        for(int i=bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    ans[index]=num;
                    index++;

                    if(index==k){
                        break;
                    }
                }

            }
        }
        return ans;
    }
}