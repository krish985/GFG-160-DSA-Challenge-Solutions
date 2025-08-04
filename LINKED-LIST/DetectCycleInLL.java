// Problem: Detect Cycle In Linked List.
// Platform Availaible: Leetcode 141 , GFG
// Difficulty : Medium .
// Companies tag : Paytm , VMWare , Accolite , Amazon , OYO Rooms , Samsung ,Snapdeal
// D-E-Shaw , Hike , MakeMyTrip , Walmart , MAQ Software , Adobe , SAP Labs , Qualcomm
// Veritas , Mahindra ,  Comviva , Lybrate , Zoho , Oracle , Microsoft , Cisco , Ola
// Flipkart.

public class DetectCycleInLL {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean hasCycle(Node head){
        // * USE FLOYD CYCLE DETECTION ALGORITHM.
        // STEP 1 : We have to detect cycle in LL.
        // Take slow or fast pointer that initially
        // point Head.
        Node slow = head;
        Node fast = head;

        // STEP 2 : Iterate untill fast != null && fast.next != null
        // For odd even case.
        while(fast != null && fast.next != null){
            // Move Slow 1 step ahead.
            slow = slow.next;

            // Move fast 2 step ahaead.
            fast = fast.next.next;

            // if any point of time both are same place it means cycle
            // found return true.
            if(slow == fast){
                return true;
            }
        }

        // STEP 3 : If Not able to found cycle return false.
        return false;
    }
}
