// Problem: Kth Element Of Two Array.
// Problem Link : https://www.geeksforgeeks.org/dsa/k-th-element-two-sorted-arrays/
// Difficulty: Medium.
// Companies tag : Adobe , Flipkart , MicroSoft.

public class KthElementOfTwoArray {
    // TIME COMPLEXITY : O(K).
    // SPACE COMPLEXITY : O(1).
    public static int findKthElement(int A[], int B[], int k) {
        // STEP 1 : Calculate the length of the array.
        int n1 = A.length;
        int n2 = B.length;

        // STEP 2 : Using two pointer Approach i will point A 0 idx.
        // and j will point B 0 idx also take a key that track k val.
        int i = 0;
        int j = 0;
        int key = 0;

        // STEP 3 : Iterate the both array untill i < n1 && j < n2
        while (i < n1 && j < n2) {
            // A[i] smaller compare to B[j].
            if (A[i] < B[j]) {
                key++;
                if (key == k) {
                    // Found kth element.
                    return A[i];
                }
                i++;
            } else {
                // A[i] greater then B[j].
                key++;
                if (key == k) {
                    // Found kth element.
                    return B[j];
                }
                j++;
            }
        }

        // STEP 4 : For Remaining Element.
        // Either elemnt have A or B arraay.
        while (i < n1) {
            key++;
            if (key == k) {
                // Found kth element.
                return A[i];
            }
            i++;
        }

        while (j < n2) {
            key++;
            if (key == k) {
                // Found kth element.
                return B[j];
            }
            j++;
        }

        // return dummy something.
        return 0;

    }
}
