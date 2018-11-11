package com.yogi.ds.array;

import java.util.ArrayList;

public class StockBuySell {

	class Interval {
		int buy;
		int sell;
	}

	public void stockBuySellMaxProfit(int[] a) {
		int n = a.length;
		int count = 0;
		int i = 0;
		ArrayList<Interval> sol = new ArrayList<>();
		while (i < n - 1) {
			// find local minima
			while (i < n - 1 && a[i + 1] < a[i]) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			Interval ir = new Interval();
			ir.buy = i++;
			// find local maxima

			while (i < n && a[i - 1] < a[i]) {
				i++;
			}
			ir.sell = i - 1;
			sol.add(ir);
			count++;
		}
		if (count == 0) {
			System.out.println("There is no day when buying the stock " + "will make profit");
		} else {
			for (int j = 0; j < count; j++) {
				System.out.println("buy on day : " + sol.get(j).buy + " sell on day : " + sol.get(j).sell);
			}
		}
	}
	public static void main(String[] args) {
		StockBuySell stock = new StockBuySell(); 
         
	        // stock prices on consecutive days 
	        int price[] = {100, 180, 260, 310, 40, 535, 695}; 
	  
	        // fucntion call 
	        stock.stockBuySellMaxProfit(price); 
	}
}
