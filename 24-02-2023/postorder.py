class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root
        res=[]
        def postorder(root):
            if(root.left):
                postorder(root.left)
            if(root.right):
                postorder(root.right)
            res.append(root.val)
        postorder(root)
        return res