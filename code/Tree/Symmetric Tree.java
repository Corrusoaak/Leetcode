/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Best Iterative way
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.offer(root.left);
        nodes.offer(root.right);
        while(!nodes.isEmpty()){
            TreeNode t1=nodes.poll();
            TreeNode t2=nodes.poll();
            if(t1==null && t2==null)continue;
            if(t1==null || t2==null)return false;
            if(t1.val!=t2.val)return false;
            nodes.offer(t1.left);
            nodes.offer(t2.right);
            nodes.offer(t1.right);
            nodes.offer(t2.left);
        }
        return true;

    }
}

// My Iterative way
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int size=nodes.size();
            Stack<Integer> stack=new Stack<>();
            for(int i=1;i<=size;i++){
                TreeNode node=nodes.poll();
                if(node!=root){
                    if(i<=size/2){
                        if(node==null){
                            stack.push(null);
                        }else{
                            stack.push(node.val);
                        }
                    }else{
                        Integer tmp=stack.pop();    // stack是pop和push
                        if(node==null){
                            if(tmp!=null)return false;
                        }else{
                            if(tmp==null || node.val!=tmp)return false; // null不能直接比！！
                        }

                    }
                }
                if(node!=null){
                    nodes.offer(node.left);
                    nodes.offer(node.right);
                }
            }
        }
        return true;
    }
}

// My Recursive way
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isEqual(root.left,root.right);
    }

    private boolean isEqual(TreeNode left_node, TreeNode right_node ){
        if(left_node==null && right_node==null){
            return true;
        }else if(left_node==null && right_node!=null){
            return false;
        }else if(left_node!=null && right_node==null){
            return false;
        }else{
            if(left_node.val==right_node.val){
                return isEqual(left_node.left,right_node.right) && isEqual(left_node.right,right_node.left);
            }else{
                return false;
            }
        }
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
    }

}