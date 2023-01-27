class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isForward = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=1; i<=size; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
                if(isForward){
                    sublist.add(curr.val);
                }
                else{
                    sublist.add(0,curr.val);
                }
            }
            isForward = !isForward;
            result.add(sublist);
        }
        return result;
    }
}