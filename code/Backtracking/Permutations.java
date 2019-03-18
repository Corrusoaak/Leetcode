class Solution {

    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permutation=new ArrayList<>();
        List<Integer> first_nums=new ArrayList<>();
        for(int i:nums){
            first_nums.add(i);
        }
        findPermutation(permutation,first_nums);
        return res;
    }

    private void findPermutation(List<Integer> permutation,List<Integer> nums){
        if(nums.size()==0){
            res.add(permutation);
        }
        for(int i=0;i<nums.size();i++){
            List<Integer> next_permutation=new ArrayList<>();
            List<Integer> next_nums=new ArrayList<>();
            next_permutation.addAll(permutation);
            next_permutation.add(nums.get(i));
            next_nums.addAll(nums);
            next_nums.remove(nums.get(i));
            findPermutation(next_permutation,next_nums);
        }
    }

}