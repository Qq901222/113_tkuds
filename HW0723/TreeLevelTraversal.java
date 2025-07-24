import java.util.*;

public class TreeLevelTraversal {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.data);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.data);
                } else {
                    level.addFirst(node.data);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void printLastNodeEachLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.println("每層最後一個節點:");
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastNode = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastNode = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (lastNode != null) {
                System.out.println(lastNode.data);
            }
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 12);
        insert(root, 18);

        List<List<Integer>> levelOrderResult = levelOrder(root);
        System.out.println("普通層序遍歷:");
        for (List<Integer> level : levelOrderResult) {
            System.out.println(level);
        }

        List<List<Integer>> zigzagResult = zigzagLevelOrder(root);
        System.out.println("之字形層序遍歷:");
        for (List<Integer> level : zigzagResult) {
            System.out.println(level);
        }

        printLastNodeEachLevel(root);
    }
}

