class Solution {
    
	List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
    	if(n!=0){
    		backTrack("",n,n);	
    	}
    	return res;
        
    }
    private void backTrack(String solution, int rest_left, int rest_right){
    	if(rest_left==0 && rest_right==0){
    		res.add(solution);
    	}
    	if(rest_left>rest_right || rest_left<0 || rest_right<0){
    		return;
    	}
    	backTrack(solution+"(",rest_left-1,rest_right);
    	backTrack(solution+")",rest_left,rest_right-1);
    }

}