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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> ans=new ArrayList<>();

            while(level!=0){
                TreeNode t=q.poll();
                ans.add(t.val);
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
                level--;
            }

            list.add(new ArrayList<>(ans));
        }

        Collections.reverse(list);
        return list;
    }
}