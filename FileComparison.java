package com.Task_10_05_22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Write aJava program to compare two files. If two files are equal(number of lines and statements) then show me the total 
number of words in a separate text file and if contents are different, just show two files contents are different in a text file.*/

public class FileComparison {
	String pathString;
	String secondPathString;
	String outputpathString;

	public void readAndCompareFiles() throws IOException, FileNotFoundException {
		Scanner oScanner = new Scanner(System.in);

		System.out.println("enter the first filename :");
		String firstFile = oScanner.nextLine();

		System.out.println("Enter your second file name");
		String secondFile = oScanner.nextLine();

		System.out.println("Enter the output filename :");
		String outputFile = oScanner.nextLine();

		String userDirectoryString = System.getProperty("user.dir");

		pathString = userDirectoryString + File.separator + firstFile;
		secondPathString = userDirectoryString + File.separator + secondFile;
		outputpathString = userDirectoryString + File.separator + outputFile;

		FileReader firstDocReader = new FileReader(pathString);
		FileReader secondDocReader = new FileReader(secondPathString);
		Scanner firstDoc = new Scanner(firstDocReader);
		Scanner secondDoc = new Scanner(secondDocReader);

		while (firstDoc.hasNextLine() && secondDoc.hasNextLine()) {
			System.out.println("The text present in the first document : " + firstDoc.nextLine());
			System.out.println("The text present in the second document : " + secondDoc.nextLine());
		}
		File noOfLinesinFirstFile = new File(pathString);
		Scanner linecountFirstFile = new Scanner(noOfLinesinFirstFile);
		int firstDocLineCount = 0;
		while (linecountFirstFile.hasNextLine()) {
			linecountFirstFile.nextLine();
			firstDocLineCount++;
		}
		File noOfLinesindSecondFile = new File(secondPathString);
		Scanner linecountSecondFile = new Scanner(noOfLinesindSecondFile);
		int secondDocLineCount = 0;
		while (linecountSecondFile.hasNextLine()) {
			linecountSecondFile.nextLine();
			secondDocLineCount++;
		}
		String firstDocWordCount;
		int firstTextWordCount = 0;
		FileReader readFirst = new FileReader(pathString);
		BufferedReader countFirstWordText = new BufferedReader(readFirst);
		while ((firstDocWordCount = countFirstWordText.readLine()) != null) {
			String firstFileCount[] = firstDocWordCount.split(" ");
			firstTextWordCount = firstTextWordCount + firstFileCount.length;
		}
		countFirstWordText.close();

		String secondDocWordCount;
		int secondTextWordCount = 0;
		FileReader readSecond = new FileReader(secondPathString);
		BufferedReader countSecondWordText = new BufferedReader(readSecond);
		while ((secondDocWordCount = countSecondWordText.readLine()) != null) {
			String SecondFileCount[] = secondDocWordCount.split(" ");
			secondTextWordCount = secondTextWordCount + SecondFileCount.length;
		}
		countSecondWordText.close();

		if ((firstDocLineCount == secondDocLineCount) && (firstTextWordCount == secondTextWordCount)) {
			FileWriter newFile = new FileWriter(outputpathString);
			BufferedWriter writeFile = new BufferedWriter(newFile);

			writeFile.write("Words count in first file is : " + firstTextWordCount);
			writeFile.newLine();
			writeFile.write("Words count in second file is : " + secondTextWordCount);
			writeFile.newLine();
			writeFile.write("Lines count in first file is : " + firstDocLineCount);
			writeFile.newLine();
			writeFile.write("Lines count in second file is : " + secondDocLineCount);
			writeFile.newLine();
			writeFile.write("Both files content are equal!!");
			writeFile.newLine();
			writeFile.close();
			System.out.println("File with same content is wriiten in the file successfully");
		} else {
			FileWriter newFile = new FileWriter(outputpathString);
			BufferedWriter writeFile = new BufferedWriter(newFile);

			writeFile.write("Words count in first file is : " + firstTextWordCount);
			writeFile.newLine();
			writeFile.write("The number words count in second file is : " + secondTextWordCount);
			writeFile.newLine();
			writeFile.write("Lines count in first file is : " + firstDocLineCount);
			writeFile.newLine();
			writeFile.write("Lines count in second file is : " + secondDocLineCount);
			writeFile.newLine();
			writeFile.write("Both files are not equal!!");
			writeFile.newLine();
			writeFile.close();
			System.out.println("File with different content is written in the file successfully");
		}

	}

}
