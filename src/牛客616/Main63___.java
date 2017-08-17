package 牛客616;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4
 * 
 * @author tigerto
 *
 */
public class Main63___ {

	TreeNode KthNode1(TreeNode pRoot, int k) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (!s.isEmpty() || pRoot != null) {
			while (pRoot != null) {
				s.push(pRoot);
				pRoot = pRoot.left;
			}
			pRoot = s.pop();
			if (--k == 0) {
				return pRoot;
			}
			pRoot = pRoot.right;
		}

		return null;
	}

	int count = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null) {
			return null;
		}
		TreeNode node = KthNode(pRoot.left, k);
		if (k == count) {
			return node;
		}
		if (k == ++count) {
			return pRoot;
		}
		node = KthNode(pRoot.right, k);
		if (k == count) {
			return node;
		}
		
		return null;
	}

}
