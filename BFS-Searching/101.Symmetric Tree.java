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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode ex1 = q.remove();
            TreeNode ex2 = q.remove();
            if(ex1.val!=ex2.val) return false;
            if(ex1.left!=null && ex2.right!=null){
                q.add(ex1.left);
                q.add(ex2.right);
            }else if(ex1.left==null && ex2.right==null){
                //do nothing
            }else if(ex1.left==null || ex2.right==null) return false;
            
            if(ex1.right!=null && ex2.left!=null){
                q.add(ex1.right);
                q.add(ex2.left);
            }else if(ex1.right==null && ex2.left==null){
                //do nothing
            }else if(ex1.right==null || ex2.left==null) return false;
            
        }
        return true;
    }
}