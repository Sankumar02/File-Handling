package com.Task_10_05_22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example {
	public boolean compareTextFiles() throws FileNotFoundException, IOException {
		FileReader firstFileReader = new FileReader("D:\\FirstFile.txt");
		FileReader secondFileReader = new FileReader("D:\\SecondFile.txt");
		BufferedReader r1 = new BufferedReader(firstFileReader);
		BufferedReader r2 = new BufferedReader(secondFileReader);
		int compareFirstFile = 0, compareSecondFile = 0;
		while (true) {
			compareFirstFile = r1.read();
			compareSecondFile = r2.read();
			if (compareFirstFile == -1 && compareSecondFile == -1)
				return true;
			else if (compareFirstFile == -1 || compareSecondFile == -1 || compareFirstFile != compareSecondFile) {
				return false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String firstFileReader = "Path to Firstfile";
		String secondFileReader = "Path to Secondfile";

		if (firstFileReader == secondFileReader) {
			System.out.println("Files are same");
		} else {
			System.out.println("Files are different");
		}
	}
}