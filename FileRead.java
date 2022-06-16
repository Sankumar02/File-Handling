package com.Task_10_05_22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {
	String pathString;

	public void readFile() throws IOException, FileNotFoundException {
		Scanner oScanner = new Scanner(System.in);
		System.out.println("enter the filename :");
		String filename = oScanner.nextLine();
		String userDirectoryString = System.getProperty("user.dir");
		pathString = userDirectoryString + File.separator + filename;
		FileReader fileReader = new FileReader(pathString);
		Scanner reader = new Scanner(fileReader);

		while (reader.hasNextLine()) {
			System.out.println("The text present in the file is : " + reader.nextLine());
		}

	}

	public void numberOfLines() throws FileNotFoundException {
		int count = 0;

		File noOfLines = new File(pathString);
		Scanner numberofLines = new Scanner(noOfLines);

		while (numberofLines.hasNextLine()) {
			numberofLines.nextLine();
			count++;
		}
		System.out.println("Number of lines present in the file : " + count);
	}

	public void wordCount() throws FileNotFoundException, IOException {

		String lengthofWord;
		int wordCount = 0;
		FileReader countWords = new FileReader(pathString);
		BufferedReader wordLength = new BufferedReader(countWords);
		while ((lengthofWord = wordLength.readLine()) != null) {
			String letters[] = lengthofWord.split(" ");
			wordCount = wordCount + letters.length;
		}
		System.out.println("Number of words present in the file : " + wordCount);
		wordLength.close();
	}

	public void letterCount() throws IOException, FileNotFoundException {
		String lengthofLetters;
		int countletters = 0;
		FileReader countWords = new FileReader(pathString);

		BufferedReader letterLength = new BufferedReader(countWords);
		lengthofLetters = letterLength.readLine();

		for (int charIndex = 0; charIndex < lengthofLetters.length(); charIndex++) {
			if (Character.isLetter(lengthofLetters.charAt(charIndex))) {
				countletters++;
			}
		}
		System.out.println("Number of Letters present in the file " + "FileReader.text is " + countletters);

	}

}
