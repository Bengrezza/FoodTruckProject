package com.skilldistillery.foodtruck;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckApp {
    //only class that will have a Scanner, 
	// menu prompting user for input that is going to loop, until,
	//the user inputs quick when prompted for the food truck name
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	Scanner kb = new Scanner(System.in);
	FoodTruckApp foodTruckApp = new FoodTruckApp();

	foodTruckApp.launchApp(kb, foodTruckApp);

	kb.close();
			
	}

	public void launchApp(Scanner kb, FoodTruckApp foodTruckApp) {
		System.out.println("Hello, and welcome to the Food Truck Application!");
			FoodTruck[] foodTrucks = foodTruckApp.inputTruck(kb);

		boolean menu = true;
		while (menu) {
			foodTruckApp.printMenu();
			menu = foodTruckApp.chooseFromMenu(kb, foodTrucks);
				}
			}

	public FoodTruck[] inputTruck(Scanner kb) {
		System.out.println("Please enter the amount of Food Trucks (0-4), you would like to rate:");
		int arrIndex = kb.nextInt();
		kb.nextLine();

		FoodTruck[] foodTruckArr = new FoodTruck[arrIndex];

		String foodType = "";
		double rating = 0;

		for (int i = 0; i < foodTruckArr.length; i++) {
		System.out.println("Please enter a food truck's name or \"Quit\" to stop entering trucks: ");
		String truckName = kb.nextLine();

		if (truckName.equalsIgnoreCase("Quit")) {
			FoodTruck[] earlyExitArr = Arrays.copyOf(foodTruckArr, i);
			return earlyExitArr;
		} else {
			System.out.println("Please enter the type of food:");
			foodType = kb.nextLine();

			do {
				System.out.println("Please enter rating (0-5):");
				rating = kb.nextDouble();
				if (rating > 5 || rating < 0) {
				System.out.println("Error: The rating you selected rating was out of range. Please try again.");
							}
			} while (rating > 5 || rating < 0);
				kb.nextLine();

				foodTruckArr[i] = new FoodTruck();
				foodTruckArr[i].setTruckName(truckName);
				foodTruckArr[i].setTruckName(truckName);
				foodTruckArr[i].setFoodType(foodType);
				foodTruckArr[i].setRating(rating);
				foodTruckArr[i].setTruckID(i);
					}
				}

		return foodTruckArr;
			}

	public void printMenu() {
		System.out.println();
		System.out.println("|---------------------------------------------|");
		System.out.println("|                                             |");
		System.out.println("| * Please choose one of the following: *     |");
		System.out.println("|1. Display all existing Food Trucks.         |");
		System.out.println("|2. Display the average rating of Food Trucks.|");
		System.out.println("|3. Display the highest-rated Food Truck.     |");
		System.out.println("|4. Quit the program.                         |");
		System.out.println("|                                             |");
		System.out.println("|---------------------------------------------|");
		System.out.println();
			}

	public boolean chooseFromMenu(Scanner kb, FoodTruck[] trucks) {
		int selection = 0;

		do {
			System.out.println("Please enter your selection (1-4): ");
			selection = kb.nextInt();

			if (selection > 4 || selection < 1) {
				System.out.println("Error: Your selection was out of range. Please try again.");
					}
			} while (selection > 4 || selection < 1);

				System.out.println();

				switch (selection) {
				case 1:
					displayTrucks(trucks);
					break;
				case 2:
					seeAverageRating(trucks);
					break;
				case 3:
					showHighestRated(trucks);
					break;
				case 4:
					System.out.println("I hope you enjoyed the Food Trucks! Thank you, have a good day and please come again!");
					return false;
				}

				return true;
			}

	public void displayTrucks(FoodTruck[] trucks) {
		System.out.println("All existing Food Trucks:");
				
		for (int i = 0; i < trucks.length; i++) {
			System.out.println(trucks[i].toString());
		}
	}

	public void seeAverageRating(FoodTruck[] trucks) {
		double sumRatings = 0;

		for (int i = 0; i < trucks.length; i++) {
			sumRatings += trucks[i].getRating();
		}

		double average = sumRatings / trucks.length * 1.0;
		double averageRounded = (Math.round((average) * 100.0)) / 100.0;

		System.out.println("Average Food Truck Rating: " + averageRounded);
	}

	public void showHighestRated(FoodTruck[] trucks) {
		double highestRating = trucks[0].getRating();

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].getRating() > highestRating) {
				highestRating = trucks[i].getRating();
					}
				}

		int x = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (highestRating == trucks[i].getRating()) {
				x++;
					}
				}

		if (x > 1) {
			System.out.println(x + " food trucks tie for the highest-rated:");
		} else {
			System.out.println("The highest-rated food truck is:");
				}

		for (int i = 0; i < trucks.length; i++) { // look for the match and any ties
			if (highestRating == trucks[i].getRating()) {
				System.out.println(trucks[i].toString());
					}
				}
			}
		
	}


