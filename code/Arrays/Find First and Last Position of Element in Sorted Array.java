class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int length=nums.length;

        int a=0,b=length-1;
        while(b>a){
            int c=(b+a)/2;
            if(nums[c]>=target){
                b=c;
            }else{
                a=c+1;
            }
        }
        if(a<length && nums[a]==target) {
            res[0] = a;
        }
        a=0;
        b=length-1;

        while(b>a){
            int c=(b+a)/2+1;
            if(nums[c]<=target){
                a=c;
            }else{
                b=c-1;
            }
        }
        if(a<length && nums[a]==target){
            res[1]=a;
        }
        return res;
    }
}
