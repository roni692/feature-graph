class NetworkDelayTime{
	public int networkDelayTimeCalculationn(int[] times, int n, int k){
		
		//Create a graph represented as adjacency list
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for(int [] edge: times){
			graph.computeIfabsent(edge[0], new ArrayList()).add(new int[]{edge[1],edge[2]});
		}
		
		//Use a priority queue to select node with the min distance
		PriorityQueue<int[]> pq = new PriorityQueue(Comparator.comparintInt(a -> a[1]));
		pq.offer(new int[]{k,0});//Start from node k with the distance 0
		
		//Initialize distance array with the infinity
		int[] distances = new int[n + 1];
		Array.fill(distances, Integer.MAX_VALUE);
		distances[k] = 0;
		
		while(!pk.isEmpty()){
			int[] current = pk.poll();
			int currentNode = current[0];
			int currentDist = current[1];
			
			//If we have already found shorter path before continue
			if(currentDist > distance[currentNode]){
				continue;
			}
			
			if(graph.containsKey(currentNode)){
				for(int [] neighbor : graph.get(currentNode)){
					int nextNode = neighbor(0);
					int nextDist = currentDist + neighbor[1];
					
					if(nextDist < distances[nextNode]){
						distances[nextNode] = nextDist;
						pq.offer(new int[]{nextNode, nextDist});
					}
				}					
				
			}				
		}
		int maxDist =  Arrays.stream(distances).skip(1).max().getAsInt();
		return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
	}
}
		

	