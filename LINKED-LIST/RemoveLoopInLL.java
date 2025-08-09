// Problem: Remove loop in Linked List.
// Problem Link : https://www.geeksforgeeks.org/dsa/detect-and-remove-loop-in-a-linked-list/.
// Difficulty : Medium .
// Companies tag : VMWare , Morgan Stanley , Amazon , Microsoft , Snapdeal , MakeMyTrip
// Oracle , Walmart , Goldman Sachs , Adobe , Qualcomm , Kuliza , Netskope , Google , TCS
// INFOSYS , Cognizant , Wipro , Flipkart.

public class RemoveLoopInLL {
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
    public static void removeLoop(Node head){
        // STEP 1 : Create a Slow fast pointer to detect if loop
        // present or not.
        Node slow = head;
        Node fast = head;

        // STEP 2 : Check for loop.
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // Found loop.
            if(slow == fast) break;
        }

        // STEP 3 : Point slow to be head.
        slow = head;

        // STEP 4 : Chcek special case loop start from head.
        if(slow == fast){
            // move fast untill fast.next != null.
            while(fast.next != null){
                fast = fast.next;
            }
            // After that point fast.next to be null.
            fast.next = null;
        }else{
            // Create a prev pointer that tract fast previous val.
            Node prev = null;
            while(slow != fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            // point prev.next = null to remove cycle.
            prev.next = null; 
        }
    }
}
