class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Character> list=new ArrayList<>();
        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[i][j]!='.'){
        			if(list.contains(board[i][j])){
        				return false;
        			}else{
        				list.add(board[i][j]);
        			}
        		}
        	}
        	list.clear();
        }

        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[j][i]!='.'){
        			if(list.contains(board[j][i])){
        				return false;
        			}else{
        				list.add(board[j][i]);
        			}
        		}
        	}
        	list.clear();
        }

        for(int i=0;i<=6;i=i+3){
        	for(int l=0;l<=6;l=l+3){
	        	for(int j=0;j<3;j++){
	        		for(int k=0;k<3;k++){
	        			if(board[i+j][k+l]!='.'){
		        			if(list.contains(board[i+j][k+l])){
		        				return false;
		        			}else{
		        				list.add(board[i+j][k+l]);
		        			}	        				
	        			}

	        		}
	        	}
	        	list.clear();  
      		
        	}
        }
        return true;
    }

}