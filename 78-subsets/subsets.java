class Solution {
    public void solve(int index,List<Integer> current,List<List<Integer>> sb, int[] nums){
        if(index==nums.length){
            sb.add(new ArrayList<>(current));
            return;
        }
        solve(index+1,current,sb,nums);
        current.add(nums[index]);
        solve(index+1,current,sb,nums);
        current.remove(current.size()-1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sb=new ArrayList<>();
        solve(0,new ArrayList<>(),sb,nums);
        return sb;

    }
}   