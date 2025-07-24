public class BSTBalance {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; }
    }

    // 1. 檢查是否為平衡樹（任意節點左右子樹高度差不超過1）
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳高度，若不平衡回傳-1
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 2. 計算節點的平衡因子（左子樹高度 - 右子樹高度）
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // 3. 找出BST中最不平衡的節點（平衡因子絕對值最大者）
    static TreeNode mostUnbalancedNode = null;
    static int maxImbalance = -1;

    public static void findMostUnbalancedNode(TreeNode root) {
        maxImbalance = -1;
        mostUnbalancedNode = null;
        findUnbalancedHelper(root);
    }

    private static void findUnbalancedHelper(TreeNode node) {
        if (node == null) return;
        int bf = Math.abs(getBalanceFactor(node));
        if (bf > maxImbalance) {
            maxImbalance = bf;
            mostUnbalancedNode = node;
        }
        findUnbalancedHelper(node.left);
        findUnbalancedHelper(node.right);
    }

    // 測試用插入BST (簡單版，不平衡不調整)
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
        insert(root, 1);
        insert(root, 0);

        System.out.println("是否平衡樹: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + getBalanceFactor(root));

        findMostUnbalancedNode(root);
        if (mostUnbalancedNode != null) {
            System.out.println("最不平衡節點值: " + mostUnbalancedNode.data + ", 平衡因子絕對值: " + maxImbalance);
        }
    }
}
