package junxiao.leetcode.count_primes;

import java.util.*;

public class Solution {
	public int countPrimes(int n){
		//primes less than n
		int count = 0;
		if (n<=2) return count;
		++count;
		if (n==3) return count;
		List<Integer> arr = new LinkedList<>();
		for (int i =3; i < n; i+=2){
			arr.add(i);
		}
		while (!arr.isEmpty()){
			++count;
			int prime = arr.get(0);
			for(Iterator<Integer> it = arr.iterator();it.hasNext();){
				int num = it.next();
				if (num%prime ==0)
					it.remove();
			}
		}
		return count;
	}
	public int countPrimes2(int n){
		//primes less than n
		if (n<=2) return 0;
		int count = 0;
		boolean[] isPrime = new boolean[n];
		isPrime[2] = true;
		for (int i =3; i< n; i+=2){
			isPrime[i] = true;
		}
		
		for (int i = 3; i*i<=n; ++i){
			if (!isPrime[i]) continue;
			for (int j = i*i; j<n; j+=i){
				isPrime[j] = false;
			}
		}
		
		for(boolean m : isPrime){
			if (m) ++ count;
		}
		return count;
	}
}
