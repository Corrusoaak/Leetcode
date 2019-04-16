class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res=0,sum=0;
        int i=res;
        while(res<gas.length){
        	sum+=(gas[i%gas.length]-cost[i%gas.length]);
        	if(sum<0){
        		res=i+1;
        		i=res;
        		sum=0;
        	}else{
        		i++;
        	}
        	if(i-res>=gas.length){
        		return res;
        	}
        }
        return -1;
    }
}