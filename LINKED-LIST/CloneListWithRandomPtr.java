import java.util.HashMap;

// Problem: Copy List with Random Pointer.
// Platform Availaible: Leetcode 138 , GFG
// Difficulty : HARD.
// Companies tag : Flipkart , Morgan Stanley , Amazon , Microsoft , OYO Rooms , Snapdeal 
// D-E-Shaw , MakeMyTrip , Ola Cabs , Walmart , Adobe , BankBazaar , Uber , SalesForce 
// SamSung , VMware , Meta , MicroSoft , Google.

public class CloneListWithRandomPtr {
    // TIME COMPLEXITY : O(2N).
    // SPACE COMPLEXITY : O(N).
    static class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        // STEP 1 :  Create a Hashmap that store address
        // of original node or deep copy node.
        HashMap<Node, Node> map = new HashMap<>();

        // STEP 2 :  Create a Node pointer to iterate beacuse we don't want
        // to loose original head.
        Node current = head;
        while (current != null) {
            // Store original Node address and create deep copy
            // only take data and create new Node.
            map.put(current, new Node(current.data));
            current = current.next;
        }

        // STEP 3 : again current point to original head.
        current = head;
        while (current != null) {
            // Extract corresponding deep copy.
            Node copy = map.get(current);

            // update pointers.
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);

            // then move ahead for next iteration.
            current = current.next;
        }

        // STEP 4 : return deep copy head.
        return map.get(head);
    }
}
