// Problem: Stock Buy and Sell - Max one Transaction Allowed.
// Platform Available : Leetcode - 121 , GFG.
// Difficulty: Medium.
// Companies tag : Uber , Accenture , Apple , IBM , Google , Adobe , TCS , Goldman Sachs , Walmart.
// Bloomberg , Meta , Intel , Infosys , Zoho , Morgan Stanley , Amazon , Microsoft , Samsung , Yahoo , 
// PayPal , Nvidia , Oracle , Visa.

public class StocksMakeOneTransaction {
    // TIME COMPLEXITY : O(N).
    // SPACE COMPLEXITY : O(1).
    public static int maxProfit(int prices[]) {
        // STEP 1 : Buy stock on 0 day.
        int buyStock = prices[0];

        // STEP 2 : initialize profit variable that count maximum profit.
        int profit = 0;

        // STEP 3 : iterate 1 to n check if curr pricees[i] < buying price it menas
        // skip previous buying price replace buying stock price to curr prices[i].
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyStock) {
                // Found a lower buying price.
                buyStock = prices[i];
            } else {
                // Calculate profit if selling today.
                int currProfit = prices[i] - buyStock;
                profit = Math.max(profit, currProfit);
            }
        }

        // STEP 3 : Now final step return profit.
        return profit;
    }
}
