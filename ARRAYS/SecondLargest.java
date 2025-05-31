
// Problem: Find the second largest Element in An Array.
// Link: https://www.geeksforgeeks.org/find-second-largest-element-array/
// Difficulty: Easy.
// Companies tag : Sap Labs , TCS , Accenture , Sentinel One .

public class SecondLargest {
    // Time Complexity : O(n).  // take single parse.
    // Space Complexity : O(1).

    public static int findSecondLargest(int arr[]){
        // Edge Case.
        if(arr.length < 2){
            return -1; // we have one elemnt second greater ! exist.
        }
        // initialize variable largest or secondLargest.
        int largest = -1;
        int secondLargest = -1;

        // iterate over the array.
        for(int i=0; i<arr.length; i++){
            // if arr[i] > largest update secondlargest = largest.
            // and largest = curr val.
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] < largest && arr[i] > secondLargest){
                // in that case update secondlargest.
                secondLargest = arr[i];
            }
        }

        // return second largest value.
        return secondLargest;
    }
    
}