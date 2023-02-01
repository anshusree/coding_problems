public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> res = new ArrayList<>();
		if(root==null){
			return res;
		}
		res.add(root.data);
		leftboundary(root.left,res);
		leaf(root.left,res);
		leaf(root.right,res);
		rightboundary(root.right,res);
		return res;
	}

	public static void leftboundary(TreeNode root, ArrayList<Integer> res){
		if(root==null || (root.left==null && root.right==null)){
			return;
		}
		res.add(root.data);
		if(root.left!=null){
			leftboundary(root.left,res);
		}
		else{
			leftboundary(root.right,res);
		}
	}

	public static void leaf(TreeNode root, ArrayList<Integer> res){
		if(root==null){
			return;
		}
		if(root.left==null && root.right==null){
			res.add(root.data);
			return;
		}
		leaf(root.left,res);
		leaf(root.right,res);
	}

	public static void rightboundary(TreeNode root, ArrayList<Integer> res){
		if(root==null || (root.left==null && root.right==null)){
			return;
		}
		if(root.right!=null){
			rightboundary(root.right,res);
		}
		else{
			rightboundary(root.left,res);
		}
		res.add(root.data);
	}
}