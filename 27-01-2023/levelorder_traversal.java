class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> empty = new LinkedList<List<Integer>>();
        if(root==null){
            return empty;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                sublist.add(curr.val);
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            empty.add(sublist);
        }
        return empty;
    }
}