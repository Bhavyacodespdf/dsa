/**
 * Definition for a binary tree node.
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
    TreeNode ans=null;
    int deepest=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return ans;
    }

    public int depth(TreeNode root,int d){
        if(root==null) return d;

        int left=depth(root.left,d+1);
        int right=depth(root.right,d+1);

        if(left==right && left>=deepest){
            deepest=left;
            ans=root;
        }

        return Math.max(left,right);
    }
}