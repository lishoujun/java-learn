package testing.interview.hackerrank;

import java.util.*;

public class EqualStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		int n3 = in.nextInt();
		int h1[] = new int[n1];
		for (int h1_i = 0; h1_i < n1; h1_i++) {
			h1[h1_i] = in.nextInt();
		}
		int h2[] = new int[n2];
		for (int h2_i = 0; h2_i < n2; h2_i++) {
			h2[h2_i] = in.nextInt();
		}
		int h3[] = new int[n3];
		for (int h3_i = 0; h3_i < n3; h3_i++) {
			h3[h3_i] = in.nextInt();
		}
		in.close();
		Stack<NodeWithSum> s1 = arrayToStack(h1);
		Stack<NodeWithSum> s2 = arrayToStack(h2);
		Stack<NodeWithSum> s3 = arrayToStack(h3);
		while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
			if ((s3.peek().sum == s2.peek().sum) && (s3.peek().sum == s1.peek().sum)) {
				System.out.println(s3.pop().sum);
				return;
			}
			if (s1.peek().sum > s2.peek().sum || s1.peek().sum > s3.peek().sum) {
				s1.pop();
				continue;
			}
			if (s2.peek().sum > s1.peek().sum || s2.peek().sum > s3.peek().sum) {
				s2.pop();
				continue;
			}
			if (s3.peek().sum > s2.peek().sum || s3.peek().sum > s1.peek().sum) {
				s3.pop();
				continue;
			}

		}
		System.out.println(0);

	}

	private static Stack<NodeWithSum> arrayToStack(int[] h1) {
		Stack<NodeWithSum> tmps = new Stack<NodeWithSum>();
		for (int i = h1.length - 1; i >= 0; i--) {
			NodeWithSum tmpnode = new NodeWithSum();
			tmpnode.data = h1[i];
			tmpnode.sum = tmpnode.data + (tmps.isEmpty() ? 0 : tmps.peek().sum);
			tmps.add(tmpnode);
		}
		return tmps;
	}
}

class NodeWithSum {
	int data;
	int sum;

}