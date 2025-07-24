public class TreeStatistics {

    // 二元樹節點類別
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 計算樹中所有節點值的總和
    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }

    // 找出樹中的最大值
    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE; // 若為空，回傳最小整數
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // 找出樹中的最小值
    public static int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE; // 若為空，回傳最大整數
        }
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    // 計算所有葉節點的數量
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 計算樹的深度（高度）
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // 建立範例二元樹
        /*
                10
               /  \
              5    20
             / \   /
            3   7 15
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        // 測試功能
        System.out.println("樹中所有節點值的總和: " + sum(root));
        System.out.println("樹中的最大值: " + findMax(root));
        System.out.println("樹中的最小值: " + findMin(root));
        System.out.println("所有葉節點的數量: " + countLeaves(root));
        System.out.println("樹的深度（高度）: " + depth(root));
    }
}
