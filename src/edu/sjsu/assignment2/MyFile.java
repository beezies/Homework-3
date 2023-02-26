package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * Contains methods for copying prime numbers from one file to another.
 * 
 * @author briannanicole
 *
 */

public class MyFile {

	/**
	 * Takes the name of an existing file, and copies every prime number present in
	 * that file into a new file given by file2.
	 * 
	 * @param file1 Input file
	 * @param file2 Output file
	 * @throws FileNotFoundException
	 */

	public static void writePrimes(String file1, String file2) throws FileNotFoundException {
		File inputFile = new File(file1);
		PrintWriter output = new PrintWriter(file2);

		Scanner fileScanner = new Scanner(inputFile);
		fileScanner.useDelimiter(",");

		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(",");

			while (lineScanner.hasNext()) {
				if (lineScanner.hasNextInt()) {
					int num = lineScanner.nextInt();
					if (isPrime(num))
						output.println(num);
				} else {
					lineScanner.next();
				}
			}
			lineScanner.close();
		}
		fileScanner.close();
		output.close();
	}

	/**
	 * Determines whether or not a given integer is prime.
	 * 
	 * @param num Integer to check
	 * @return Whether or not integer is prime
	 */

	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= (num / 2); i++) {
			if ((num % i) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			MyFile.writePrimes("SomePrimes", "ndlsnk");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}
