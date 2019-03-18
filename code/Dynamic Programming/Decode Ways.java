class Solution {

    public int numDecodings(String s) {
        if(s.length()==0){
        	return 0;
        }
        int[] num=new int[s.length()+1];
        num[0]=1;
        if(!s.substring(0,1).equals("0"))
        	num[1]=1;
        for(int i=2;i<=s.length();i++){
        	if(!s.substring(i-1,i).equals("0"))
        		num[i]=num[i-1];
        	if(s.substring(i-2,i).compareTo("26")<=0 && !s.substring(i-2,i-1).equals("0")){	// 注意compareTo和equals的使用
        		num[i]+=num[i-2];
        	}
        }
        return num[s.length()];

    }
}