import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; }
    }

    // 1. 計算任意兩節點間距離
    public static int distanceBetweenNodes(TreeNode root, int n1, int n2) {
        TreeNode lca = lowestCommonAncestor(root, n1, n2);
        if (lca == null) return -1;
        return distanceFromAncestor(lca, n1) + distanceFromAncestor(lca, n2);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;

        TreeNode left = lowestCommonAncestor(root.left, n1, n2);
        TreeNode right = lowestCommonAncestor(root.right, n1, n2);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private static int distanceFromAncestor(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.data == val) return 0;
        int leftDist = distanceFromAncestor(root.left, val);
        if (leftDist >= 0) return leftDist + 1;
        int rightDist = distanceFromAncestor(root.right, val);
        if (rightDist >= 0) return rightDist + 1;
        return -1;
    }

    // 2. 找出樹的直徑（最大距離）
    // 直徑是任意兩節點間的最大距離，經過的邊數
    static int diameter = 0;

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        heightForDiameter(root);
        return diameter;
    }

    private static int heightForDiameter(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = heightForDiameter(node.left);
        int rightHeight = heightForDiameter(node.right);

        // 更新直徑為左右子樹高度和（經過此節點的最大距離）
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 3. 找出距離根節點指定距離的所有節點
    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        findNodesAtDistanceK(root, k, res);
        return res;
    }

    private static void findNodesAtDistanceK(TreeNode node, int k, List<Integer> res) {
        if (node == null) return;
        if (k == 0) {
            res.add(node.data);
            return;
        }
        findNodesAtDistanceK(node.left, k - 1, res);
        findNodesAtDistanceK(node.right, k - 1, res);
    }

    // 測試用插入BST (簡單版)
    public static void insert(TreeNode root, int val) {
        if (val < root.data) {
            if (root.left == null) root.left = new TreeNode(val);
            else insert(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else insert(root.right, val);
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

        System.out.println("節點5與18距離: " + distanceBetweenNodes(root, 5, 18)); // 預期4

        System.out.println("樹的直徑: " + treeDiameter(root)); // 可能是4或5，取決於邊數定義

        List<Integer> dist2Nodes = nodesAtDistanceK(root, 2);
        System.out.println("距離根節點2的節點: " + dist2Nodes);
    }
}
