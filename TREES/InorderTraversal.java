import java.util.ArrayList;

// Problem: Binary Tree Inorder Traversal.
// Platform Available : Leetcode 94 , GFG.
// Difficulty: EASY.
// Companies tag : Amazon , Adobe , Microsoft , Google , Apple , Oracle , VMware
// Walmart Global Tech , Cisco , Goldman Sachs , Infosys , Tcs , Wipro

public class InorderTraversal {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
     
    public static void helper(TreeNode root , ArrayList<Integer> result){
        // STEP 1 : Edge case if root reach null simply return that.
        if(root == null) {
            return;
        }

        // STEP 2 : GO LEFT -> store val -> go right.
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
    public static ArrayList<Integer> inorderTree(TreeNode root){
        // STEP 1 : Create a array list of integer that store inorder sequence.
        ArrayList<Integer> result = new ArrayList<>();

        // STEP 2 : Call a helper function that store sequence.
        helper(root , result);

        // STEP 3 : Return list
        return result;
    }
}
