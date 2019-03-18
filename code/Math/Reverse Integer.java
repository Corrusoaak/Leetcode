class Solution {
    public int reverse(int x) {
        int res=0;

        boolean is_neg=false;
        if(x<0){
            x=-x;
            is_neg=true;
        }
        while(x!=0){ 
            int digit=x%10;
            if((!is_neg && (Integer.MAX_VALUE-digit)*1.0/10>=res) || (is_neg && (digit==0 && (Integer.MAX_VALUE-digit)*1.0/10>=res|| digit>0 && (Integer.MAX_VALUE-digit+1)*1.0/10>=res))){
                res=res*10+digit;
            }else{
                return 0;
            }
            x=x/10;
        }
        if(is_neg){
            res=-res;
        }
        return res;
    }
}