// Problem: Height Of Binary Tree.
// Problem Link : https://www.geeksforgeeks.org/problems/height-of-binary-tree/1.
// Difficulty: EASY.
// Companies tag :  VMWare , Zoho , Amazon , Microsoft , Snapdeal , D-E-Shaw , FactSet
// MakeMyTrip , Teradata , Synopsys , CouponDunia , Cadence India , Monotype Solutions
// FreeCharge , Google , Infosys , TCS , Apple , Oracle , Cisco , Intuite , Salesforce
// Wipro Elite .

public class HeightOfBinaryTree {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(TreeNode root){
        // STEP 1 : Base cases.
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        // STEP 2 : Whatever right or left subtree returning tak maximum
        // and add with + 1 then return.
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
