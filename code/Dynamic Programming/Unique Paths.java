class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] num_path=new int[m][n];
        for(int i=0;i<m;i++){
        	num_path[i][0]=1;
        }
        for(int i=0;i<n;i++){
        	num_path[0][i]=1;
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		num_path[i][j]=num_path[i-1][j]+num_path[i][j-1];
        	}
        }
        return num_path[m-1][n-1];
    }
}