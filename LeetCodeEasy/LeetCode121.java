package LeetCodeEasy;

public class LeetCode121 {

    public int maxProfit(int[] prices){
        int minPrice = 10001;
        int maxProfit = 0;
        for(int price:prices){
            if(price<minPrice){
                minPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

}
