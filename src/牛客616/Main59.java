package 牛客616;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * @author Chan
 *
 */
public class Main59 {
	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null){
			return true;
		}
		return isSymmetrical(pRoot.left, pRoot.right);
	}

	boolean isSymmetrical(TreeNode pL, TreeNode pR) {
		if (pL == null || pR == null) {
			if (pL != pR) {
				return false;
			}
			return true;
		}

		if (pL.val != pR.val) {
			return false;
		} else {
			return isSymmetrical(pL.left, pR.right) && isSymmetrical(pL.right, pR.left);
		}
	}
}
