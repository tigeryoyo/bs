package 牛客616;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author tigerto
 *
 */
public class Main62___ {
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	int index = -1;

	TreeNode Deserialize(String str) {
		index++;
		TreeNode node = null;
		String[] strs = str.split(",");
		if (!strs[index].equals("#")) {
			node = new TreeNode(Integer.parseInt(strs[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
