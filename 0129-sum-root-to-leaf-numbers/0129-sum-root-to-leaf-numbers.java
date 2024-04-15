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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
        
    }
    
    public int sumNumbers(TreeNode root,int curSum){
        
        if(root==null) return 0;
        if(root.left==null && root.right==null) return curSum*10+root.val;
        
        return sumNumbers(root.left,curSum*10+root.val)+sumNumbers(root.right,curSum*10+root.val);
    }
}