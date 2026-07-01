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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()){
            int level=q.size();
            while(level!=0){
                TreeNode top=q.poll();
                if(level==1) ans.add(top.val);
                if(top.left!=null) q.offer(top.left);
                if(top.right!=null) q.offer(top.right);
                level--;
            }
        }

        return ans;
    }
}