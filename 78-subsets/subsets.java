class Solution {
    public void solve(int index, int[] nums, List<List<Integer>> arr, List<Integer> current){
        if(index==nums.length){
            arr.add(new ArrayList<>(current));
            return;
        }
        solve(index+1,nums,arr,current);
        current.add(nums[index]);
        solve(index+1,nums,arr,current);
        current.remove(current.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        solve(0,nums,arr,new ArrayList<>());
        return arr;
    }
}