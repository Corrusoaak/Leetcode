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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    private TreeNode buildTree(int[] nums,int begin,int end){
    	if(begin>end)return null;
    	int mid=(begin+end)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	root.left=buildTree(nums,begin,mid-1);
    	root.right=buildTree(nums,mid+1,end);
    	return root;
    }
}