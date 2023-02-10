class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int indegree[] = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int neigh:adj.get(i)){
                indegree[neigh]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count =0;
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
        if(count == numCourses){
            return true;
        }
        return false;
    }
}
