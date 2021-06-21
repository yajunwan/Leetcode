class Traversal{
    static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public void setLeft(TreeNode left){
            this.left = left;
        }
        public TreeNode getLeft(){
            return this.left;
        }
        public void setRight(TreeNode right){
            this.right = right;
        }
        public TreeNode getRight(){
            return this.right;
        }
    }

    public void inorder(TreeNode root){
        
    }
    public static void main (String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(12);
        TreeNode n2 = new TreeNode(22);
        TreeNode n3 = new TreeNode(13);
        TreeNode n4 = new TreeNode(34);
        TreeNode n5 = new TreeNode(66);
        TreeNode n6 = new TreeNode(89);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n3.setRight(n4);

    }
}