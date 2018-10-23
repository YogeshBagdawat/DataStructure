package com.yogi.ds.red.black.tree;

public class RedBlackBst<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	Node root;

	class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private boolean color;

		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}

		public Value get(Key key) {
			return get(root, key);
		}

		private Value get(Node root, Key key) {
			while (root != null) {
				int cmp = key.compareTo(root.key);
				if (cmp > 0)
					root = root.right;
				else if (cmp < 0)
					root = root.left;
				else
					return root.val;
			}
			return null;
		}

		public boolean contains(Key key) {
			return get(key) != null;
		}

		public void put(Key key, Value val) {
			root = insert(root, key, val);
			root.color = BLACK;
		}

		private Node insert(Node root, Key key2, Value val2) {
			if (root == null) {
				return new Node(key2, val2, BLACK);
			}
			int cmp = key.compareTo(root.key);
			if (cmp < 0) {
				root.left = insert(root.left, key2, val2);
			} else if (cmp > 0) {
				root.right = insert(root.right, key2, val2);
			} else {
				root.val = val2;
			}
			// balancing tree
			if (isRed(root.right) && !isRed(root.left)) {
				root = rotateLeft(root);
			} else if (isRed(root.left) && isRed(root.left.left)) {
				root = rotateRight(root);
			} else if (isRed(root.right) && isRed(root.left)) {
				flipColor(root);
			}
			return root;
		}

		private void flipColor(RedBlackBst<Key, Value>.Node root) {
			assert !isRed(root) && isRed(root.left) && isRed(root.right);
			root.color = RED;
			root.left.color = BLACK;
			root.right.color = BLACK;
		}

		private Node rotateRight(Node root) {
			assert root != null && isRed(root.left);
			Node temp = root.left;
			root.left = temp.right;
			temp.right = root;
			temp.color = root.color;
			root.color = RED;
			return temp;
		}

		private Node rotateLeft(RedBlackBst<Key, Value>.Node root) {
			assert root != null && isRed(root.right);
			Node temp = root.right;
			root.right = temp.left;
			temp.left = root;
			temp.color = root.color;
			root.color = RED;
			return temp;
		}

		private boolean isRed(RedBlackBst<Key, Value>.Node right2) {
			if (right2 == null) {
				return false;
			}
			return right2.color == RED;
		}
	}
}
