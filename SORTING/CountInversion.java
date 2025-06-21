// Problem: Count Inversions of an Array.
// Link : https://www.geeksforgeeks.org/dsa/inversion-count-in-array-using-merge-sort/
// Difficulty: Medium.
// Companies tag :Flipkart , Amazon , Microsoft , MakeMyTrip , Adobe , BankBazaar , Myntra
// Qualcomm , Samsung , Google.

public class CountInversion {
    // TIME COMPLEXITY : N + LOG N : means O(N LOG N).
    // SPACE COMPLEXITY : O(N).
    public static int merge(int arr[], int low, int mid, int high) {
        // STEP 1 : Calculate the length of partioning array.
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // STEP 2 : Then create auxaliary array and fill their val.
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + 1 + j];
        }

        // STEP 3 : SORT the value as well as count inversion.
        int i = 0;
        int j = 0;
        int k = low; // beacause start array of starting.
        int countinv = 0; // that count inv.

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                // in that case count inv.
                countinv += (n1 - i); // curr length of n1 - curr idx.
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        // For reamning value fill into array.
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        // return count inv.
        return countinv;
    }

    public static int mergeSort(int arr[], int low, int high) {
        // Initialize count that count inversion.
        int count = 0;
        // Base Case.
        if (low >= high) {
            return count;
        }
        // STEP 1 : Calculate mid.
        int mid = low + (high - low) / 2;

        // STEP 2 : Apply divede and conqure technique.
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        // STEP 3 : Merge them.
        count += merge(arr, low, mid, high);

        // return count.
        return count;
    }

    public static int countInv(int arr[]) {
        // Analogy : Supoose we have two diffrent sorted array and find inversion.
        // like -> 2 4 6 | 7 8 9 // all are sorted so we can say if 2 > 7 4 also and 6
        // that's why we can directlt say inversion is 3 (2,7) , (2,8) , (2 , 9).

        // STEP 1 : Apply merge sort algorithm.
        int low = 0;
        int high = arr.length - 1;
        return mergeSort(arr, low, high);

    }
}