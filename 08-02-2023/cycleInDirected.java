class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int neigh:adj.get(i)){
                indegree[neigh]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            count++;
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.add(neigh);
                }
            }
        }
        if(count == V){
            return false;
        }
        return true;
    }
}
