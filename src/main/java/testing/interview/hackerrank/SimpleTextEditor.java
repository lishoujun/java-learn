package testing.interview.hackerrank;

import java.util.*;

/**
 * Simple Text Editor
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 * 
 * @author lishoujun
 */
public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Stack<StringBuilder> stringBuilderStack = new Stack<>();
		while (N-- > 0) {

			int operation = in.nextInt();
			switch (operation) {
			case 1:
				StringBuilder top = (stringBuilderStack.isEmpty() ? new StringBuilder("") : stringBuilderStack.peek());
				StringBuilder newsb = new StringBuilder(top);
				newsb.append(in.next());
				stringBuilderStack.add(newsb);
				break;
			case 2:
				StringBuilder current = new StringBuilder(stringBuilderStack.peek());
				int start = current.length() - in.nextInt();
				int end = current.length();
				current.delete(start, end);
				stringBuilderStack.add(current);
				break;
			case 3:
				char toPrint = stringBuilderStack.peek().charAt(in.nextInt() - 1);
				System.out.println(toPrint);
				break;
			case 4:
				stringBuilderStack.pop();
				break;

			default:
				break;
			}
			// System.out.println(stringBuilderStack.peek().toString());
		}
		in.close();
	}
}