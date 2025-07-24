import java.util.*;

public class TreePathProblems {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(root, current, paths);
        return paths;
    }

    private static void dfs(TreeNode node, List<Integer> current, List<List<Integer>> paths) {
        if (node == null) return;

        current.add(node.data);

        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(current));
        } else {
            dfs(node.left, current, paths);
            dfs(node.right, current, paths);
        }

        current.remove(current.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.data) ||
               hasPathSum(root.right, targetSum - root.data);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        maxPathSumHelper(root, 0, new ArrayList<>(), maxPath, new int[]{Integer.MIN_VALUE});
        return maxPath;
    }

    private static void maxPathSumHelper(TreeNode node, int currentSum, List<Integer> currentPath,
                                         List<Integer> maxPath, int[] maxSum) {
        if (node == null) return;

        currentSum += node.data;
        currentPath.add(node.data);

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(currentPath);
            }
        } else {
            maxPathSumHelper(node.left, currentSum, currentPath, maxPath, maxSum);
            maxPathSumHelper(node.right, currentSum, currentPath, maxPath, maxSum);
        }

        currentPath.remove(currentPath.size() - 1);
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

        System.out.println("所有根到葉節點的路徑:");
        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        int targetSum = 22;
        System.out.println("是否存在和為 " + targetSum + " 的路徑: " + hasPathSum(root, targetSum));

        List<Integer> maxPath = maxPathSum(root);
        System.out.println("和最大的根到葉路徑: " + maxPath);
    }
}
