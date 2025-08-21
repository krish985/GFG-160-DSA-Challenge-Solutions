import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem: Binary Tree Level Order Traversal.
// Platform Available : Leetcode 102 , GFG.
// Difficulty: Medium.
// Companies tag : Flipkart , Morgan Stanley , Accolite , Amazon , Microsoft , Samsung
// D-E-Shaw , Ola Cabs , Payu , Adobe , Cisco , Qualcomm , Google , Linkdin.

public class LevelOrderTraversal{
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(N).
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
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        // STEP 1 : Create a list of list to store sequence of level order.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // STEP 2 : Create a Queue that allow you fifo Operations.
        Queue<TreeNode> queue = new LinkedList<>();

        // STEP 3 : Check if root null return empty list else add root
        // into queue.
        if(root == null){
            return result;
        }else{
            queue.add(root);
        }

        // STEP 4 : Iterate untill queue is empty and perform some operation.
        while(!queue.isEmpty()){
            // Extract queue size for every level.
            int size = queue.size();

            // Create a temp list to store individual level sequence.
            ArrayList<Integer> temp = new ArrayList<>();

            // iterate 0 to size.
            for(int i=0; i<size; i++){
                // remove top elemnt into queue.
                TreeNode tempData = queue.poll();

                // Add into temp list.
                temp.add(tempData.data);

                // if temp data right or left != null add into queue.
                if(tempData.left != null){
                    queue.add(tempData.left);
                }
                if(tempData.right != null){
                    queue.add(tempData.right);
                }
            }
            
            // Final add temp into final result.
            result.add(temp);
        }

        // STEP 5 : Return final result.
        return result;
    }
}