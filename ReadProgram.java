package AutomationSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class ReadProgram {
	public static void main(String[] args) {
		ReadProgram program = new ReadProgram();
		program.readCSV();
		
	
	
	public Object[][] readCSV() throws IOException {
		
	
		//code to read CSV file 
	Object[][] obj = new Object[3][2];
	Reader fis = new java.io.FileReader("C:\\Users\\sony\\eclipse-workspace\\SeleniumProjects\\src\\InputFile.csv");
	BufferedReader reader = new BufferedReader(fis);
	Scanner sc = new Scanner(reader);
	int index = 0;
	while(sc.hasNext()) {
		String[] unamePassPair = sc.next().split(",");
		if(!unamePassPair[0].equals("uname")){
			obj[index][0] = unamePassPair[0];
			obj[index][1] = unamePassPair[1];
			index++;
		}
	
		return obj;
	}
	
	}
	}
