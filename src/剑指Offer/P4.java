package 剑指Offer;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String input = in.nextLine();
			input = input.replaceAll(" ", "%20");
			System.out.println(input);
		}
		in.close();
	}

}
