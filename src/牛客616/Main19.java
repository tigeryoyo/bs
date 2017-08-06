package 牛客616;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * @author tigerto
 *
 */
public class Main19 {
	public void Mirror(TreeNode root) {
		if (root != null) {
			TreeNode t = root.left;
			root.left = root.right;
			root.right = t;
			Mirror(root.left);
			Mirror(root.right);
		}
	}
}
