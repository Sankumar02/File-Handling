package com.Task_10_05_22;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Compare {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileComparison oComparison = new FileComparison();// FirstFile.txt,SecondFile.txt,Doc.txt
		oComparison.readAndCompareFiles();
	}
}
