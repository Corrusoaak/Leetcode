
// Horizontal Scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index=0;
        if(strs.length==0){
        	return "";
        }
        while(true){
        	char letter='a';	// 不能初始化为空
        	for(int j=0;j<strs.length;j++){
        		if(index>=strs[j].length()){
        			return strs[j].substring(0,index);	// 即使字符串为空也可以这样写substring(0,0)
        		}	
        		if(j==0){
        			letter=strs[j].charAt(index);
        		}else{
        			if(letter!=strs[j].charAt(index)){
        				return strs[j].substring(0,index);
        			}
        		}
        	}
        	index++;
        }
    }
}


// Divide And Conquer :: Time Complexity:O(S)   Space Complexity:O(M*log(N))
class Solution{
	public String longestCommonPrefix(String[] strs){
		if(strs.length==0){
			return "";
		}
		return divideAndConquer(strs,0,strs.length-1);
	}

	private String divideAndConquer(String[] strs,int begin,int end){
		if(begin==end){
			return strs[begin];
		}
		int mid=(begin+end)/2;
		String left=divideAndConquer(strs,begin,mid);
		String right=divideAndConquer(strs,mid,end);
		return commonPrefix(left,right);
	}
	private String commonPrefix(String left,String right){
		int index=0;
		while(index<left.length() && index<right.length()){
			if(left.charAt(index)!=right.charAt(index)){
				break;
			}
			index++;
		}
		return left.length()<right.length()?left.substring(0,index):right.substring(0,index);
	}

}