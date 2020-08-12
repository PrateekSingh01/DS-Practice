package onlineCodingCompetition;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

	static int[] arr;
    static void left(int counter){
    	if(counter==0)return;
    	counter%=arr.length;
        int[] cpy = Arrays.copyOfRange(arr, 0, counter);
        int j=0;
        for(int i=counter;i<arr.length;i++) {
        	
        	arr[j]=arr[i];
        	j++;
        }
//        arr[arr.length-1] = cpy;
        int l=0;
        for(int k=j;k<arr.length;k++) {
        	arr[k] = cpy[l];
        	l++;
        }
    }
    
    static void right(int counter){
//        int cpy = arr[arr.length-1];
    	if(counter==0)return;
    	counter%=arr.length;
        int cpy[] = Arrays.copyOfRange(arr, arr.length-counter, arr.length);
        int shifter[] =Arrays.copyOfRange(arr, 0, arr.length-counter);
        int k =0;
        for(int i=0;i<cpy.length;i++) {
        	arr[k] = cpy[i];
        	k++;
        }
        for(int i=0;i<shifter.length;i++) {
        	arr[k] = shifter[i];
        	k++;
        }
//        arr[0] = cpy;
    }
    static void increment(int pos){
        arr[pos-1]++;
    }
    static int leftCount=0;
    static int rightCount=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int arrLength = s.nextInt();
        arr = new int[arrLength];
        for(int i=0;i<arrLength;i++){
            arr[i] = s.nextInt();
        }
//        left(3);
//        for(int i=0;i<arrLength;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//       right(3);
//        for(int i=0;i<arrLength;i++){
//          System.out.print(arr[i]+" ");
//      }
//        for(int i=0;i<arrLength;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        //String[] query = {"sdsfs","1"};
    //   right();
       int queryCount = s.nextInt();
       s.nextLine();
       for(int i=0;i<queryCount;i++){
          String query =s.nextLine();
          String queryArr[] = query.split(" ");
          if(("Left".equals(queryArr[0]))) {
        	  leftCount++;
          }
          else if(("Right".equals(queryArr[0]))) {
        	  rightCount++;
          }else if(("Increment".equals(queryArr[0]))) {
        	  left(leftCount);
        	  right(rightCount);
        	  leftCount=0;
        	  rightCount=0;
        	  int idx = Integer.parseInt(queryArr[1]);
              increment(idx);
          }else {
        	  left(leftCount);
        	  right(rightCount);
        	  leftCount=0;
        	  rightCount=0;
        	  int idx1 = Integer.parseInt(queryArr[1]);
        	  System.out.println(arr[idx1-1]);
          }
   
	}

}
}
