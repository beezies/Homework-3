package edu.sjsu.assignment2;

import java.util.Scanner;

public class TimeDifference {

	public static String calculateTimeDifference(int time1, int time2) {
		
		if (time1 > time2) {
			time2 += 2400;
		}

		int totalMin1 = (time1 / 100 * 60) + (time1 % 100);
		int totalMin2 = (time2 / 100 * 60) + (time2 % 100);
		int totalMinDiff = totalMin2 - totalMin1;

		int hours = totalMinDiff / 60;
		int mins = totalMinDiff % 60;

		return (hours + " hour(s) " + mins + " minute(s)");
	}

	public static int timeFormatted(String timeString) throws NumberFormatException {
		int time = Integer.parseInt(timeString);
		int min = time % 100;
		if (time >= 0 && time < 2400 && min < 60)
			return time;
		else
			throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		String timeDiff = "";

		while (!valid) {
			try {
				System.out.println("Please enter the first time: ");
				String start = scan.next();
				int time1 = timeFormatted(start);

				System.out.println("Please enter the next time: ");
				String stop = scan.next();
				int time2 = timeFormatted(stop);

				timeDiff = TimeDifference.calculateTimeDifference(time1, time2);
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input is not an integer! Please try again.");
			} catch (IllegalArgumentException e) {
				System.out.println("Your input is not in a valid time format! Please try again.");
			}
		}
		
		System.out.println(timeDiff);

		scan.close();
	}

}
