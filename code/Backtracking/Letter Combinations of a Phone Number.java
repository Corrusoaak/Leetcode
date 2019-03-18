class Solution {

	List<String> res=new ArrayList<>();
	Map<String,String> num2letter=new HashMap<String,String>(){{
		put("2","abc");
		put("3","def");
		put("4","ghi");
		put("5","jkl");
		put("6","mno");	// 用String操作最好
		put("7","pqrs");
		put("8","tuv");
		put("9","wxyz");
	}};	// 注意打分号

    public List<String> letterCombinations(String digits) {
        if(!digits.isEmpty()){
        	backtrack("",digits);
        }
        return res;
    }

    private void backtrack(String solution,String digits){
    	if(digits.isEmpty()){
    		res.add(solution);
    		return;
    	}
    	String next_digits=digits.substring(1);
    	String letters=num2letter.get(digits.substring(0,1));	// 替代了digits.charAt
    	for(int i=0;i<letters.length();i++){
    		backtrack(solution+letters.substring(i,i+1),next_digits);
    	}

    }


}
