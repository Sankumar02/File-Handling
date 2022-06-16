package com.Task_10_05_22;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileWrite {
	int numberOfLines;
	String pathString;

	public void getNumberOfLines() {
		Scanner getLines = new Scanner(System.in);
		try {
			System.out.println("Number of lines to be written by the user : ");
			numberOfLines = getLines.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter the integer as input");
			System.exit(numberOfLines);
		}
	}

	public void create() {
		try {
			Scanner oScanner = new Scanner(System.in);
			System.out.println("enter the filename :");
			String filename = oScanner.nextLine();
			String userDirectoryString = System.getProperty("user.dir");
			pathString = userDirectoryString + File.separator + filename;
			File createFile = new File(pathString);

			if (createFile.createNewFile()) {
				System.out.println("File is created");
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public void Write() {
		Scanner writeScanner = new Scanner(System.in);

		System.out.println("Enter the text to be printed :");
		String writeString;

		try {
			FileWriter fileWrite = new FileWriter(pathString);
			fileWrite.write("Number of lines mentioned by the user : " + numberOfLines);
			for (int index = 0; index < numberOfLines; index++) {
				writeString = writeScanner.nextLine();

				fileWrite.write("\n" + writeString);

			}
			fileWrite.close();
			System.out.println("Finished Writing");
		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}
	}

}
