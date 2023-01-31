class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return tree(inorder, postorder, map, 0, inorder.length-1, 0, postorder.length-1);
    }
    public TreeNode tree(int[] inorder, int[] postorder, HashMap<Integer,Integer> map, int is, int ie, int ps, int pe){
        if(pe<ps || ie<is){
            return null;
        }
        TreeNode node = new TreeNode(postorder[pe]);
        int inPlace = map.get(postorder[pe]);
        int count = ie - inPlace;
        node.left = tree(inorder, postorder, map, is, inPlace-1, ps, pe-count-1);
        node.right = tree(inorder, postorder, map, inPlace+1, ie, pe-count, pe-1);
        return node;
    }
}