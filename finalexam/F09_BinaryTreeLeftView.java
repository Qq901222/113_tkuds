import java.util.*;

public class F09_BinaryTreeLeftView {
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
        List<Integer> leftView = getLeftView(root);
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
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

    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == 0) result.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return result;
    }
}
