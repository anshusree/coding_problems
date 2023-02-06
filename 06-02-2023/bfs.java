class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        int source = 0;
        visited[source] = true;
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1; i<=size; i++){
                int node = queue.poll();
                for(int neigh:adj.get(node)){
                    if(!visited[neigh]){
                        visited[neigh] = true;
                        queue.add(neigh);
                    }
                }
            }
        }
        return res;
    }
}
