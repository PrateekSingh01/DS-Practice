package onlineCodingCompetition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EvenNumberOfIntegers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int arrLength = s.nextInt();
        int []arr = new int[arrLength];
        for(int i=0;i<arrLength;i++){
            arr[i] = s.nextInt();
        }
        
        Map<Integer,Integer> counter = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
        	if(!counter.containsKey(arr[i])) {
        		counter.put(arr[i], 1);
        	}else {
        		counter.replace(arr[i], counter.get(arr[i])+1);
        	}
        }
        int ans = 0;
        Iterator<Map.Entry<Integer, Integer>> itr = counter.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> pair = itr.next();
            if(pair.getValue()%2==0) {
            	ans+=pair.getKey();
            }
        }
        System.out.println(ans);
	}

}
