class Solution {
    
    public void DFS(boolean[][] visited, char[][] grid, int row, int col, int Lbound, int DBound){
        
        visited[row][col] = true;
        if(grid[row][col] == '0') return;
        
        // look up
        if(row != 0 && !visited[row-1][col]){
            DFS(visited, grid, row-1, col, Lbound, DBound);
        }
        
        // look down
        if(row < DBound-1 && !visited[row+1][col]){
            DFS(visited, grid, row+1, col, Lbound, DBound);
        }
        
        // look left
        if(col > 0 && !visited[row][col-1]){
            DFS(visited, grid, row, col-1, Lbound, DBound);
        }
        
        // look right
        if(col < Lbound-1 && !visited[row][col+1]){
            DFS(visited, grid, row, col+1, Lbound, DBound);
        }
    }
    
    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
 
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    DFS(visited, grid, i, j, grid[0].length, grid.length);
                    count++;
                }  
            }
        }
        
        return count;
    }
}
