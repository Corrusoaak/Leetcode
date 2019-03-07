class Solution {
    public void nextPermutation(int[] nums) {
        int length=nums.length;
        int index=0;
        for(int i=length-1;i>=1;i--){
            if(nums[i-1]<nums[i]){
                for(int j=i-1;j<length;j++){
                    if(j+1==length || nums[j+1]<=nums[i-1] ){
                        int tmp=nums[j];
                        nums[j]=nums[i-1];
                        nums[i-1]=tmp;
                        break;
                    }
                }
                index=i;
                break;

            }
        }

        for(int i=index;i<(length+index-1)*1.0/2 ;i++){
            int tmp=nums[i];
            nums[i]=nums[length+index-1-i];
            nums[length+index-1-i]=tmp;
        }

    }
}
