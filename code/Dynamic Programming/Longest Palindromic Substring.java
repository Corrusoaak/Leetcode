
class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()){
            return s;
        }
        int start=0,end=0;
        int max_len=0;
        for(int i=0;i<s.length();i++){
            int len1=findMaxLength(s,i,i);
            int len2=findMaxLength(s,i,i+1);

            int len=Math.max(len1,len2);
            if(len>max_len){
                start=i-(len-1)/2;
                end=i+len/2;
                max_len=len;
            }

        }
        return s.substring(start,end+1);


    }
    private int findMaxLength(String str,int start, int end){
        while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)){
            start--;
            end++;
        }
        return end-start+1-2;
    }
}
