package com.Task_10_05_22;

public class FileReader {
	public static void main(String[] args) throws Exception {
		FileRead oRead = new FileRead();// FileReader.txt
		oRead.readFile();
		oRead.numberOfLines();
		oRead.wordCount();
		oRead.letterCount();
	}
}
