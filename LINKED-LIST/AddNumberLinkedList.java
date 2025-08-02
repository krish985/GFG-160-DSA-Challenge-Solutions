// Problem: Add Number Linked List 2.
// Platform Availaible: Leetcode 445, GFG
// Difficulty : Medium.
// Companies tag : Flipkart , Morgan Stanley , Accolite , Amazon , Microsoft 
// Snapdeal , MakeMyTrip , Qualcomm , Google , Adobe , Walmart Labs , Ola 
// Intuite .

public class AddNumberLinkedList {
    // TIME COMPLEXITY : O(N+M).
    // SPACE COMPLEXITY : O(max(n,m)).
    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // Reverse List method.
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
    public static Node addTwoList(Node head1 , Node head2){
        // STEP 1 : Reverse Both Linked List.
        Node l1 = reverseList(head1);
        Node l2 = reverseList(head2);

        // STEP 2 : Perform Addition Initialize temp ptr that conatining addition value.
        Node temp = new Node(0);
        Node dummy = temp;
        int carry = 0;    // Use to containing carry.
        
        // STEP 3 : Iterate over the linked list
        while(l1 != null || l2 != null){
            // add carry if avialiable in sum.
            int sum = carry;

            // add both val into sum and move l1 pointer to next.
            if(l1 != null){
                sum+= l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+= l2.data;
                l2 = l2.next;
            }

            // store carry and extract new val to add.
            carry = (sum / 10);
            temp.next = new Node((sum % 10));

            // move temp by 1 step ahead.
            temp = temp.next;
        }
 
        // STEP 4 : if carry > 0 add that carry into List.
        if(carry > 0){
            temp.next = new Node(carry);
            temp = temp.next;
        }

        // STEP 5 : Reverse again computed list.
        Node rev = reverseList(dummy.next);

        // STEP 6 : Remove leading zero if available either return rev.
        while(rev.data == 0){
            rev = rev.next;
        }

        // STEP 7 : Return rev.
        return rev;
    }
}
