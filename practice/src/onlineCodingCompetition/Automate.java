package onlineCodingCompetition;

import java.util.ArrayList;
import java.util.List;

public class Automate {

	 public List<Integer> cellCompete(int[] states, int days)
	    {
	        List<Integer> ans = new ArrayList<>();
	        int padded[] =  new int[states.length+2];
	        int shadow[] = new int[states.length+2];
	        for(int i=0;i<states.length;i++){
	            shadow[i+1]=states[i];
	            padded[i+1]=states[i];
	        }
	        padded[0]=0;padded[padded.length-1]=0;
	        int changes=0;
	        while(days!=0){
	            days--;
	            for(int i=1;i<padded.length-1;i++){
	                if(padded[i-1]==padded[i+1]){
	                    shadow[i]=0;
	                }else{
	                    shadow[i]=1;
	                }
	            }
	            for(int i=0;i<padded.length;i++){
	                padded[i]=shadow[i];
	            }
	        }
	        for(int i=1;i<padded.length-1;i++){
	            ans.add(padded[i]);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
