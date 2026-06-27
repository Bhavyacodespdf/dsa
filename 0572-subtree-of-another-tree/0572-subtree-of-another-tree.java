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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null ) return false;
        return isSub(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);     
    }

    public boolean isSub(TreeNode a,TreeNode b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        if(a.val!=b.val) return false;
        boolean r1=isSub(a.left,b.left);
        boolean r2=isSub(a.right,b.right);
        return (r1==true && r2==true) ? true : false;
    }
}