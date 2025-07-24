public class BSTKthElement {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static int findKthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inorder(root, k, counter);
        return counter.result;
    }

    private static void inorder(TreeNode root, int k, Counter counter) {
        if (root == null) return;

        inorder(root.left, k, counter);

        counter.count++;
        if (counter.count == k) {
            counter.result = root.data;
            return;
        }

        inorder(root.right, k, counter);
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
        TreeNode root = new TreeNode(20);
        insert(root, 10);
        insert(root, 30);
        insert(root, 5);
        insert(root, 15);
        insert(root, 25);
        insert(root, 35);

        int k = 3;
        int kthSmallest = findKthSmallest(root, k);
        System.out.println("第 " + k + " 小的元素是: " + kthSmallest); // 第 3 小應為 15
    }
}
