class Solution {
    
    StringBuilder answer;
    
    public void helper(TreeNode node){
        
        answer.append(node.val);
        
        if(node.left == null && node.right == null){
            return;
        }
        
        else if(node.right == null){
            
            answer.append("(");
            helper(node.left);
            answer.append(")");
            
        }
        
        else if(node.left == null){
            
            answer.append("()");
            answer.append("(");
            helper(node.right);
            answer.append(")");
            
        }
        
        else{
            
            answer.append("(");
            helper(node.left);
            answer.append(")");
            
            answer.append("(");
            helper(node.right);
            answer.append(")");
            
        }
        
    }
    
    public String tree2str(TreeNode root) {
        answer = new StringBuilder("");
        
        
        helper(root);
        return answer.toString();
    }
}

对String的操作，我们并没有在原对象的基础上进行append，而是生成了新的对象，，这么一想上面的每一次操作，都申请内存生成了一个新的对象，频繁操作下，无怪乎效率如此低下。

结论：

对String对象的任何改变都不影响到原对象，相关的任何change操作都会生成新的对象
频繁的字符串拼接操作切记不可用String
————————————————

从StringBuffer的append方法的源码可知，看到了synchronized关键字，原来它是线程安全的，每次只有一个线程能访问资源，所以在大数量的append操作时，比线程不安全的StringBuilder效率要低一点。

结论：

StringBuffer线程安全，适合多线程编程的时候使用
StringBuilder线程不安全，但效率比StringBuffer高
————————————————
版权声明：本文为CSDN博主「小啊小木头」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/lxfHaHaHa/article/details/87552246
版权声明：本文为CSDN博主「小啊小木头」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/lxfHaHaHa/article/details/87552246