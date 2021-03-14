package com.bridgeSelectiveProcess.backend.utils;

import java.util.ArrayList;
import java.util.List;

public class PrimeUtils {
	
	public PrimeUtils() {
		
	}
	
	public static List<Integer> getPrimesInRange(Integer lower, Integer top1) {
		int low = lower.intValue();
		int top = top1.intValue();
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = low; i < top ; i++) {
			if(isPrime(i)) {
				result.add(Integer.valueOf(i));
			}
		}
		
		return result;
	}
	
	public static boolean isPrime(int a)
	{
		
        if (a < 1 || a % 2 == 0) { return false; }
        
        else if (a == 1 || a == 2) { return true; }
        
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(a); i += 2) 
        {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}
