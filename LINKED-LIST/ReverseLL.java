// Problem: Reverse a Linked List.
// Platform Availaible: Leetcode 206 , GFG
// Difficulty : Easy.
// Companies tag : Paytm , VMWare , Zoho , Accolite , Amazon , Microsoft , Samsung 
// Snapdeal , D-E-Shaw , MakeMyTrip , Teradata , Walmart , Goldman Sachs , Intuit 
// Adobe , SAP Labs , Tejas Network , Cisco , Qualcomm , Cognizant , Mahindra Comviva
// IgniteWorld , HCL , Deloitee , Paypal , IBM , Oracle , Uber , Netflix , Meta , Apple
// TCS , Infosys.

public class ReverseLL{
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
    public static Node reverseList(Node head){
        // STEP 1 : Initially Take Three pointer.
        // prev curr or next.
        Node prev = null;
        Node curr = head;
        Node next = null;

        // STEP 2 : Iterate over the ll untill curr != null
        // and play with pointers.
        while(curr != null){
            // 1. Make next = curr.next.
            next = curr.next;

            // 2. then curr.next point to prev one.
            curr.next = prev;

            // 3. then prev pointing to curr.
            prev = curr;

            // 4. in last for next iteration curr = next.
            curr = next;
        }

        // STEP 3 : Now prev in last node so pointing head to be previous.
        head = prev;
        
        // STEP 4 : Return head.
        return head;
    }
}