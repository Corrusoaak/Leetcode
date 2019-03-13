class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length==0){
        	return res;
        }
        
        int i=0,j=0,width=matrix.length,height=matrix[0].length;
        int num_total=width*height;
        int corner=0,step=0;
        while(num_total>0){
        	res.add(matrix[i][j]);
        	num_total--;

        	if(i==step && j<height-1-step){
        		j++;
        	}else if(i<width-1-step && j==height-1-step){
        		i++;
        	}else if(i==width-1-step && j>step){
        		j--;
        	}else if(i>step+1 && j==step){
        		i--;
        	}else{
        		j++;
        		step++;
        	}
        }
        return res;
    }
}