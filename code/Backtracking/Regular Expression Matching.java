class Solution {
    public boolean isMatch(String s, String p) {
        return backTracking(s,0,p,0);
    }
    private boolean backTracking(String s, int si, String p, int pi){
    	if(si>=s.length() && pi>=p.length()){
    		return true;
    	}
    	if(si<s.length() && pi>=p.length()){
    		return false;
    	}
    	if(pi+1<p.length() && p.charAt(pi+1)=='*'){
    		if(backTracking(s,si,p,pi+2)){	// No Matching
    			return true;
    		}
    		int i=si;
    		while(i<s.length() && (p.charAt(pi)=='.' || s.charAt(i)==p.charAt(pi))){
    			if(backTracking(s,i+1,p,pi+2)){	// Matching partial String
    				return true;
    			}
    			i++;
    		}
    	}else{
    		if(si<s.length() && (p.charAt(pi)=='.' || s.charAt(si)==p.charAt(pi))){
    			return backTracking(s,si+1,p,pi+1);		// Matching One
    		}else{
    			return false;
    		}
    	}
    	return false;
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
    	boolean[][] memo=new boolean[s.length()][p.length()];
    	memo[0][0]=true;
    	for(int i=0;i<s.length();i++){
    		for(int j=0;j<p.length();j++){
    			
    		}
    	}

        return backTracking(s,0,p,0);
    }

    
}

