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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        count(root, p, q);
        return ans;
    }

    public int count(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return 0;
        int left=count(root.left,p,q);
        int right=count(root.right,p,q);
        int self=0;
        if(root.val==p.val || root.val==q.val) self=1;
        int total=left+right+self;
        if(total==2 && ans==null){
            ans=root;
        }

        return total;
    }
}