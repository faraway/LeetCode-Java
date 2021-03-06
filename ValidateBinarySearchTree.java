package leetcode;
/**
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 * @author patrick
 *
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    /**
     * when recursively call the subtrees, use min & max to restrict the node's value range.
     * only left<root, right>root won't work, because left should also > root.parent(if root is right child of it parent)
     * @param root
     * @param min      root.val can be (min,max), not including min and max themselves
     * @param max
     * @return
     */
    public boolean validateBST(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.val<=min || root.val >= max){
            return false;
        }
        return validateBST(root.left,min,root.val) && validateBST(root.right,root.val,max);
    }
}   
