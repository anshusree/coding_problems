class Solution {
    static class Tuple {
        TreeNode node;
        int row, col;
        public Tuple (TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.offer(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<Integer>());
            map.get(x).get(y).offer(node.val);
            if (node.left != null)
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                queue.offer(new Tuple(node.right, x + 1, y + 1)); 
        }
        List<List<Integer>> ans = new ArrayList<>();
		for (TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()){
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : mp.values()){
                while (!pq.isEmpty())
                    ans.get(ans.size() - 1).add(pq.poll());
            }
        }
        return ans;
    }
}