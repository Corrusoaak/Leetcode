class Solution {
	int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};	// 模拟路径，可以减少代码量
    public boolean exist(char[][] board, String word) {

    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
				if(backTracking(board,i,j,0,word)){
					return true;
				}
    		}
    	}
    	return false;        
    }

    boolean backTracking(char[][] board, int x, int y, int index, String word){
    	if(index==word.length()){
    		return true;
    	}
    	if(x>=board.length || x<0 || y>=board[0].length || y<0 || word.charAt(index)!=board[x][y]){		// 很重要，应该先判断当前路径下是否是对的！！而不是既定他是对的去看下面的情况
    		return false;
    	}
    	char tmp=board[x][y];
    	board[x][y]='#';
    	for(int[] dir:dirs){
    		if(backTracking(board,x+dir[0],y+dir[1],index+1,word)){
    			return true;
    		}
    	}
    	board[x][y]=tmp;
    	return false;
    }


}



class Solution {
    public boolean exist(char[][] board, String word) {
    	if(word.isEmpty()){
    		return true;
    	}
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(board[i][j]==word.charAt(0)){
    				char tmp=board[i][j];
    				board[i][j]='(';
    				if(backTracking(board,i,j,1,word)){
    					return true;
   					}
   					board[i][j]=tmp;
   				}
    		}
    	}
    	return false;        
    }

    boolean backTracking(char[][] board, int x, int y, int index, String word){
    	if(index==word.length()){
    		return true;
    	}
    	if(x-1>=0 && board[x-1][y]==word.charAt(index)){
    		char tmp=board[x-1][y];
    		board[x-1][y]='(';
    		if(backTracking(board,x-1,y,index+1,word)){
    			return true;
    		}
    		board[x-1][y]=tmp;
    	}
    	if(y-1>=0 && board[x][y-1]==word.charAt(index)){
    		char tmp=board[x][y-1];
    		board[x][y-1]='(';
    		if(backTracking(board,x,y-1,index+1,word)){
    			return true;
    		}
    		board[x][y-1]=tmp;
    	}
    	if(x+1<board.length && board[x+1][y]==word.charAt(index)){
    		char tmp=board[x+1][y];
    		board[x+1][y]='(';
    		if(backTracking(board,x+1,y,index+1,word)){
    			return true;
    		}
    		board[x+1][y]=tmp;
    	}
    	if(y+1<board[0].length && board[x][y+1]==word.charAt(index)){
    		char tmp=board[x][y+1];
    		board[x][y+1]='(';
    		if(backTracking(board,x,y+1,index+1,word)){
    			return true;
    		}
    		board[x][y+1]=tmp;
    	}
    	return false;

    }


}