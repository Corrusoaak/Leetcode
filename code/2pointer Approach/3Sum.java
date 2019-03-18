class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        int last_num=nums[0];
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){  // 避免重复
                continue;
            }
            int j=i+1,k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    List<Integer> sum_com=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    res.add(sum_com);                  
                    do{
                        j++;
                    }while(nums[j]==nums[j-1] && j<k);  // 避免重复
                }
            }
            last_num=nums[i];
        }
        return res;
    }
}