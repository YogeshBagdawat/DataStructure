package com.yogi.ds.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.print.attribute.ResolutionSyntax;

class Node {
	int key;
	Node left;
	Node right;

	Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
}

class NodeNextRight {
	int key;
	NodeNextRight left, right, nextRight;

	public NodeNextRight(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
}

public class BinaryTree {
	private static final NodeNextRight rootNodeNextRight = null;
	int key;
	int maxSize;
	Node root;
	Queue<Node> q = new LinkedList<>();
	Queue<NodeNextRight> qr = new LinkedList<>();

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(int key) {
		this.key = key;
		root = new Node(this.key);
	}

	public static void main(String[] args) {
		BinaryTree bin = new BinaryTree();
		int[] in = { 4, 2, 1, 3 };
		int[] pre = { 1, 2, 3, 4 };
		bin.root = bin.construtTreeFromInorderPreOrder(in, pre, 0);
		bin.printInOrder();
		// bin.root.left = new Node(4);
		// bin.root.right = new Node(6);
		// bin.root.left.left = new Node(4);
		// bin.root.left.right = new Node(3);
		// bin.root.right.left = new Node(6);
		// bin.root.right.left.right = new Node(7);
		// bin.root.right.left.left = new Node(8);
		// BinaryTree bin2 = new BinaryTree(26);
		// bin2.root.left = new Node(10);
		// bin2.root.right = new Node(3);
		// bin2.root.right.right = new Node(3);
		// bin2.root.left.left = new Node(4);
		// bin2.root.left.right = new Node(6);
		// bin2.root.left.left.right = new Node(30);
		// System.out.println(bin.isSubtreeOfAnotherTree(bin.root, bin2.root));

		/*
		 * bin.root.right.right = new Node(7); bin.root.right.right.left = new
		 * Node(7);
		 */
		/*
		 * bin.printPreOrder(); System.out.println(); bin.printInOrder();
		 * System.out.println(); bin.inOrderTraversalWithoutReccursion();
		 * System.out.println();
		 * bin.inOrderTraversalUsingThreadedTree(bin.root);
		 * System.out.println(); bin.printPostOrder(); System.out.println();
		 * bin.printLevelOrder(); System.out.println();
		 * System.out.println(bin.diameterOfBinaryTree());
		 */
		// System.out.println(bin.getMaxWidth());
		// bin.printNodesAtKDistance(2);
		// System.out.println();
		bin.printAnscestor(1);
	}

	private void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node root2) {
		if (root2 == null) {
			return;
		}
		printPostOrder(root2.left);
		printPostOrder(root2.right);
		System.out.print(root2.key + " ");
	}

	private void printInOrder(Node root2) {
		if (root2 == null) {
			return;
		}
		printInOrder(root2.left);
		System.out.print(root2.key + " ");
		printInOrder(root2.right);
	}

	private void printInOrder() {
		printInOrder(root);
	}

	private void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node root2) {
		if (root2 == null) {
			return;
		}
		System.out.print(root2.key + " ");
		printPreOrder(root2.left);
		printPreOrder(root2.right);
	}

	private void printLevelOrder() {
		printLevelOrder(root);
	}

	private void printLevelOrder(Node root2) {
		if (root2 == null) {
			return;
		}
		System.out.print(root2.key + " ");
		if (root2.left != null) {
			q.add(root2.left);
		}
		if (root2.right != null) {
			q.add(root2.right);
		}
		printLevelOrder(q.poll());
	}

	private int getMaxWidth() {
		q.clear();
		return getMaxWidth(root);
	}

	private int getMaxWidth(Node root2) {
		q.add(root2);
		int max = 1;
		while (!q.isEmpty()) {
			int count = q.size();
			max = max < count ? count : max;
			while (count-- > 0) {
				Node t = q.poll();
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			}
		}
		return max;
	}

	public void inOrderTraversalWithoutReccursion() {
		Node temp = root;
		Stack<Node> s = new Stack<>();
		while (temp.left != null) {
			s.push(temp);
			temp = temp.left;
		}
		System.out.print(temp.key + " ");
		while (!s.isEmpty()) {
			Node te = s.pop();
			System.out.print(te.key + " ");
			if (te.right != null) {
				te = te.right;
				Node lete = te;
				while (lete != null) {
					s.push(lete);
					lete = lete.left;
				}
			}
		}
	}

	public int diameterOfBinaryTree() {
		return diameterOfBinaryTree(root);
	}

	private int diameterOfBinaryTree(Node root2) {
		if (root2 == null) {
			return 0;
		}
		int lHeight = height(root2.left);
		int rHeight = height(root2.right);
		int ldiameter = diameterOfBinaryTree(root2.left);
		int rdiameter = diameterOfBinaryTree(root2.right);
		return ldiameter > rdiameter ? (ldiameter > (1 + lHeight + rHeight) ? ldiameter : 1 + lHeight + rHeight)
				: (rdiameter > (1 + lHeight + rHeight) ? rdiameter : (1 + lHeight + rHeight));
	}

	private int height(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + max(height(root.left), height(root.right));
	}

	private int max(int height, int height2) {

		return height > height2 ? height : height2;
	}

	public void inOrderTraversalUsingThreadedTree(Node current) {
		Node pre;
		if (current == null) {
			return;
		}
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.key + " ");
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.print(current.key + " ");
					current = current.right;
				}
			}
		}
	}

	private void connectNextRight() {
		q.clear();
		connectNextRight(rootNodeNextRight);
	}

	private void connectNextRight(NodeNextRight root2) {
		qr.add(root2);
		while (!qr.isEmpty()) {
			NodeNextRight p = qr.peek();
			qr.remove();
			if (p != null) {
				p.nextRight = qr.peek();
				if (p.left != null) {
					qr.add(p.left);
				}
				if (p.right != null) {
					qr.add(p.right);
				}
			} else if (!qr.isEmpty()) {
				qr.add(null);
			}
		}
	}

	public void printNodesAtKDistance(int k) {
		printNodesAtKDistanceRecur(root, k);
	}

	public void printNodesAtKDistanceRecur(Node root2, int k) {
		if (root2 == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(root2.key + " ");
		}
		printNodesAtKDistanceRecur(root2.left, k - 1);
		printNodesAtKDistanceRecur(root2.right, k - 1);
	}

	public boolean printAnscestor(int k) {
		if (k == root.key) {
			return false;
		}
		return printAnscestor(root, k);
	}

	private boolean printAnscestor(Node root2, int k) {
		if (root2 == null) {
			return false;
		}
		if (root2.key == k) {
			return true;
		}
		/*
		 * if (root2.left != null && root2.left.key == k) {
		 * System.out.println(root2.key); return true; } if (root2.right != null
		 * && root2.right.key == k) { System.out.println(root2.key); return
		 * true; }
		 */
		if (printAnscestor(root2.left, k) || printAnscestor(root2.right, k)) {
			System.out.println(root2.key);
			return true;
		}
		return false;
	}

	public boolean isSubtreeOfAnotherTree(Node root1, Node root2) {
		if (root2 == null && root1 == null) {
			return true;
		}
		if (root2 == null) {
			return false;
		}
		if (root1.key == root2.key) {
			if (isSubtreeOfAnotherTree(root1.left, root2.left) && isSubtreeOfAnotherTree(root1.right, root2.right)) {
				return true;
			} else
				return false;
		}

		return isSubtreeOfAnotherTree(root1, root2.left) || isSubtreeOfAnotherTree(root1, root2.right);

	}

	public Node construtTreeFromInorderPreOrder(int[] in, int[] pr, int r) {
		if (in.length == 0) {
			return null;
		}
		if(in.length == 1) {
			Node root = new Node(in[0]);
			return root;
		}
		Node root = new Node(pr[r]);
		int i = 0;
		while (in.length>i&&in[i] != pr[r]) {
			i++;
		}
		int[] inl = new int[i];
		// int[] prl = new int[i];
		int[] inr = new int[in.length - (i+1)];
		// int[] prr = new int[in.length-(i+1)];
		i = 0;
		int j = 0;
		while (i < inl.length) {
			inl[i] = in[i++];
		}
		i++;
		while (i < in.length) {
			inr[j++] = in[i++];
		}
		root.left = construtTreeFromInorderPreOrder(inl, pr, r+1);
		root.right = construtTreeFromInorderPreOrder(inr, pr, r+1);
		return root;
	}
}