class Solution {
    public int findPeakElement(int[] nums) {
        int a=0,b=nums.length-1;
        while(a<b){
        	int c=(a+b)/2;
        	if(nums[c]>nums[c+1]){
        		b=c;
        	}else{
        		a=c+1;
        	}
        }
        return a;
    }
}