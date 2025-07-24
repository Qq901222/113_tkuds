import java.util.*;

public class BSTValidation {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBSTHelper(node.left, min, node.data) &&
               isValidBSTHelper(node.right, node.data, max);
    }

    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalidNodes = new ArrayList<>();
        findInvalidNodesHelper(root, Long.MIN_VALUE, Long.MAX_VALUE, invalidNodes);
        return invalidNodes;
    }

    private static void findInvalidNodesHelper(TreeNode node, long min, long max, List<TreeNode> invalidNodes) {
        if (node == null) return;

        if (node.data <= min || node.data >= max) {
            invalidNodes.add(node);
        }

        findInvalidNodesHelper(node.left, min, node.data, invalidNodes);
        findInvalidNodesHelper(node.right, node.data, max, invalidNodes);
    }

    public static int countRemovalsForValidBST(TreeNode root) {
        List<TreeNode> invalidNodes = findInvalidNodes(root);
        return invalidNodes.size();
    }

    public static void insert(TreeNode root, int value) {
        if (value < root.data) {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                insert(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                insert(root.right, value);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12); // invalid
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);

        System.out.println("是否為有效BST: " + isValidBST(root)); // false

        List<TreeNode> invalidNodes = findInvalidNodes(root);
        System.out.print("不符合規則的節點: ");
        for (TreeNode node : invalidNodes) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        System.out.println("需要移除的節點數: " + countRemovalsForValidBST(root)); // 1
    }
}
