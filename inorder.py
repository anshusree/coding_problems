class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root
        res=[]
        def inorder(root):
            if root.left:
                inorder(root.left)
            res.append(root.val)
            if root.right:
                inorder(root.right)
        inorder(root)
        return res
        