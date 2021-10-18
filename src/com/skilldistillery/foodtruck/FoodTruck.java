package com.skilldistillery.foodtruck;

public class FoodTruck {
 //this FoodTruck class has data
	//including the id, which
	//will be generated in a constructor from a static field
	//that is incremented as each truck is created
	private String truckName;
	private String foodType;
	private double rating;
	private int truckID;
	private static int nextTruckID = 5;

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String foodType, double rating, int truckID) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		this.truckID = truckID;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID + nextTruckID;
	}

	public static int getNextTruckID() {
		return nextTruckID;
	}

	public static void setNextTruckID(int nextTruckID) {
		FoodTruck.nextTruckID = nextTruckID;
		nextTruckID++;
	}

	public String toString() {
		StringBuilder make = new StringBuilder();
		make.append("Food Truck Name: ").append(truckName).append(", Food Type: ").append(foodType)
				.append(", Rating: ").append(rating).append(", and truckID: ").append(truckID).append(".");
		return make.toString();
	}

}

