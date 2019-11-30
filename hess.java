package buffreader;

import java.util.HashSet;

public class hess {
	// set to store all the subsequences 
	   public static HashSet<String> st = new HashSet<>(); 
	   public static HashSet<String> st1 = new HashSet<>(); 

	  
	    // It computes all the subsequence of an string 
	   public static void subsequence(String str) 
	    { 
	        // iterate over the entire string 
	        for (int i = 0; i < str.length(); i++) { 
	              
	            // iterate from the end of the string 
	            // to generate substrings 
	            for (int j = str.length(); j > i; j--) { 
	                String sub_str = str.substring(i, j); 
	              
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

	    } 
}
