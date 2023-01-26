class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def depth(root):
            if not root:
                return 0
            left = depth(root.left)+1
            right = depth(root.right)+1
            maxdepth = max(left,right)
            return maxdepth
        return depth(root)