package 牛客616;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author tigerto
 *
 */
public class Main27__ {

	private TreeNode curP = null;
	private TreeNode root = null;

	public TreeNode Convert(TreeNode pRootOfTree) {
		convertHelper(pRootOfTree);
		return root;
	}

	private void convertHelper(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return;
		convertHelper(pRootOfTree.left);
		if (curP != null) {
			curP.right = pRootOfTree;
			pRootOfTree.left = curP;
			curP = pRootOfTree;
		} else {
			root = pRootOfTree;
			curP = pRootOfTree;
		}
		convertHelper(pRootOfTree.right);
	}
}
