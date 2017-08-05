package 牛客616;

public class Main19 {
	public void Mirror(TreeNode root) {
		if(root != null){
			TreeNode t = root.left;
			root.left = root.right;
			root.right = t;
			Mirror(root.left);
			Mirror(root.right);
		}
	}
}
