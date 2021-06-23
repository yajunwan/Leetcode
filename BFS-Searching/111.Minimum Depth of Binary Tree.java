/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        int depth = 1;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(nodes.size()!=0){
            int size = nodes.size();
            for (int i=0;i<size;i++){
                TreeNode n = nodes.remove();
                if (n.left==null && n.right==null){
                    return depth;
                }
                if (n.left!=null){
                    nodes.add(n.left);
                }
                if (n.right!=null){
                    nodes.add(n.right);
                }
            }
            depth++;
        }
        return depth;
    }
}