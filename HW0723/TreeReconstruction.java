import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] preorder, int preStart, int preEnd,
                                       int[] inorder, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = buildPreIn(preorder, preStart + 1, preStart + numsLeft,
                               inorder, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(preorder, preStart + numsLeft + 1, preEnd,
                                inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] postorder, int postStart, int postEnd,
                                        int[] inorder, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = buildPostIn(postorder, postStart, postStart + numsLeft - 1,
                                inorder, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(postorder, postStart + numsLeft, postEnd - 1,
                                 inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode treeFromPreIn = buildTreeFromPreIn(preorder, inorder);
        System.out.print("前序+中序重建結果(中序遍歷驗證): ");
        inorderTraversal(treeFromPreIn);
        System.out.println();

        TreeNode treeFromPostIn = buildTreeFromPostIn(postorder, inorder);
        System.out.print("後序+中序重建結果(中序遍歷驗證): ");
        inorderTraversal(treeFromPostIn);
        System.out.println();
    }
}

