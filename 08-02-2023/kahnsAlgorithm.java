class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
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
        int[] res = new int[V];
        int i=0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            res[i++] = node;
            queue.poll();
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.add(neigh);
                }
            }
        }   
        return res;
    }
}
