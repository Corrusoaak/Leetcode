class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;
        int res=nums[0],last1=nums[0],last2=nums[0];
        for(int i=1;i<nums.length;i++){
        	last1*=nums[i];
        	last2*=nums[i];
        	int tmp1=Math.max(Math.max(last1,last2),nums[i]);
        	int tmp2=Math.min(Math.min(last1,last2),nums[i]);
        	last1=tmp1;
        	last2=tmp2;
        	if(tmp1>res)res=tmp1;
        }
        return res;
    }
}