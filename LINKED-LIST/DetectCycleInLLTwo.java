// Problem: Find the first node of loop in linked list.
// Platform Availaible: Leetcode 142 , GFG
// Difficulty : Medium .
// Companies tag : Meta , Amazon , Apple , Netflix , Google , Microsoft , Adobe , Linkdin
// Salesforce , Flipkart , Paytm , Swiggy , Zomato , Curefit , Razorpay , Ola , Oyo , Inmobi
// Cred , Infosys , Wipro , Hcl , Tech-Mahindra , Congnizant , Capgemini , Dream 11 , Mesho
// Phonepay , Grow , Uber , Airbnb , X(twitter) , Oracle , VMware , NVIDIA , Qualcomm 
// Samsung R&D , Intel , Cisco. 

public class DetectCycleInLLTwo {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findFirstNode(Node head) {
        // STEP 1 : Handel Edge Cases.
        if(head == null || head.next == null){
            return null;
        }

        // STEP 2 : Apply Slow and fast Pointer Approach.
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            // Move slow 1 step and fast 2 step ahead.
            slow = slow.next;
            fast = fast.next.next;

            // If Slow and Fast pointer meet
            if(slow == fast){
                // then slow point to head.
                slow = head;
                // move slow and fast pointer both one step at a time
                // untill slow != fast means equivalient
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                // return slow or false.
                return slow;
            }
        }
        
        // STEP 3 : IF cycle is not found return null.
        return null;
    }
}
