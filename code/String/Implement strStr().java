class Solution {
    public int strStr(String haystack, String needle) {
 		if(needle.isEmpty()){	// 判断“”
 			return 0;
 		}
 		int len=needle.length();
 		for(int i=0;i+len<=haystack.length();i++){
 			if(haystack.substring(i,i+len).equals(needle)){
 				return i;
 			}
 		}
 		return -1;

    }
}