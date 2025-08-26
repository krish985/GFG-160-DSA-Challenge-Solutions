// Problem: Mirror Binary Tree.
// Platform Available : Leetcode 226 , GFG.
// Difficulty: Easy.
// Companies tag : Paytm , VMWare , Morgan Stanley , Accolite , Amazon , Microsoft 
// Samsung , Snapdeal , Ola Cabs , Walmart , Goldman Sachs , Adobe , Google , SAP Labs
// Myntra , Belzabar , eBay , PropTiger , Cred , Razorpay , Phonepay , Oracle.

public class MirrorTree {
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
    public static void invertTree(TreeNode root){
        // STEP 1 : Edge case if any point of time root reach null return 
        if(root == null){
            return;
        }

        // STEP 2 : Go left then right
        invertTree(root.left);
        invertTree(root.right);

        // STEP 3 : SWAP left or right sub tree.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static TreeNode mirror(TreeNode root){
        // Call invert function then return root.
        invertTree(root);
        return root;
    }
}
