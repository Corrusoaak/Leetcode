class Solution {
    
	List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
    	if(s.isEmpty())return res;
        findPalindrome(new ArrayList<String>(),s,0);
        return res;
    }
    // find all palindromes started at the i-th index of string
    private void findPalindrome(List<String> cur, String s, int index){
    	if(index>=s.length()){
    		res.add(cur);
    		return;
    	}
    	for(int i=index;i<=s.length();i++){
    		if(isPalindrome(s.substring(index,i))){
    			List<String> new_list=new ArrayList<>();
    			new_list.addAll(cur);
    			new_list.add(s.substring(index,i));
    			findPalindrome(new_list,s,i);
    		}
    	}
    }
    private boolean isPalindrome(String s){
    	if(s.isEmpty())return false;
    	int left=0,right=s.length()-1;
    	while(left<=right){
    		if(s.charAt(left++)!=s.charAt(right--))return false;
    	}
    	return true;
    }
}