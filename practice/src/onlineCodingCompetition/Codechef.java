package onlineCodingCompetition;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Codechef
{
    static Map<Integer,Integer>  elementLookup;
    static Map<Integer,Integer> frequencyLookup;
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int j=0;j<testCases;j++){
		    elementLookup = new HashMap<>();
		    frequencyLookup = new HashMap<>();
		    int numElem	 = sc.nextInt();
		    int arr[] = new int[numElem];
		 
		   for(int i=0;i<numElem;i++) {
			   arr[i] = sc.nextInt();
		   }
		    int prev = arr[0];
		    int count=1;
		    for(int i=1;i<numElem;i++){
		        if(prev!=arr[i]){
		            if(elementLookup.containsKey(arr[i])){
		                System.out.println("No");
		                break;
		            }
		            if(frequencyLookup.containsKey(arr[i])){
		                
		                System.out.println("No");
		                break;
		            }
		            prev = arr[i];
		            elementLookup.put(prev,0);
		            frequencyLookup.put(count,0);
		            count=1;
		        }else{
		            count++;
		        }
		    }
		     System.out.println("Yes");
		}
	}
}

