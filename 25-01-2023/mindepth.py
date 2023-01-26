class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        def depth(root):
            if not root:
                return 0
            left = depth(root.left)+1
            right = depth(root.right)+1
            if(root.left==None):
                return right
            if(root.right==None):
                return left
            mindepth = min(left,right)
            return mindepth
        return depth(root)