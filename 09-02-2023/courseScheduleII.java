class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] res = new int[numCourses];
        int count =0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            res[count++] = node;
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    queue.add(neigh);
                }
            }
        }
        int[] arr = {};
        if(count != numCourses) return arr;
        else return res;
    }
}
