class Solution {
    public int myAtoi(String str) {
        String s=str.trim();
        if(s.isEmpty()){
            return 0;
        }
        int res=0;
        boolean is_neg=false;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            if(s.charAt(0)=='-'){
                is_neg=!is_neg;
            }
            res=findNum(s.substring(1),is_neg);
        }else{
            res=findNum(s,is_neg);
        }
        return res;
    }
    private int findNum(String s,boolean is_neg){
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int digit=s.charAt(i)-'0';
                if((!is_neg && (Integer.MAX_VALUE-digit)*1.0/10>=res) || (is_neg && (digit==0 && (Integer.MAX_VALUE-digit)*1.0/10>=res|| digit>0 && (Integer.MAX_VALUE-digit+1)*1.0/10>=res))){
                    res=res*10+digit;
                }else{
                    return is_neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }
        return is_neg?-res:res;
    }
    
}