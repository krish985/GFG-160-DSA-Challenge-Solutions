import java.util.HashMap;

// Problem: LRU Cache.
// Platform Availaibble : Leetcode 146 , GFG.
// Difficulty : HARD.
// Companies tag : Paytm , Zoho , Flipkart , Morgan Stanley , Amazon , Microsoft , OYO Rooms
// Samsung , Snapdeal , Hike , MakeMyTrip , Ola Cabs , Visa , Walmart , Goldman Sachs , Adobe
// Google , Yahoo

public class LruCache {
    // TIME COMPLEXITY : O(1).
    // SPACE COMPLEXITY : O(capacity).

    // STEP 1 : Create a doubly LL that store key val and and prev next pointer.
    class Node {
        int key;
        int val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // STEP 2 : Create a hashmap that store key and corresponding node to
    // fast look up and create head or tail pointer initially for start.
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    // STEP 3 : Initialilize costructor.
    LruCache(int cap) {
        capacity = cap;

        // Link head or tail;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // STEP 1 : Check that val prsent if present
        // return that val and add into front of ll after
        // beacuse it is most recent access data.
        if (map.containsKey(key)) {
            // Extract that node.
            Node node = map.get(key);

            // delete that node.
            deleteNode(node);

            // insert after head;
            insertAfterHead(node);

            // return their val.
            return node.val;
        } else {
            // Not present return -1
            return -1;
        }
    }

    public void put(int key, int value) {
        // STEP 1 : Check if already key present remove.
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
        }

        // STEP 2 : Check for capicity is full remove tail.prev.
        if (map.size() == capacity) {
            deleteNode(tail.prev);
        }

        // STEP 3 : create new node insert after head.
        insertAfterHead(new Node(key, value));
    }

    public void deleteNode(Node node) {
        // STEP 1 : remove from map.
        map.remove(node.key);

        // STEP 2 : Change pointer
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(Node node) {
        // STEP 1 : put key and their corresponding node into map.
        map.put(node.key, node);

        // STEP 2 : Insert after head.
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }
}
