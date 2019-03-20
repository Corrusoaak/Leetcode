class Solution {
    public void sortColors(int[] nums) {
        int wi=-1,bi=-1;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
				if(wi!=-1 && bi==-1){
        			nums[wi++]=0;
        			nums[i]=1;
        		}else if(wi==-1 && bi!=-1){
        			nums[bi++]=0;
        			nums[i]=2;
        		}else if(wi!=-1 && bi!=-1){
        			nums[wi++]=0;
        			nums[bi++]=1;
        			nums[i]=2;
        		}
        	}else if(nums[i]==1){
        		if(bi!=-1){
        			if(wi==-1){
        				wi=bi;
        			}
        			nums[bi++]=1;
        			nums[i]=2;
        		}
        		if(wi==-1){
        			wi=i;
        		}
        	}else{
        		if(bi==-1){
        			bi=i;
        		}
        	}

        }
    }
}