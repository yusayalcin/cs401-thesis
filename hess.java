
package buffreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class hess {
	static ArrayList<String> arr1 = new ArrayList<String>();
	static ArrayList<String> arr2 = new ArrayList<String>();

	public void printAllSubSequences(String[] arrInput) {
		int[] temp = new int[arrInput.length];
		int index = 0;
		solve(arrInput, index, temp);
	}

	private void solve(String[] arrInput, int index, int[] temp) {
		if (index == arrInput.length) {
			print(arrInput, temp);
			return;
		}
		// set the current index bit and solve it recursively
		temp[index] = 1;
		solve(arrInput, index + 1, temp);
		// unset the current index bit and solve it recursively
		temp[index] = 0;
		solve(arrInput, index + 1, temp);
	}

	private void print(String[] arrInput, int[] temp) {
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1)
				result += arrInput[i] + " ";
		}
		// if(result=="")
		// result = "{Empty Set}";
		arr1.add(result);
		// System.out.println(result);
	}

	public void printAllSubSequences1(String[] arrInput) {
		int[] temp = new int[arrInput.length];
		int index = 0;
		solve1(arrInput, index, temp);
	}

	private void solve1(String[] arrInput, int index, int[] temp) {
		if (index == arrInput.length) {
			print1(arrInput, temp);
			return;
		}
		// set the current index bit and solve it recursively
		temp[index] = 1;
		solve1(arrInput, index + 1, temp);
		// unset the current index bit and solve it recursively
		temp[index] = 0;
		solve1(arrInput, index + 1, temp);
	}

	private void print1(String[] arrInput, int[] temp) {
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1)
				result += arrInput[i] + " ";
		}
		// if(result=="")
		// result = "{Empty Set}";
		arr2.add(result);
		// System.out.println(result);
	}

	public static void main(String[] args) throws IOException {
		String[] s1 = read("C:\\Users\\ahmet\\Desktop\\bitirme\\producerconsumer\\1575371279064Out.txt");
		String[] s2 = read("C:\\Users\\ahmet\\Desktop\\bitirme\\producerconsumer\\1575371318152Out.txt");

		/*new hess().printAllSubSequences(s1);
		new hess().printAllSubSequences1(s2);

		System.out.println(arr1);
		System.out.println(arr2);
		arr1.removeAll(arr2);
		System.out.println(arr1);*/

	}

	private static String[] read(String location) throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader(location));
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		while ((line = reader1.readLine()) != null) {
			lines.add(line);
		}
		String[] result = new String[lines.size()];
		for(int i=0; i<lines.size(); i++) {
			result[i] = lines.get(i);
		}
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}
}
