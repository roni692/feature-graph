//Number Of Island Problem
class NumberIslands{
	public int numberOfIslands(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		
		int maxArea = 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j < grid[0].length;j++){
				int area = dfs(grid,i,j);
				maxArea = Math.max(area, maxArea);
			}
		}
		return maxArea;
	}
	public int dfs(int[][] grid, int i,int j){
		if(i < 0 || j < 0 || grid[i][j] == 0 || i >= grid.length || j >= grid[i].length){
			return 0;
		}
		int area = 1;
		
		area =+ dfs(grid,i+1,j);
		area =+ dfs(grid,i-1,j);
		area =+ dfs(grid,i,j+1);
		area =+ dfs(grid,i,j-1);
		
		return area;
	}
}