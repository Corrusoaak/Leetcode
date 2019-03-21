/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 严格来讲不能算Recursion的方法，因为迭代求了最大值和最小值，
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    private boolean isValid(TreeNode node){
    	if(node==null){
    		return true;
    	}
    	if(!isValid(node.left) || !isValid(node.right) || (node.left!=null && node.val<=findLargest(node.left)) || (node.right!=null && node.val>=findLeast(node.right))){
    		return false;
    	}
    	return true;
    }
    private int findLargest(TreeNode node){
    	while(node.right!=null){
    		node=node.right;
    	}
    	return node.val;
    }
    private int findLeast(TreeNode node){
    	while(node.left!=null){
    		node=node.left;
    	}
    	return node.val;    	
    }
}
// Best Recursion Method
class Solution{
	public boolean isValidBST(TreeNode root){
		return isValid(node,null,null);
	}

	private boolean isValid(TreeNode node, Integer lower, Integer upper){
		if(node==null){
			return true;
		}
		if(lower!=null && node.val<=lower){
			return false;
		}
		if(upper!=null && node.val>=upper){
			return false;
		}
		return isValid(node.left,lower,node.val) && isValid(node.right,node.val,upper);
	}
}



// 用的方法和答案一样，但是我觉得我比答案优雅很多 Iteration Method    
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur=root;
        Integer upper=null;
        Integer lower=null;

        Stack<TreeNode> nodes=new Stack<>();
        Stack<Integer> uppers=new Stack<>();
        Stack<Integer> lowers=new Stack<>();
        while(!nodes.isEmpty() || cur!=null){
        	if(cur==null){
        		cur=nodes.pop();
				upper=uppers.pop();
				lower=lowers.pop();
        		continue;
        	}
        	if(upper!=null && cur.val>=upper){
        		return false;
        	}
			if(lower!=null && cur.val<=lower){
				return false;
			}
			nodes.push(cur.left);
			uppers.push(cur.val);
			lowers.push(lower);
			nodes.push(cur.right);
			uppers.push(upper);
			lowers.push(cur.val);
			cur=nodes.pop();
			upper=uppers.pop();
			lower=lowers.pop();			
        } 
        return true;
    }

}



