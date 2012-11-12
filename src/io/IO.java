package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

/*
 * IO Class. 
 * Author: Khoa Pham - khoa.pham@me.com - all rights reserved.
 * - To read text from file.
 */
public class IO {
	public IO() {}
	/*
	 * function: readFile.
	 * param: filename
	 * return: Vector<String>.
	 */
	public Vector<String> readFile(String filename) throws IOException{
		File inputFile = new File(filename);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		Vector<String> storedData = new Vector<String>();
		String inputLine;
		while((inputLine = bufferedReader.readLine()) != null) { storedData.add(inputLine);}
		return storedData;
	}
	
	/*
	 * function: printStream to file.
	 * param: String dir.
	 * return: none.
	 */
	public void printStream (PrintStream pst) throws FileNotFoundException {
		System.setOut(pst);
	}
	public void closeStream(PrintStream pst) {
		pst.close();
	}
	
}
