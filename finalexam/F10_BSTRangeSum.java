import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        TreeNode root = buildTree(parts);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
        sc.close();
    }

    private static TreeNode buildTree(String[] parts) {
        if (parts.length == 0 || parts[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode curr = q.poll();
            if (i < parts.length && !parts[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(curr.left);
            }
            i++;
            if (i < parts.length && !parts[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    private static int rangeSum(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSum(root.right, L, R);
        if (root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }
}
