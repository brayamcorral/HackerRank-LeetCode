/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     } 
*/
public boolean checkBST(Node root) {
        
    boolean rightNull = (root.right == null) ? true : false;
    boolean leftNull = (root.left == null) ? true : false;
    
    if(rightNull && leftNull)
        return true;
    else if(leftNull && !rightNull && root.right.data > root.data)
        return true && checkBST(root.right);
    else if (!leftNull && rightNull && root.left.data < root.data)
        return checkBST(root.left) && true;
    else if(root.left.data < root.data && root.right.data > root.data)
        return checkBST(root.left) && checkBST(root.right);
    else
        return false;  
}