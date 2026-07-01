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
    HashMap<Integer,Integer> map=new HashMap<>();
    int idx=0;
    TreeNode ans=null;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,preorder.length-1);
    }

    public TreeNode helper(int[] preorder,int low,int high){
        if(low>high) return null;
        TreeNode head=new TreeNode(preorder[idx]);
        int id=map.get(head.val);
        idx++;

        head.left=helper(preorder,low,id-1);
        head.right=helper(preorder,id+1,high);

        return head;
    }
}