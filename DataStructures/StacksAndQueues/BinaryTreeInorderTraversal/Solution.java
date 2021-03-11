// https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode riåght;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// DFS
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return DFS(new ArrayList<Integer>(), root);   
    }
    
    public List<Integer> DFS(List<Integer> list, TreeNode root) { 
        if(root == null) return list;
        DFS(list, root.left);
        list.add(root.val);
        DFS(list, root.right);
        return list;
    }
}


/* Stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       
        List<Integer> list = new ArrayList<Integer>();
        TreeNode temp = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        while(!s.isEmpty() || temp != null){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            } 
            temp = s.pop();
            list.add(temp.val);
            temp = temp.right;    
        }
        
        return list;
        
    }
}
*/
