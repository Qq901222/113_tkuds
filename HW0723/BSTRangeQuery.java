import java.util.ArrayList;

public class BSTRangeQuery {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
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

    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        rangeQueryHelper(root, min, max, result);
        return result;
    }

    private static void rangeQueryHelper(TreeNode root, int min, int max, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.data > min) {
            rangeQueryHelper(root.left, min, max, result);
        }
        if (root.data >= min && root.data <= max) {
            result.add(root.data);
        }
        if (root.data < max) {
            rangeQueryHelper(root.right, min, max, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        insert(root, 10);
        insert(root, 30);
        insert(root, 5);
        insert(root, 15);
        insert(root, 25);
        insert(root, 35);

        ArrayList<Integer> result = rangeQuery(root, 12, 27);
        System.out.println(result); // [15, 20, 25]
    }
}
