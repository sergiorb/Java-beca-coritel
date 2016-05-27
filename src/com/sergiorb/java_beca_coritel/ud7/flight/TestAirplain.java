package com.sergiorb.java_beca_coritel.ud7.flight;

import java.util.Scanner;

public class TestAirplain {

	public static void main(String[] args) {

		int userInput = -1;
		int temp = 0;
		boolean added = false;
		Scanner input = new Scanner(System.in);
		Airplain airplain = new Airplain(10, 5);

		do {

			System.out.println("Please, write 1 for First Class.");
			System.out.println("Please, write 2 for Economic Class.");
			System.out.println("Please, write 0 to exit");

			try {
				userInput = input.nextInt();
			} catch (Exception e) {
				input.next();
			}

			if (userInput != 0) {
				added = airplain.requestSeat(userInput);

				if (userInput == 1 || userInput == 2) {

					if (added == false) {

						temp = userInput;

						do {

							System.out.printf("Would you like to take a seat in %s class? (Yes=3, No=4)\n",
									userInput == 1 ? "Economic" : "First");

							try {
								userInput = input.nextInt();
							} catch (Exception e) {
								input.next();
							}

							if (userInput == 3) {
								switch (temp) {
								case 1:
									added = airplain.requestSeat(2);
									break;
								case 2:
									added = airplain.requestSeat(1);
									break;
								default:
									break;
								}

								if (!added) {
									System.out.println("\nThe next fligt departs in 3 hours!!\n");
									break;
								} else {
									break;
								}
							} else if (userInput == 4) {
								break;
							}
						} while (userInput != 3 || userInput != 4);
					}
				}
			}
		} while (userInput != 0);

		input.close();
		airplain.printFligtStatus();
	}

}
