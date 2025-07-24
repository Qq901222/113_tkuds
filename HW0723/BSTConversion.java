public class BSTConversion {

    static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int val) { data = val; }
    }

    // 1. BST轉排序雙向鏈表（left指向prev，right指向next）
    static TreeNode prev = null;
    static TreeNode head = null;

    public static TreeNode bstToDoublyLinkedList(TreeNode root) {
        if (root == null) return null;
        bstToDoublyLinkedList(root.left);
        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        bstToDoublyLinkedList(root.right);
        return head;
    }

    // 2. 排序陣列轉平衡BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length -1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid -1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    // 3. BST改為Greater Tree (節點值改為所有>=該值節點的總和)
    static int sum = 0;
    public static void convertBSTtoGreaterTree(TreeNode root) {
        if (root == null) return;
        convertBSTtoGreaterTree(root.right);
        sum += root.data;
        root.data = sum;
        convertBSTtoGreaterTree(root.left);
    }

    // 中序遍歷印出樹節點
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 新增BST節點
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
        // 測試BST轉雙向鏈表
        TreeNode root = new TreeNode(10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 12);
        insert(root, 18);

        TreeNode listHead = bstToDoublyLinkedList(root);
        System.out.print("雙向鏈表: ");
        TreeNode curr = listHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();

        // 測試排序陣列轉BST
        int[] sorted = {1,2,3,4,5,6,7};
        TreeNode bst = sortedArrayToBST(sorted);
        System.out.print("排序陣列轉BST中序遍歷: ");
        inorder(bst);
        System.out.println();

        // 測試BST轉Greater Tree
        sum = 0; // reset
        convertBSTtoGreaterTree(root);
        System.out.print("BST轉Greater Tree中序遍歷: ");
        inorder(root);
        System.out.println();
    }
}

