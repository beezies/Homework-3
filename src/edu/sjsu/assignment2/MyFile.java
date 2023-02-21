package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {

	public void writePrimes(String file1, String file2) throws FileNotFoundException {
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

	private boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= (num / 2); i++) {
			if ((num % i) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		MyFile file = new MyFile();
		try {
			file.writePrimes("SomePrimes", "ndlsnk");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}
}
