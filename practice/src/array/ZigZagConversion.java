package array;

public class ZigZagConversion {

	 public static String convert(String s, int numRows) {
	        char arr[][] = new char[numRows][s.length()];
	        int c=0;
	        int state=0;
	        int i = 0,j=0;
	        while(c<s.length()){
	            if(state==0){
	                arr[i][j]=s.charAt(c);
	                i++;
	                if(i==numRows){
	                	i--;
	                    state=1;
	                }
	            }
	            else if (state==1){
	                i--;
	                j++;
	                arr[i][j]=s.charAt(c);
	                if(i==0){
	                	
	                    state=0;
	                }
	            }
	            c++;
	        }
	        return null;
	    }
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		convert(s, 3);

	}

}
