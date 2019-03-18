class Solution {
    public int maxArea(int[] height) {
        int N=height.length;
        int i=0,j=N-1;
        int max_size=Math.min(height[0],height[N-1])*(N-1);
        while(i<j){
            if(height[i]<=height[j]){
                i++;
                max_size=Math.max(Math.min(height[i],height[j])*(j-i),max_size);
            }else{
                j--;
                max_size=Math.max(Math.min(height[i],height[j])*(j-i),max_size);
            }
        }
        return max_size;
    }
}