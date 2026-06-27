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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode a,TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        if(a.val!=b.val) return false;
        boolean r1=isMirror(a.left,b.right);
        boolean r2=isMirror(a.right,b.left);
        if(r1==true && r2==true) return true;
        return false;
    }
}