public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		int successor = -1;
		int predecessor = -1;
		while(root.data!=key){
			if(key>root.data){
				predecessor = root.data;
				root=root.right;
			}
			else{
				successor = root.data;
				root = root.left;
			}
		}
		BinaryTreeNode<Integer> righttree = root.right;
		while (righttree != null)
	    {
	        successor = righttree.data;
	        righttree = righttree.left;
	    }
		BinaryTreeNode<Integer> lefttree = root.left;
		while (lefttree != null)
	    {
	        predecessor = lefttree.data;
	        lefttree = lefttree.right;
	    }

	    ArrayList<Integer> list = new ArrayList<>();
        list.add(predecessor);
        list.add(successor);
	    return list;
	}
}