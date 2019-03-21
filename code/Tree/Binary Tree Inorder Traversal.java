/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // My Recursive Method  Time O(N) because T(N)=2*T(N/2)+1   Space: O(N) worst case  O(log(N)) average
class Solution {
	List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }
    private void inorder(TreeNode node){
    	if(node==null){
    		return;
    	}
    	inorder(node.left);
    	res.add(node.val);
    	inorder(node.right);
    } 
}

// My Iterative Method
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        boolean is_stack=false;
        while(!stack.isEmpty() || cur!=null){
        	if(cur==null){
        		cur=stack.pop();
        		is_stack=true;
        		continue;
        	}
        	if(is_stack){
        		res.add(cur.val);
        		cur=cur.right;
        	}else{
        		stack.push(cur);
        		cur=cur.left;
        	}
			is_stack=false;
        }
        return res;
    }
}

// Best Iterative Method 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
        	while(cur!=null){
        		stack.push(cur);
        		cur=cur.left;
        	}
        	cur=stack.pop();
        	res.add(cur.val);
        	cur=cur.right;
        }
        return res;
    }
}