/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findRoot(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode findRoot(int[] preorder,int pre_begin, int pre_end, int[] inorder,int in_begin, int in_end){
    	if(pre_begin>pre_end || in_begin>in_end){	// 要注意判断null的情况！！
    		return null;
    	}
    	TreeNode node=new TreeNode(preorder[pre_begin]);
    	for(int i=in_begin;i<=in_end;i++){
    		if(inorder[i]==preorder[pre_begin]){
    			TreeNode left_node=findRoot(preorder,pre_begin+1,pre_begin+i-in_begin,inorder,in_begin,i-1);
    			TreeNode right_node=findRoot(preorder,pre_begin+i-in_begin+1,pre_end,inorder,i+1,in_end);
    			node.left=left_node;
    			node.right=right_node;
    		}
    	}
    	return node;
    }
}