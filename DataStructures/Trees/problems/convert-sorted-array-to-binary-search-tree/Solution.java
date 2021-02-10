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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(new TreeNode(), nums, 0, nums.length-1);
    }
    
    public TreeNode helper(TreeNode root, int[] nums, int start, int end){
        
        // base case. When theres no numbers left
        if(end - start < 0){
            return null;
        }
            
        int mid = (start + end)/2;
        root.val = nums[mid];
        root.left = helper(new TreeNode(), nums, start, mid-1);
        root.right = helper(new TreeNode(), nums, mid+1, end);
        
        return root;
    }
    
}
