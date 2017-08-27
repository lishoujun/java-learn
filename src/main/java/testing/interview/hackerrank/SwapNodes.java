package testing.interview.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Queue<Node> nodeQueue = new LinkedList<>();
		Node root = new Node(1);
		nodeQueue.add(root);
		while (N-- > 0) {
			Node newNode = new Node(in.nextInt());
			if (newNode.data != -1) {
				nodeQueue.peek().left = newNode;
				nodeQueue.add(newNode);
			}
			newNode = new Node(in.nextInt());
			if (newNode.data != -1) {
				nodeQueue.peek().right = newNode;
				nodeQueue.add(newNode);
			}
			nodeQueue.remove();
		}
		int T = in.nextInt();
		while (T-- > 0) {
			int K = in.nextInt();
			swapNodes(root, 1, K);
			inorder(root);
			System.out.println();
		}
		in.close();
	}

	/*
	 * 节点 当前深度 交换基数
	 */
	private static void swapNodes(Node root, int i, int k) {
		if (root.left != null)
			swapNodes(root.left, i + 1, k);
		if (root.right != null)
			swapNodes(root.right, i + 1, k);
		if (i % k == 0) {
			Node tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}

	}

	private static void inorder(Node root) {
		if (root.data == -1) {
			return;
		}
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.data + " ");
		if (root.right != null)
			inorder(root.right);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}
