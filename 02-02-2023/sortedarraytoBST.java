class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return binary(nums, 0, nums.length-1);
        }
    public TreeNode binary(int[] nums, int l, int r){
        if(l>r) return null;
        int mid = (l+r)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = binary(nums, l, mid-1);
        node.right = binary(nums, mid+1, r);
        return node;
    }
}