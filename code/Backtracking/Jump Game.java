// Backtacking
class Solution {
    public boolean canJump(int[] nums) {
    	return canJumpPostionI(0,nums);
    }
    private boolean canJumpPostionI(int pos,int[] nums){
    	if(pos>=nums.length-1){
    		return true;
    	}

    	int furtherst_pos=pos+nums[pos];

    	for(int i=pos+1;i<=furtherst_pos;i++){
    		if(canJumpPostionI(i,nums)){
    			return true;
    		}
    	}
    	return false;
    }
}

// Dynampic Programming Top-Down
enum Index{
	GOOD, BAD, UNKNOWN
};
class Solution {
	Index[] memo;

    public boolean canJump(int[] nums) {
    	memo=new Index[nums.length];
    	memo[nums.length-1]=Index.GOOD;
    	for(int i=0;i<nums.length-1;i++){
    		memo[i]=Index.UNKNOWN;
    	}
    	return canJumpPositionI(0,nums);

    }
    private boolean canJumpPositionI(int pos,int[] nums){
		if(memo[pos]!=Index.UNKNOWN){
			return memo[pos]==Index.GOOD?true:false;
		}
    	int furtherst_pos=Math.min(pos+nums[pos],nums.length-1);
    	for(int i=pos+1;i<=furtherst_pos;i++){
    		if(canJumpPositionI(i,nums)){
    			memo[pos]=Index.GOOD;
    			return true;
    		}
    	}
    	memo[pos]=Index.BAD;
    	return false;

    }
}

// Dynamic Programming Bottom-Up

class Solution {
    public boolean canJump(int[] nums) {
    	boolean[] memo=new boolean[nums.length];
    	memo[nums.length-1]=true;
    	for(int i=nums.length-1;i>=0;i--){
    		int furthest_pos=Math.min(i+nums[i],nums.length-1);
    		for(int j=i+1;j<=furthest_pos;j++){
    			if(memo[j]){
    				memo[i]=true;
    				break;
    			}
    		}
    	}
    	return memo[0];
    }
}

// Greedy 
class Solution {
    public boolean canJump(int[] nums) {
    	int pos=nums.length-1;
    	for(int i=nums.length-1;i>=0;i--){
    		if(i+nums[i]>=pos){
    			pos=i;
    		}
    	}
    	return pos==0;
    }
}