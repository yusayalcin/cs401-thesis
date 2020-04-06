package buffreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class LCS {
    // Function to find LCS of String X[0..m-1] and Y[0..n-1]
    public static String lcs(String[] x, String[] y, int m, int n, int[][] T) {
        // return empty string if we have reached the end of
        // either sequence
        if (m == 0 || n == 0) {
            return "";
        }
        // if last character of X and Y matches
        if (Objects.equals(x[m - 1], y[n - 1])) {
            // append current character (X[m-1] or Y[n-1]) to LCS of
            // substring X[0..m-2] and Y[0..n-2]
            return lcs(x, y, m - 1, n - 1, T) + x[m - 1];
        }

        // else when the last character of X and Y are different

        // if top cell of current cell has more value than the left
        // cell, then drop current character of String X and find LCS
        // of substring X[0..m-2], Y[0..n-1]

        if (T[m - 1][n] > T[m][n - 1]) {
            return lcs(x, y, m - 1, n, T);
        } else {
            // if left cell of current cell has more value than the top
            // cell, then drop current character of String Y and find LCS
            // of substring X[0..m-1], Y[0..n-2]

            return lcs(x, y, m, n - 1, T);
        }
    }

    // Function to fill lookup table by finding the length of LCS
    // of substring X[0..m-1] and Y[0..n-1]
    public static void lcsLength(String[] x, String[] y, int m, int n, int[][] T) {
        // fill the lookup table in bottom-up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // if current character of X and Y matches
                if (Objects.equals(x[i - 1], y[j - 1])) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                }

                // else if current character of X and Y don't match
                else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
    }

    // main function
    public static void main(String[] args) throws IOException {

        String[] successful = read("C:\\Users\\ahmet\\Desktop\\401-demo\\success.txt");
        String[] failed = read("C:\\Users\\ahmet\\Desktop\\401-demo\\bug.txt");
        System.out.println(Arrays.toString(successful));
        //String[] X = {"X","M","J","Y","A","U","Z"}, Y = {"M","Z","J","A","W","X","U"};
        int m = successful.length, n = failed.length;


        // T[i][j] stores the length of LCS of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];
        // fill lookup table
        lcsLength(successful, failed, m, n, T);

        String[] arr = lcs(successful, failed, m, n, T).split("!");
        ArrayList<String> longest = new ArrayList<String>();
        ArrayList<String> fail = new ArrayList<String>();
        for (String s : arr)
            longest.add(s + "!");
        for (String s : longest)
            System.out.println(s);
        for (String s : failed)
            fail.add(s);
        //for (String  s : fail)
        //System.out.println(s);
        System.out.println("----------");
        PrintStream text = new PrintStream(new File("C:\\Users\\ahmet\\Desktop\\401-demo\\"+System.currentTimeMillis()+"Differences.txt"));
		System.setOut(text);
        ArrayList<String> result = shortestUnCommonPath(longest, fail, 0, 0);

        for (String s : result) System.out.println(s);
        // find longest common sequence
        // System.out.print(Arrays.toString(arr));
        System.exit(0);
    }

    public static String[] read(String filename) throws IOException {
        Path path = Paths.get(filename);
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path);
        return lines.toArray(new String[0]);
    }
    public static ArrayList<String> shortestUnCommonPath(ArrayList<String> longest, ArrayList<String> fail, int indexLongest, int indexFail) throws FileNotFoundException {
    	int nextFailIn = 0;
        int indexCommon = indexLongest;
        if (indexCommon == longest.size()) {
            return fail;
        }
        if (indexFail == fail.size()) {
            return fail;
        } else if (indexFail + 1 == fail.size()) {
            return fail;
        } else {
            for (int i = indexFail; i < fail.size(); i++) {
                if (fail.get(i).equals(longest.get(indexLongest))) {
                    //   System.out.println("****");
                    fail.remove(i);
                    //for (String  s : fail)
                    //  System.out.println(s);
                    if (i == 0)
                        nextFailIn = i;
                    else
                        nextFailIn = i - 1;
                    indexCommon++;
                    break;
                }
            }
            shortestUnCommonPath(longest, fail, indexCommon, nextFailIn);

            return fail;
        }
    }
}
