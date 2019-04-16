class Solution {
    public void solve(char[][] board) {
        // Scanning
        int height=board.length;
        int width=board[0].length;
        for(int i=0;i<height;i++){
        	for(int j=0;j<width;j++){

        	}
        }
    }
    // Check if the cell belongs to a region 
    private boolean isRegion(int x, int y, char[][] board,int height,int width){
    	if(board[x][y]=='X'){
    		return true;
    	}
    	board[x][y]='X';
    	if((x-1>=0 && board[x-1][y]=='X') && (y-1>=0 && board[x][y-1]=='X') && (x+1<height && board[x+1][y]))
    }
}