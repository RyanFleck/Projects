/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Preorder is Root, Left, Right.

class Solution {

    private List<Integer> x = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if( root != null ) preorderTraversalStep( root );
        return x;
    }

    private void preorderTraversalStep( TreeNode node ){
        x.add( node.val );
        if( node.left != null ) preorderTraversal( node.left );
        if( node.right != null ) preorderTraversal( node.right );
    }
}
