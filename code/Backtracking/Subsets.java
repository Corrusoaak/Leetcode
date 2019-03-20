class Solution {
	List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(new ArrayList<Integer>(),nums,0);
        return res;
    }

    void backTracking(List<Integer> list, int[] nums, int index){
    	if(index==nums.length){
    		res.add(list);
    		return;
    	}
    	
    	backTracking(list,nums,index+1);
    	List<Integer> new_list=new ArrayList<>(list);
    	new_list.add(nums[index]);
    	backTracking(new_list,nums,index+1);

    }
}