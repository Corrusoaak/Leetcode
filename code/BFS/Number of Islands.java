class Solution {
    // Define the DFS directions
    int[][] dirs= {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        // Calculate the lands
        if(grid.length==0)return 0;
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(DFS(grid,i,j,grid.length,grid[0].length))res++;
            }
        }
        return res;

    }
    // Test if it's a land
    // if so, turn the land into water by DFS
    private boolean DFS(char[][] grid, int x, int y, int width, int height){
        if(x<0 || x>=width || y<0 || y>=height || grid[x][y]=='0')return false;
        grid[x][y]='0';
        for(int i=0;i<4;i++){
            DFS(grid,x+dirs[i][0],y+dirs[i][1],width,height);
        }
        return true;

    }
}