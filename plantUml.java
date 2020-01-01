package buffreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.annotation.processing.FilerException;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PlantUml {
	public static void main(String[] args) throws IOException {
		
		LinkedList<String> umlMessages = new LinkedList<String>();
		umlMessages = toUml("C:\\Users\\ahmet\\Desktop\\bitirme\\producerconsumer\\bug.txt");
		StringBuilder builder = new StringBuilder("@startuml\n");
		for(String umlMessage : umlMessages){
			builder.append(umlMessage + "\n");
		}
		builder.append("\n@enduml");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("sequence.png");
			SourceStringReader sourceStringReader = new SourceStringReader(builder.toString());
			sourceStringReader.generateImage(fileOutputStream, new FileFormatOption(FileFormat.PNG));
			fileOutputStream.close();
		} catch( FileNotFoundException e)  {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}
	private static LinkedList<String> toUml(String location) throws IOException {
		BufferedReader reader1 = new BufferedReader(new FileReader(location));
		String line;
		LinkedList<String> lines = new LinkedList<String>();
		while ((line = reader1.readLine()) != null) {
			lines.add(line);
		}
		return lines;
	}
}
