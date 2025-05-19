//WallAndGates
public class WallAndGatesCalc{
	int INF = 2147483647;
	
	public void WallAndGate(int[][] rooms){
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;
		
		Queue<int[]> queue = new LinkedList<>();
		int m = rooms.length,n = rooms[0].length;
		
		int[] dirs = {0,1,0,-1,0};
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(rooms[i][j] == 0){
					queue.offer(new int[]{i,j});
				}
			}
		}
		//BFS from each gate
        while(!queue.isEmpty()){
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for(int i = 0;i < 4;i++){
                int newRow = row + dirs[i];
                int newCol = col + dirs[i + 1];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    rooms[newRow][newCol] == INF){
                        rooms[newRow][newCol] = rooms[row][col] + 1;
                        queue.offer(new int[]{newRow,newCol});
                    }
            }
		}
	}
	
}