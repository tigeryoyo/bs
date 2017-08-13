package 笔试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int ld1 = in.nextInt();
			int ld2 = in.nextInt();
			int ru1 = in.nextInt();
			int ru2 = in.nextInt();
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put(ld1 + "," + ld2, 1);
			map.put(ld1 + "," + ru2, 1);
			map.put(ru1 + "," + ld2, 1);
			map.put(ru1 + "," + ru2, 1);

			for (int i = 0; i < n - 1; i++) {
				ld1 = in.nextInt();
				ld2 = in.nextInt();
				ru1 = in.nextInt();
				ru2 = in.nextInt();
				String key = ld1 + "," + ld2;
				if (map.containsKey(key)) {
					map.remove(key);
				} else {
					map.put(key, 1);
				}

				key = ld1 + "," + ru2;
				if (map.containsKey(key)) {
					map.remove(key);
				} else {
					map.put(key, 1);
				}

				key = ru1 + "," + ld2;
				if (map.containsKey(key)) {
					map.remove(key);
				} else {
					map.put(key, 1);
				}

				key = ru1 + "," + ru2;
				if (map.containsKey(key)) {
					map.remove(key);
				} else {
					map.put(key, 1);
				}
			}
			ArrayList<String> point = new ArrayList<String>();
			for (String str : map.keySet()) {
				point.add(str);
			}
			Collections.sort(point);
			ld1 = Integer.valueOf(point.get(0).substring(0, 1));
			ld2 = Integer.valueOf(point.get(0).substring(2, 3));
			ru1 = Integer.valueOf(point.get(3).substring(0, 1));
			ru2 = Integer.valueOf(point.get(3).substring(2, 3));
			System.out.println(ld1 + " " + ld2 + " " + ru1 + " " + ru2);
		}
		in.close();
	}
}
