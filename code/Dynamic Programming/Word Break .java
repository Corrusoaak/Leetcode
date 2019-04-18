
// Top-Down
class Solution {

	enum Index{
		GOOD,BAD,UNKNOWN
	};
	Index[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo=new Index[s.length()+1];
        for(int i=0;i<s.length();i++){
        	memo[i]=Index.UNKNOWN;
        }
        memo[s.length()]=Index.GOOD;	// The last one needs to be set!
        return isWordBreak(s,0,wordDict);
    }
    
    private boolean isWordBreak(String s, int index, List<String> wordDict){
    	// First check the memo 
    	if(memo[index]!=Index.UNKNOWN){
    		return memo[index]==Index.GOOD?true:false;
    	}
    	for(int i=0;i<wordDict.size();i++){
    		String word=wordDict.get(i);
    		if(index+word.length()<=s.length() && s.substring(index,index+word.length()).equals(word)){
    			if(isWordBreak(s,index+word.length(),wordDict)){	// In function update the memo
    				memo[index]=Index.GOOD;
    				return true;
    			}
    		}
    	}
    	memo[index]=Index.BAD;
    	return false;
    } 
}

// Bottom-Up

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo=new boolean[s.length()+1];
        memo[0]=true;	// The first one needs to be set!
        for(int i=0;i<s.length()+1;i++){
        	for(int j=0;j<i;j++){
        		if(memo[j] && wordDict.contains(s.substring(j,i))){
        			memo[i]=true;
        			continue;
        		}
        	}
        }
        return memo[s.length()];
    }
}




