// Problem: Linked List Group Reverse.
// Problem Link: https://www.geeksforgeeks.org/dsa/reverse-a-linked-list-in-groups-of-given-size/.
// Difficulty : HARD.
// Companies tag : Paytm , VMWare , Accolite , Amazon , Microsoft , Snapdeal , Hike , MakeMyTrip
// Walmart , Goldman Sachs , Adobe , SAP Labs.

public class LinkedListGroupReverse {
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
    public static Node reverseKGroup(Node head , int k){
        // STEP 1 : Reverse every k group of Node add Base case.
        if(head == null) return null;

        // STEP 2 : Normal Reverse a Linked List and also take a count that
        // tracks k element for evry iteration.
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // STEP 3 After that reverse another k Group and point
        // head.next.
        if(next != null){
           head.next = reverseKGroup(next, k);
        }

        // STEP 4 : After that return reverse node so return prev;
        return prev;
    }
}
