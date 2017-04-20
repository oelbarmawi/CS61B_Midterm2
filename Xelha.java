import java.util.ArrayList;
import java.util.Collections;

public class Xelha {

	public class Node {
		public int item;
		public Node left;
		public Node right;

		public Node(int i, Node l, Node r) {
			item = i;
			left = l;
			right = r;
		}
	}

	private Node root;

	public Xelha(ArrayList<Integer> nums) {
		for (int n : nums) {
			insertNode(n);
		}
	}

	public void insertNode(int num) {
		if (root == null) {
			root = new Node(num, null, null);
		} else if (num < root.item) {
			Node newRoot = new Node(num, root, null);
			root = newRoot;
		} else if (num >= root.item) {
			if (root.right != null) {
				Node rightSubTree = root.right;
				while (rightSubTree.right != null) {
					rightSubTree = rightSubTree.right;
				}
				rightSubTree.right = new Node(num, null, null);
			} else {
				root.right = new Node(num, null, null);
			}
		}
	}

	public int getRoot() {
		return root.item;
	}

	public void inOrderPrint() {
		inOrderPrint(root);
	}

	private void inOrderPrint(Node root) {
		if (root == null) {
			return;
		}
		inOrderPrint(root.left);
		System.out.print(root.item + ", ");
		inOrderPrint(root.right);
	}


	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(8);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		numbers.add(7);
		numbers.add(7);

		for (int i = 0; i < 5; i++) {
			Collections.shuffle(numbers);
			System.out.println("\n\nEXPECTED:");
			for (int n : numbers) {
				System.out.print(n + ", ");
			}
			Xelha xTree = new Xelha(numbers);
			System.out.println();
			System.out.println("ACTUAL:");
			xTree.inOrderPrint();
		}
	}
}