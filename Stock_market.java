// public class Stock_market {
//     public static int maxProfit(int[] prices) {
//         int profit = 0;
//         int buy_price =  prices[0];
//         int sell_price = 0;

//         for (int i = 1; i < prices.length-1; ++i) {
//             profit = prices[i] - buy_price;
//             if (profit < 0 && prices[i] < buy_price) {
//                 buy_price = prices[i];
//             }
//             else if(){
//             sell_price = sell_price + Math.max(profit, sell_price);
//             i=i+1;
//             }
//         }
//         if (sell_price < 0) {
//             return 0;
//         }
    
//         return sell_price;
//     }

//     public static void main(String[] args) {
//         int prices[] = {7,1,5,3,6,4};

//         System.out.println(maxProfit(prices));
//     }
// }

// Optimized Way for Stock to Buy and sell

public class Stock_market {
public static void maxProfit(int[] prices) {
int buy_price = prices[0];
int profit = 0;
int sell_price = 0;
int currentsumprofit =0;
int profit2 = 0;

for(int i = 1;i < prices.length;++i){
profit = prices[i] - buy_price;
if(profit < 0 && prices[i] < buy_price){
buy_price = prices[i];
}
sell_price = Math.max(profit,sell_price);
}
if (sell_price<0) {
// return 0;
System.out.println("0");
}
System.out.println(sell_price);

int i=0,j=1;
while(i<prices.length){
  while(j<prices.length){
    if(prices[i] < prices[j] && i < prices.length && j < prices.length){
        profit2 = prices[j]-prices[i];
        i=i+2;
        j=j+2;
    }else{
        j=j+1;
    }

}
}

}
public static void main(String[] args) {
int prices [] = {7,1,5,3,6,4};

maxProfit(prices);
}
}
