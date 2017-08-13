package 牛客616;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = Integer.parseInt(in.nextLine());
			int res = 0;
			BTree root = new BTree();
			while (n != 0) {
				n--;
				BTree tmp = root;
				String[] paths = in.nextLine().split("/");
				for (int i = 1; i < paths.length - 1; i++) {
					if (tmp.child.containsKey(paths[i])) {
						tmp = tmp.child.get(paths[i]);
					} else {
						tmp.child.put(paths[i], new BTree());
						tmp = tmp.child.get(paths[i]);
						res += 1;
					}
				}
			}
			System.out.println(res);
		}
		in.close();
	}

	static class BTree {
		HashMap<String, BTree> child;
		String path;

		BTree() {
			child = new HashMap<String, BTree>();
		}
	}
}
