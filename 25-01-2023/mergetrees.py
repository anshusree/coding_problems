class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        def merge(root1,root2):
            if(root1==None):
                return root2
            if(root2==None):
                return root1
            head = TreeNode(root1.val + root2.val)
            head.left = merge(root1.left, root2.left)
            head.right = merge(root1.right, root2.right)
            return head
        return merge(root1,root2)