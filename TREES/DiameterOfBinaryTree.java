// Problem: Diameter Of Binary Tree.
// Platform Available : Leetcode 543 , GFG.
// Difficulty: Easy.
// Companies tag : Amazone , MicroSoft , OyoRooms , Google , Meta , Apple , Adobe
// Walmart labs , Flipkart , Tcs Digital , Infosys , Wipro , Netflix , Uber , Ola
// Airbnb , Linkdin , DropBox , VMware , SalesForce , Intuite , Paypal , Goldman Sachs
// Morgan Stanley , DE shaw , Cred , Razorpay , Zomato , FreshWorks , Accenture.

public class DiameterOfBinaryTree{
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
    public static int helper(TreeNode root , int maxi[]){
        // STEP 1 : Edge Case -> if any point of time root reach null
        // return 0.
        if(root == null) {
            return 0;
        }

        // STEP 2 : Just Calculate Normal height go left and right
        // then compute prev maxi[0] ans left height + rightheight of max.
        int lh = helper(root.left, maxi);
        int rh = helper(root.right, maxi);

        maxi[0] = Math.max(maxi[0], lh + rh);

        // STEP 3 : Now compute height max of lh , rh + 1.
        return Math.max(lh, rh) + 1;
     
    }
    public static int findDiameter(TreeNode root){
        // STEP 1 : take a max array or 1 size it store 
        // max height lh + rh and their previous ans.
        int maxi[] = {0};

        // STEP 2 : Call the helper func that calculate diameter.
        helper(root , maxi);

        // STEP 3 : Return that maxi.
        return maxi[0];
    }
}