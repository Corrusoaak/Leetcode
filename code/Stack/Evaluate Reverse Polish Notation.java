class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>();
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*")|| tokens[i].equals("/")){
        		int num1=nums.pop();
        		int num2=nums.pop();
        		if(tokens[i].equals("+")){
        			nums.push(num1+num2);
        		}else if(tokens[i].equals("-")){
        			nums.push(num1-num2);
        		}else if(tokens[i].equals("*")){
        			nums.push(num1*num2);
        		}else{
        			if(num2==0)return 0;
        			nums.push(num1/num2);
        		}
        	}else{
        		nums.push(new Integer(tokens[i]));	// 注意怎么转Integer

        	}
        }
        return nums.pop();
    }
}