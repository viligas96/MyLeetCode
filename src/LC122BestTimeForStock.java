public class LC122BestTimeForStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        if (len == 1) return 0;

        for (int i = 0; i < len - 1; i++){
            if (prices[i+1] - prices[i] > 0){
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        System.out.println(new LC122BestTimeForStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
