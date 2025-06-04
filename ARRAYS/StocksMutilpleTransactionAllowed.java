// Problem: Stock Buy and Sell - Multiple Transaction Allowed.
// Link : https://www.geeksforgeeks.org/stock-buy-sell/
// Difficulty: Medium.
// Companies tag : Paytm , Flipkart , Morgan Stanley , Accolite , Amazon
// Microsoft , Samsung , D-E-Shaw , Hike , MakeMyTrip , OlaCabs , Oracle 
// Walmart , Goldman Sachs , Directi , Intuit , SAP Labs , Quikr , Meta 
// Salesforce , Pubmatic , Sapient , Swiggy.

public class StocksMutilpleTransactionAllowed {
    // TIME COMPLEXITY O(N).
    // SPACE COMPLEXITY O(1).
    public static int maxProfit(int prices[]) {
        // STEP 1 : initialize profit variable that tracks all the profits.
        int profit = 0;

        // STEP 2 : iterate over the array 1 to n.
        for (int i = 1; i < prices.length; i++) {
            // STEP 3 : Check if curr price of stock > previous
            // stock it means found profit book that profit.
            if (prices[i] > prices[i - 1]) {
                // Make profit.
                profit += (prices[i] - prices[i - 1]);
            }
        }

        // return profit.
        return profit;
    }
}
