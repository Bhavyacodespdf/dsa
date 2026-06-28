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
    Stack<TreeNode> st=new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        TreeNode t=root;
        TreeNode ans=null;

        while(t!=null){
            st.push(t);
            t=t.left;
        }

        for(int i=0;i<k;i++){
            ans=getSmall();
        }

        return ans.val;
    }

    public TreeNode getSmall(){
        TreeNode res=st.pop();
        TreeNode rright=res.right;
        while(rright!=null){
            st.push(rright);
            rright=rright.left;
        }

        return res;
    }
}