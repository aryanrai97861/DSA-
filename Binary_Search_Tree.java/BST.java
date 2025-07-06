// Definition of the BST
class TreeNode {
    int val; // Value of the node
    TreeNode left, right; // Left and right children

    // Constructor to create a new node with a value
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BST {
    TreeNode root; // Root of the BST

    // Constructor initializes empty tree
    public BST() {
        root = null;
    }

    // Public insert method (starts recursion)
    public void insert(int val) {
        root = insertRec(root, val);
    }

    // Recursive insert logic
    private TreeNode insertRec(TreeNode root, int val) {
        // Base case: insert at null position
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        // If value is less, go to left subtree
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        }
        // If value is greater, go to right subtree
        else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Public search method
    public TreeNode search(int val) {
        return searchRec(root, val);
    }

    // Recursive search logic
    private TreeNode searchRec(TreeNode root, int val) {
        // Base case: null or match found
        if (root == null || root.val == val) {
            return root;
        }

        // If value is less, go to left subtree
        if (val < root.val) {
            return searchRec(root.left, val);
        }

        // If value is greater, go to right subtree
        return searchRec(root.right, val);
    }

    // Public delete method
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    // Recursive delete logic
    private TreeNode deleteRec(TreeNode root, int val) {
        // Base case
        if (root == null) return root;

        // Recur down the tree
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            // Node found

            // Case 1: Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Case 2: Node with two children
            // Get inorder successor (smallest in right subtree)
            root.val = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    // Helper to find min value (inorder successor)
    private int minValue(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    // Public inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println(); // newline for clarity
    }

    // Recursive inorder traversal (Left → Root → Right)
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);      // Traverse left
            System.out.print(root.val + " "); // Visit root
            inorderRec(root.right);     // Traverse right
        }
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BST tree = new BST();

        // Inserting values into the BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder traversal: ");
        tree.inorder(); // Should print sorted order

        // Search for a node
        int target = 60;
        TreeNode found = tree.search(target);
        if (found != null)
            System.out.println("Node " + target + " found.");
        else
            System.out.println("Node " + target + " not found.");

        // Delete a node
        tree.delete(50);
        System.out.print("Inorder after deleting 50: ");
        tree.inorder();
    }
}
