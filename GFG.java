package buffreader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
class GFG 
{ 
  
// Maximum String length 
static int N = 100; 
  
static int [][]L = new int[N][N]; 
  
/* Returns set containing all LCS for  
   X[0..m-1], Y[0..n-1] */
static Set<String> findLCS(String[] x,  
                           String[] y, int m, int n) 
{ 
    // construct a set to store possible LCS 
    Set<String> s = new HashSet<>(); 
  
    // If we reaches end of either String,  
    // return a empty set 
    if (m == 0 || n == 0) 
    { 
        s.add(""); 
        return s; 
    } 
  
    // If the last characters of X and Y are same 
    if (x[m - 1] == y[n - 1]) 
    { 
        // recurse for X[0..m-2] and Y[0..n-2]  
        // in the matrix 
        Set<String> tmp = findLCS(x, y, m - 1, n - 1); 
  
        // append current character to all possible LCS 
        // of subString X[0..m-2] and Y[0..n-2]. 
        for (String str : tmp) 
            s.add(str + x[m - 1]); 
    } 
  
    // If the last characters of X and Y are not same 
    else
    { 
        // If LCS can be constructed from top side of 
        // the matrix, recurse for X[0..m-2] and Y[0..n-1] 
        if (L[m - 1][n] >= L[m][n - 1]) 
            s = findLCS(x, y, m - 1, n); 
  
        // If LCS can be constructed from left side of 
        // the matrix, recurse for X[0..m-1] and Y[0..n-2] 
        if (L[m][n - 1] >= L[m - 1][n]) 
        { 
            Set<String> tmp = findLCS(x, y, m, n - 1); 
  
            // merge two sets if L[m-1][n] == L[m][n-1] 
            // Note s will be empty if L[m-1][n] != L[m][n-1] 
            s.addAll(tmp); 
        } 
    } 
    return s; 
} 
  
/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
static int LCS(String[] x, String[] y, int m, int n) 
{ 
    // Build L[m+1][n+1] in bottom up fashion 
    for (int i = 0; i <= m; i++) 
    { 
        for (int j = 0; j <= n; j++) 
        { 
            if (i == 0 || j == 0) 
                L[i][j] = 0; 
            else if (x[i - 1] == y[j - 1]) 
                L[i][j] = L[i - 1][j - 1] + 1; 
            else
                L[i][j] = Math.max(L[i - 1][j], 
                                   L[i][j - 1]); 
        } 
    } 
    return L[m][n]; 
} 
  
// Driver Code 
public static void main(String[] args) throws IOException 
{ 
	
	//String[] X =  read("C:\\Users\\fener\\Desktop\\producerconsumer\\Yeni Metin Belgesi.txt");
  //  String[] Y = read("C:\\Users\\fener\\Desktop\\producerconsumer\\Yeni Metin Belgesi (2).txt");
	String[] X = {"X","M","J","Y","A","U","Z"}, Y = {"M","Z","J","A","W","X","U"};
	/*String[] X = {"null -> ProducerConsumer.main",
			"Thread[Thread-1,5,main] -> Producer.run",
			"Thread[Thread-2,5,main] -> Producer.run",
			"Thread[Thread-3,5,main] -> Consumer.run",
			"Thread[Thread-4,5,main] -> Consumer.run",
			"Thread[Thread-5,5,main] -> Consumer.run",
			"Thread[Thread-6,5,main] -> Consumer.run",
			"Thread[Thread-7,5,main] -> Consumer.run",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-6,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.halt",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.halt",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-3,5,main] -> Consumer.inc",
			"Thread[Thread-7,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-6,5,main] -> Con,sumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get,",
	};
	String[] Y = {"null -> ProducerConsumer.main",
			"Thread[Thread-1,5,main] -> Producer.run",
			"Thread[Thread-2,5,main] -> Producer.run",
			"Thread[Thread-3,5,main] -> Consumer.run",
			"Thread[Thread-4,5,main] -> Consumer.run",
			"Thread[Thread-5,5,main] -> Consumer.run",
			"Thread[Thread-6,5,main] -> Consumer.run",
			"Thread[Thread-7,5,main] -> Consumer.run",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.halt",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.halt",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-4,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-5,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-3,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-6,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Thread[Thread-7,5,main] -> Consumer.inc",
			"Buffer@47e4e6d3 -> Buffer.get",
			"Buffer@47e4e6d3 -> Buffer.put",
			"Buffer@47e4e6d3 -> Buffer.halt"
			};*/
    int m = X.length; 
    int n = Y.length; 
	//System.out.println(Arrays.toString(X));
	//System.out.println(Arrays.toString(Y));
    System.out.println(m+" "+ n);
    System.out.println("LCS length is " + 
                        LCS(X, Y, m, n)); 
  
    Set<String> s = findLCS(X, Y, m, n); 
    
    List<String> newList = Arrays.asList(Y);
    List<Set<String>> newList1 = Arrays.asList(s);
    List<String> mainList = new ArrayList<String>();
    for (Set<String> str : newList1)  
    	mainList.addAll(str);

    System.out.println(newList);
    System.out.println(mainList);

   

  
    System.out.println(newList.size());
    newList.removeAll(newList1);
    System.out.println(newList);   
    System.out.println(newList.size());
// Prints [rohit]
   // System.out.println(updatableList);
    
    
    String[] x;
    for (String str : s) {
       // System.out.println(str); 
       
    break;
    }
}
private static String[] read(String location) throws IOException {
	BufferedReader reader1 = new BufferedReader(new FileReader(location));
	String line;
	ArrayList<String> lines = new ArrayList<String>();
	while ((line = reader1.readLine()) != null) {
		lines.add(line);
	}
	reader1.close();
	String[] result = new String[lines.size()];
	for(int i=0; i<lines.size(); i++) {
		result[i] = lines.get(i);
	}
	/*for(int i = 0; i < result.length; i++) {
		System.out.println(result[i]);
	}*/
	return result;
	
}
} 
  
