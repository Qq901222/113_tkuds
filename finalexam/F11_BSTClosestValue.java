import java.util.*;

public class F11_BSTClosestValue {
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
        int target = sc.nextInt();
        int closest = findClosest(root, target);
        System.out.println("Closest: " + closest);
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

    private static int findClosest(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            int diff = Math.abs(root.val - target);
            int bestDiff = Math.abs(closest - target);
            if (diff < bestDiff || (diff == bestDiff && root.val < closest)) {
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return closest;
    }
}

