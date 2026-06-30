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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> res=new ArrayList<>();
        int sum=0;
        helper(root,sum,targetSum,res);
        return ans;
    }

    public void helper(TreeNode root,int sum,int targetSum,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        sum+=root.val;

        if(root.left==null && root.right==null){
            if(sum==targetSum) ans.add(new ArrayList<>(res));
        }

        else{
            helper(root.left,sum,targetSum,res);
            helper(root.right,sum,targetSum,res);
        }

        sum-=root.val;
        res.removeLast();
    }
}