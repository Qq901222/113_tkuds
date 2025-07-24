public class TreeComparison {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int d) {
            this.data = d;
        }
    }

    // 1. 判斷兩棵樹是否完全相同（結構和值都相同）
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.data != t.data) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // 2. 判斷 t 是否為 s 的子樹
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    // 3. 找出兩棵樹的最大公共子樹（最大相同子樹）
    // 傳回最大公共子樹根節點
    public static TreeNode maxCommonSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return null;

        if (isSameTree(s, t)) return s;

        TreeNode left = maxCommonSubtree(s.left, t);
        TreeNode right = maxCommonSubtree(s.right, t);

        if (left != null && right != null) {
            // 找到兩邊都有公共子樹，回傳較大(這裡以左為優先)
            // 也可以改成比較子樹大小的邏輯，但此為簡化版
            return left;
        }
        return left != null ? left : right;
    }

    // 幫助方法：建立測試樹
    public static TreeNode buildSampleTree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    public static TreeNode buildSampleTree2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        TreeNode s = buildSampleTree1();
        TreeNode t = buildSampleTree2();

        System.out.println("兩樹是否完全相同: " + isSameTree(s, t));
        System.out.println("t 是否為 s 的子樹: " + isSubtree(s, t));

        TreeNode maxCommon = maxCommonSubtree(s, t);
        if (maxCommon != null) {
            System.out.println("最大公共子樹根節點值: " + maxCommon.data);
        } else {
            System.out.println("無公共子樹");
        }
    }
}
