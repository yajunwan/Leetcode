// In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

// Return the maximum amount of gold you can collect under the conditions:

// Every time you are located in a cell you will collect all the gold in that cell.
// From your position, you can walk one step to the left, right, up, or down.
// You can't visit the same cell more than once.
// Never visit a cell with 0 gold.
// You can start and stop collecting gold from any position in the grid that has some gold.

// Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
// Output: 24
// Explanation:
// [[0,6,0],
//  [5,8,7],
//  [0,9,0]]
// Path to get the maximum gold, 9 -> 8 -> 7.
class Solution {
    int result = 0;
    public int getMaximumGold(int[][] grid) {
        int gold = 0;
        for(int i=0;i<grid.length-1;i++){
            for (int j=0;j<grid[0].length-1;j++){
                if (grid[i][j]!=0){
                    helper(i,j,gold,grid);
                }
            }
        }
        return result;
    }
    private void helper(int x,int y,int gold, int[][]grid){
        result = Math.max(gold,result);
        if (x<0||y<0||x>grid.length-1||y>grid[0].length-1||grid[x][y]==0){
            return;
        }else{
            int track = grid[x][y];
            gold+=track;
            grid[x][y] = 0;
            helper(x+1,y,gold,grid);
            helper(x,y+1,gold,grid);
            helper(x-1,y,gold,grid);
            helper(x,y-1,gold,grid);
            grid[x][y] = track;
        }
        
    }
}