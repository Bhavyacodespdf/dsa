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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,postorder.length-1);
    }

    public TreeNode helper(int[] postorder,int low,int high){
        if(low>high) return null;
        TreeNode head=new TreeNode(postorder[idx]);
        idx--;
        int id=map.get(head.val);

        head.right=helper(postorder,id+1,high);
        head.left=helper(postorder,low,id-1);
        
        return head;

    }
}