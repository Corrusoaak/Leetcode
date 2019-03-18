class Solution {
    public int search(int[] nums, int target) {
        int length=nums.length;
        if(length==0){
            return -1;
        }
        if(length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
        int a=0,b=length-1;
        while(b-a>1){
            int c=(a+b)/2;
            if(nums[c]==target){
                return c;
            }
            if(nums[a]<nums[b]){
                if(nums[c]>target){
                    b=c;
                }else{
                    a=c;
                }
            }else{
                if(nums[c]>nums[a]){
                    if(nums[a]<=target && target<nums[c]){
                        b=c;
                    }else{
                        a=c;
                    }
                }else{
                    if(nums[c]<target && target<=nums[b]){
                        a=c;
                    }else{
                        b=c;
                    }
                }
            }
        }
        if(nums[a]==target){
            return a;
        }
        if(nums[b]==target){
            return b;
        }
        return -1;
    }
}
