// Divide and Conquer O(NlogN) O(logN)
class Solution {
    public int maxSubArray(int[] nums) {
        return DAC(nums,0,nums.length-1);
    }
    private int DAC(int[] nums, int begin, int end){
        if(begin==end){
            return nums[begin];
        }
        int mid=(begin+end)/2;
        int left=DAC(nums,begin,mid);
        int right=DAC(nums,mid+1,end);
        int max_left_mid=nums[mid],left_mid=0;
        for(int i=mid;i>=begin;i--){
            left_mid+=nums[i];
            max_left_mid=Math.max(max_left_mid,left_mid);
        }
        int max_right_mid=nums[mid+1],right_mid=0;
        for(int i=mid+1;i<=end;i++){
            right_mid+=nums[i];
            max_right_mid=Math.max(max_right_mid,right_mid);
        }
        return Math.max(Math.max(left,right),max_left_mid+max_right_mid);
    }
}
// Dynamic Programming O(N) O(1)
class Solution {
    public int maxSubArray(int[] nums) {
    	int dp=0,res=nums[0];
    	for(int i=0;i<nums.length;i++){
    		dp=Math.max(0,dp)+nums[i];
    		res=Math.max(res,dp);
    	}
    	return res;
    }

}
