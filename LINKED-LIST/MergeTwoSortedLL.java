// Problem: Merge Two Sorted List.
// Platform Availaible: Leetcode 21 , GFG
// Difficulty : Medium.
// Companies tag : Zoho , Flipkart , Accolite , Amazon , Microsoft , Samsung , FactSet 
// MakeMyTrip , Oracle , Brocade , Synopsys , OATS Systems , Belzabar , Google , Meta
// Netflix , Adobe , VMware , Walmart labs , Intuite , CureFit , Razorpay ,  Grow 
// Zerodha

public class MergeTwoSortedLL {
    // TIME COMPLEXITY : O(N + M).
    // SPACE COMPLEXITY : O(1).
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node mergeList(Node head1, Node head2){
        // STEP 1 : Create a temp Node or dummy Node that's point some 
        // random value.
        Node temp = new Node(-1);
        Node dummy = temp;

        // STEP 2 : Iterate over the LL and compare which one is smaller add into
        // tep then move smaller one until (head1 or head2 != null).
        while(head1 != null && head2 != null){
            // Chcek which one is smaller.
            if(head1.data < head2.data){
                // Point temp.next = head1.
                temp.next = head1;
                head1 = head1.next;
            }else{
                // it means head2 is smaller.
                temp.next = head2;
                head2 = head2.next;
            }
            // In last update temp pointer move one step ahead.
            temp = temp.next;
        }

        // STEP 3 : Add remaning one if it is avilaible.
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // STEP 5 Point temp.next to be null for ending LL.
        temp.next = null;

        // STEP 6 : Return dummy.next because it still pointing -1 and next val
        // will sorted LL.
        return dummy.next;
    }
}
