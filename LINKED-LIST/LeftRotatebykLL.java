// Problem: Rotate a Linked List.
// Problem Link : https://www.geeksforgeeks.org/dsa/rotate-a-linked-list/.
// Difficulty : Medium.
// Companies tag : Accolite , Amazon , Microsoft , MakeMyTrip.

public class LeftRotatebykLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node rotatek(Node head , int k){
        // STEP 1 Handel Edge Cases.
        if(head == null) return null;
        if(head.next == null) return head;

        // STEP 2 : Count length of LL.
        Node temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }

        // STEP 3 : Check by modulo if length % k == 0
        // No need to ratoate return head itself.
        k = k  % length;
        if(k == 0) return head;

        // STEP 4 : If k not equal 0 make you LL Circular.
        // point temp.next = head;
        temp.next = head;

        // STEP 5 : Iterate starting of LL < k length one step back
        // that's why starting with i = 1.
        Node pointer = head;
        for(int i=1; i<k; i++){
            pointer = pointer.next;
        }

        // STEP 6 : Now make head = pointer.next where LL Start
        // then pointer.next = null.
        head = pointer.next;
        pointer.next = null;

        // STEP 7 : Return head Now LL rotate by k time .
        return head;
    }
}
