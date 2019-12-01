package buffreader;

import java.util.ArrayList;
import java.util.HashSet;

public class hess {
	static ArrayList<String> arr1 = new ArrayList<String>();
	 static ArrayList<String> arr2 = new ArrayList<String>();

	   public void printAllSubSequences(String[] arrInput){
	        int [] temp = new int[arrInput.length];
	        int index = 0;
	        solve(arrInput, index, temp);
	    }
	   

	    private void solve(String[] arrInput, int index, int [] temp){
	        if(index==arrInput.length){
	            print(arrInput,temp);
	            return;
	        }
	        //set the current index bit and solve it recursively
	        temp[index] = 1;
	        solve(arrInput,index+1,temp);
	        //unset the current index bit and solve it recursively
	        temp[index] = 0;
	        solve(arrInput,index+1,temp);
	    }

	    private void print(String[] arrInput, int [] temp){
	        String result = "";
	        for (int i = 0; i <temp.length ; i++) {
	            if(temp[i]==1)
	                result += arrInput[i]+" ";
	        }
	      //  if(result=="")
	           // result = "{Empty Set}";
	        arr1.add(result);
	        //System.out.println(result);
	    }
	    public void printAllSubSequences1(String[] arrInput){
	        int [] temp = new int[arrInput.length];
	        int index = 0;
	        solve1(arrInput, index, temp);
	    }
	   

	    private void solve1(String[] arrInput, int index, int [] temp){
	        if(index==arrInput.length){
	            print1(arrInput,temp);
	            return;
	        }
	        //set the current index bit and solve it recursively
	        temp[index] = 1;
	        solve1(arrInput,index+1,temp);
	        //unset the current index bit and solve it recursively
	        temp[index] = 0;
	        solve1(arrInput,index+1,temp);
	    }

	    private void print1(String[] arrInput, int [] temp){
	        String result = "";
	        for (int i = 0; i <temp.length ; i++) {
	            if(temp[i]==1)
	                result += arrInput[i]+" ";
	        }
	        //if(result=="")
	           // result = "{Empty Set}";
	        arr2.add(result);
	        //System.out.println(result);
	    }

	    public static void main(String[] args) {
	        String [] s1 = {"b","a","b","a","b"};
	        String [] s2 = {"b","a","b","b","a"};

	       

	        new hess().printAllSubSequences(s1);
	        new hess().printAllSubSequences1(s2);

	        System.out.println(arr1);
	        System.out.println(arr2);
	        arr1.removeAll(arr2);
	        System.out.println(arr1);  

	    }
	// set to store all the subsequences 
	  /* public static HashSet<String> st = new HashSet<>(); 
	   public static HashSet<String> st1 = new HashSet<>(); 
       //static ArrayList<String> sa = new ArrayList<String>();

	  
	    // It computes all the subsequence of an string 
	   public static void subsequence(String string) 
	    { 
	        // iterate over the entire string 
	        for (int i = 0; i < string.length(); i++) { 
	              
	            // iterate from the end of the string 
	            // to generate substrings 
	            for (int j = string.length(); j > i; j--) { 
	                String sub_str = string.substring(i, j); 
	              
	                if (!st.contains(sub_str)) 
	                    st.add(sub_str); 
	  
	                // drop kth character in the substring 
	                // and if its not in the set then recur 
	                for (int k = 1; k < sub_str.length() - 1; k++) { 
	                    StringBuffer sb = new StringBuffer(sub_str); 
	  
	                    // drop character from the string 
	                    sb.deleteCharAt(k); 
	                    if (!st.contains(sb)) 
	                        ; 
	                    subsequence(sb.toString()); 
	                } 
	            } 
	        } 
	    } 
	     public static void subs(String str) 
	    { 
	        // iterate over the entire string 
	        for (int i = 0; i < str.length(); i++) { 
	              
	            // iterate from the end of the string 
	            // to generate substrings 
	            for (int j = str.length(); j > i; j--) { 
	                String sub_str = str.substring(i, j); 
	              
	                if (!st1.contains(sub_str)) 
	                    st1.add(sub_str); 
	  
	                // drop kth character in the substring 
	                // and if its not in the set then recur 
	                for (int k = 1; k < sub_str.length() - 1; k++) { 
	                    StringBuffer sb = new StringBuffer(sub_str); 
	  
	                    // drop character from the string 
	                    sb.deleteCharAt(k); 
	                    if (!st1.contains(sb)) 
	                        ; 
	                    subs(sb.toString()); 
	                } 
	            } 
	        } 
	    } 
	      // Driver code 
	    public static void main(String[] args) 
	    { 

	    	String s = "babab"; 
	        String s1 = "babba"; 
	        subsequence(s); 
	        subs(s1); 

	        System.out.println(st); 
	        System.out.println(""); 

	        System.out.println(st1); 
	        System.out.println(""); 

	        st.removeAll(st1);
	        System.out.println(st);  //ilkinin ikincisine göre farklarını basıyor

	    } */
}
