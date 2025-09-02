import java.util.HashMap;

// Problem: Construct Binary Tree from Preorder and Inorder Traversal.
// Platform Available : Leetcode 105 , GFG.
// Difficulty: Medium.
// Companies tag : Amazon , Adobe , Microsoft , Google , Apple , Oracle , VMware
// Walmart Global Tech , Linkdin , Cisco , Goldman Sachs , Infosys , Tcs , Wipro

public class ConstructTreePreorderAndInorder {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.val = key;
            this.left = null;
            this.right = null;
        }
    }

    static int preorderIdx = 0;

    public static TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map) {
        // STEP 1 : Edge case.
        if (start > end)
            return null;

        // STEP 2 : create node.
        TreeNode root = new TreeNode(preorder[preorderIdx++]);

        // STEP 3 : calculate inorderindex.
        int inorderIndex = map.get(root.val);

        // STEP 4 : go left and right and pass their range.
        root.left = helper(preorder, start, inorderIndex - 1, map);
        root.right = helper(preorder, inorderIndex + 1, end, map);

        return root;

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // STEP 1 : Create a hashmap that store val of inorder.
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // STEP 2 : create a helper function that return root.
        int start = 0;
        int end = preorder.length - 1;
        return helper(preorder, start, end, map);
    }
}
