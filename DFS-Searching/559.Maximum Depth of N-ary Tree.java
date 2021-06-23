/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        return findMax(root,1);
    }
    private int findMax(Node n, int depth){
        if(n.children.size()==0){
            return depth;
        }
        for (Node ns: n.children){
            int curr = findMax(ns,depth+1);
            max = Math.max(max,curr);
        }
        return max;
    }
}