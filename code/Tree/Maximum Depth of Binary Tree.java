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
    public int maxDepth(TreeNode root) {
        return findMax(root);
    }
    private int findMax(TreeNode node){
    	if(node==null)return 0;
    	return Math.max(findMax(node.left),findMax(node.right))+1;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
    	if(root==null)return 0;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.offer(root);
        int level=0;
        while(!nodes.isEmpty()){
        	int size=nodes.size();
        	for(int i=1;i<=size;i++){
        		TreeNode node=nodes.poll();
        		if(node.left!=null)nodes.offer(node.left);
        		if(node.right!=null)nodes.offer(node.right);
        	}
        	level++;
        }
        return level;
    }

}