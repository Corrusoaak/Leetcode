class Solution {
    public void rotate(int[][] matrix) {
        int width=matrix.length;
        for(int i=0;i<width/2;i++){
        	for(int j=0;j<(width+1)/2;j++){	// 保证奇数矩阵不会重复变换
        		int tmp=matrix[i][j];
        		matrix[i][j]=matrix[width-1-j][i];
        		matrix[width-1-j][i]=matrix[width-1-i][width-1-j];	// 这几个变换之间的关系
        		matrix[width-1-i][width-1-j]=matrix[j][width-1-i];
        		matrix[j][width-1-i]=tmp;
        	}
        }
    }
}