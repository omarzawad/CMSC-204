package MorseCode1;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String> {
	private TreeNode<String> root = null; // root of the tree, which is set to null when the tree is empty

	private String fetchedLetter; // variable to hold the String letter, which the fetch method will return

	/**
	 * Constructor - calls the buildTree method
	 * 
	 * @author Omar Mahmud
	 */
	public MorseCodeTree() {
		buildTree(); // call the buildTree method to create the tree, and place the letters for the
						// morse code decoder in the correct position.
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// If there is only one character in the morse code
		if (code.length() == 1) {
			// if the character is '.' (dot) store to the left of the current root
			if (code.equals(".")) {
				root.lc = new TreeNode<String>(letter);
			}
			// else if the character is "-" (dash) store to the right of the current root
			else {
				root.rc = new TreeNode<String>(letter);
			}

			return;
		} else {
			// if the first character is '.' (dot) new root becomes the left child
			if (code.substring(0, 1).equals(".")) {
				// recursively call addNode(new root, new code, letter)
				// new code becomes all the remaining characters in the code (beyond the first
				// character)
				addNode(root.lc, code.substring(1), letter);
			}

			// else if the first character is "-" (dash) new root becomes the right child
			else {
				// recursively call addNode(new root, new code, letter)
				// new code becomes all the remaining characters in the code (beyond the first
				// character)
				addNode(root.rc, code.substring(1), letter);
			}
		}
	}

	@Override
	public MorseCodeTree insert(java.lang.String code, java.lang.String letter) {
		// calls the recursive method addNode
		addNode(root, code, letter);

		return this;
	}

	@Override
	public void buildTree() {
		// The root will have a value of "" (empty string)
		root = new TreeNode<String>("");

		// First Level
		insert(".", "e");
		insert("-", "t");

		// Second Level
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");

		// Third Level
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		// Fourth Level
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns a reference to the root
	 * 
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {

		root = newNode;
	}

	@Override
	public java.lang.String fetch(java.lang.String code) {
		// calls the recursive method fetchNode
		String letter = fetchNode(root, code);

		return letter;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code A '.' (dot) means traverse to the left. A "-"
	 * (dash) means traverse to the right. The code ".-" would fetch the data of the
	 * TreeNode stored as the right child of the left child of the root
	 *
	 * @param root the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code) {
		// If there is only one character in the morse code
		if (code.length() == 1) {
			// if the character is '.' (dot) retrieve the data from the left child of root
			if (code.equals(".")) {
				fetchedLetter = root.lc.getData();
			}

			// else if the character is '-' (dash) retrieve the data from the right child of
			// root
			else {
				fetchedLetter = root.rc.getData();
			}
		} else {
			// if the first character is '.' (dot) new root becomes the left child
			if (code.substring(0, 1).equals(".")) {
				// recursively call fetchNode(new root, new code)
				// new code becomes all the remaining characters in the code (beyond the first
				// character)
				fetchNode(root.lc, code.substring(1));
			}

			// if the first character is '-' (dash) new root becomes the right child
			else {
				// recursively call fetchNode(new root, new code)
				// new code becomes all the remaining characters in the code (beyond the first
				// character)
				fetchNode(root.rc, code.substring(1));
			}
		}

		// Return the corresponding letter to the morse code
		return fetchedLetter;
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder)
	 * Traversal order. Used for testing to make sure tree is built correctly
	 *
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList() {
		ArrayList<String> printTree = new ArrayList<String>();

		LNRoutputTraversal(root, printTree);

		return printTree;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR
	 * (Inorder)
	 *
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list) {
		if (root != null) {
			// recursive method to traverse through the binary tree in LNR (Inorder)
			LNRoutputTraversal(root.lc, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rc, list);
		}
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}

}
