/**
 * 
 */

/**
 * @author rflec028
 *
 */
public class TreeNode {
	private TreeNode left=null,right=null,prev=null;
	private String info;
	private Object storedObject;
	
	public TreeNode(){}
	
	//Setters:
	public void setLeft(TreeNode x){left = x;}
	public void setRight(TreeNode x){right = x;}
	public void setPrev(TreeNode x){prev = x;}
	//Getters:
	public TreeNode getLeft(TreeNode x){return left;}
	public TreeNode getRight(TreeNode x){return right;}
	public TreeNode getPrev(TreeNode x){return prev;}
	
	
	
} 
