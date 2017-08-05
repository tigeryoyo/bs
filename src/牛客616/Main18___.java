package 牛客616;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * @author tigerto
 *
 */
public class Main18___ {

	public boolean HasSubtree(TreeNode rootA, TreeNode rootB) {
		if (rootA == null || rootB == null) {
			return false;
		}
		return isSubTree(rootA, rootB) || HasSubtree(rootA.left, rootB) || HasSubtree(rootA.right, rootB);

	}

	public boolean isSubTree(TreeNode rootA, TreeNode rootB) {
		// 先判断B树，加入递归到A树B树当前节点都为null的时候，其实返回true。
		// 若先判断A树则返回false。
		if (rootB == null) {
			return true;
		}
		if (rootA == null) {
			return false;
		}
		if (rootA.val == rootB.val) {
			return isSubTree(rootA.left, rootB.left) && isSubTree(rootA.right, rootB.right);
		} else {
			return false;
		}
	}

}
