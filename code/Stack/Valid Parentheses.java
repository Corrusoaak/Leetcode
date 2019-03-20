class Solution {
    public boolean isValid(String s) {
    	List<Character> list=new ArrayList<>();
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if(c=='(' || c=='[' || c=='{'){
    			list.add(c);
    		}else {
    			if(list.size()==0){
    				return false;
    			}
    			char p=list.get(list.size()-1);
    			if((c==')' && p=='(') || (c==']' && p=='[') || (c=='}' && p=='{')){
    				list.remove(list.size()-1);
    			}else{
    				return false;
    			}

    		}
    	}
    	return list.isEmpty();
    }
}