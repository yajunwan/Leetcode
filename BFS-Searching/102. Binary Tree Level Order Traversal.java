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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root==null){
            return results;
        }
        nodeQueue.add(root);
        while (nodeQueue.size()!=0){
            int size = nodeQueue.size();
            List<Integer> tempL = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode n = nodeQueue.remove();
                tempL.add(n.val);
                if (n.left!=null){
                    nodeQueue.add(n.left);
                }
                if (n.right!=null){
                    nodeQueue.add(n.right);
                }
            }
            results.add(tempL);
        }
        return results;
    }
}