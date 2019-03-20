class Solution {
    public int romanToInt(String s) {
    	int res=0;
       	int i=0;
       	while(i<s.length()){
       		if(s.charAt(i)=='M'){
       			res+=1000;
       			i++;
       		}else if(s.charAt(i)=='D'){
       			res+=500;
       			i++;
       		}else if(s.charAt(i)=='C'){
       			if(i+1<s.length() && s.substring(i,i+2).equals("CD")){
       				res+=400;
       				i+=2;
       			}else if(i+1<s.length() && s.substring(i,i+2).equals("CM")){
       				res+=900;
       				i+=2;
       			}else{
       				res+=100;
       				i++;
       			}
       		}else if(s.charAt(i)=='L'){
       			res+=50;
       			i++;
       		}else if(s.charAt(i)=='X'){
       			if(i+1<s.length() && s.substring(i,i+2).equals("XL")){
       				res+=40;
       				i+=2;
       			}else if(i+1<s.length() && s.substring(i,i+2).equals("XC")){
       				res+=90;
       				i+=2;
       			}else{
       				res+=10;
       				i++;
       			}
       		}else if(s.charAt(i)=='V'){
       			res+=5;
       			i++;
       		}else{
       			if(i+1<s.length() && s.substring(i,i+2).equals("IV")){
       				res+=4;
       				i+=2;
       			}else if(i+1<s.length() && s.substring(i,i+2).equals("IX")){
       				res+=9;
       				i+=2;
       			}else{
       				res+=1;
       				i++;
       			}       		
       		}      		
       	}	
       	return res;
    }
}