//package cs310;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coins {
	   
	static int change(int den[], int n, int M) { 

		int[] opt= new int[M+1];
		int[] coins = new int[M+1];
		opt[0] = 0;
		coins[0] = 0;
	
		for(int i=1; i<=M; i++) {
			opt[i] = Integer.MAX_VALUE;
			coins[i] = Integer.MIN_VALUE;
		}
		
		for(int i=0; i<n; i++)	{
			for(int j=1; j<=M; j++)	{
				if(j >= den[i])  {
					if(opt[j] > 1+ opt[j-den[i]]) {
						opt[j] = 1 + opt[j-den[i]];
						coins[j] = i;
					}
				}
			}
		}
			
		int [] coincount = new int[den.length];	
		for(int m = coins.length-1; m > 0; m -=den[coins[m]])    {	
			coincount[coins[m]]++;
		}
			
		System.out.print(opt[M] + "\n \n");
		System.out.println("With the following coin denominations: ");

		for (int i = 0; i < den.length; i++) {
			if (coincount[i] == 1) {
				System.out.println(coincount[i] + " coin of " + den[i] + " cents");
			}	
			if (coincount[i] > 1) {
				System.out.println(coincount[i] + " coins of " + den[i] + " cents");
			}	
		}
		
		System.out.println();	
		return opt[M];
	}
		
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); 
		int M = input.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		while (input.hasNextInt())
			list.add(input.nextInt());
		int i = 0;
		int n = list.size();
        int [] denominations = new int[n];

        for (Integer I : list) {
        		denominations[i] = I;
        		i++;
        }

		System.out.println ("Minimum coins needed to make change for " + M + " cents:");
	 	change(denominations, n, M);	   
		} 		  
	}


