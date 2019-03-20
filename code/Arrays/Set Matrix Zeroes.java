// Time Complexity: O(MN)  Space Complexity: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
    	if(matrix.length==0){
    		return;
    	}
        int width=matrix.length,height=matrix[0].length;
        boolean width_zero=false,height_zero=false;
        for(int i=0;i<width;i++){
        	if(matrix[i][0]==0){
        		width_zero=true;
        		break;
        	}
        }
        for(int j=0;j<height;j++){
        	if(matrix[0][j]==0){
        		height_zero=true;
        		break;
        	}
        }

        for(int i=1;i<width;i++){
        	for(int j=1;j<height;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        }
        for(int i=1;i<width;i++){
        	if(matrix[i][0]==0){
        		for(int j=1;j<height;j++){
        			matrix[i][j]=0;
        		}
        	}
        }
        for(int j=1;j<height;j++){
        	if(matrix[0][j]==0){
        		for(int i=1;i<width;i++){
        			matrix[i][j]=0;
        		}
        	}
        }
        if(width_zero){
        	for(int i=0;i<width;i++){
        		matrix[i][0]=0;
        	}
        }
        if(height_zero){
        	for(int j=0;j<height;j++){
        		matrix[0][j]=0;
        	}
        }
        return;
    }
}


// Time Complexity: O((M+N)*MN)  Space Complexity: O(1)