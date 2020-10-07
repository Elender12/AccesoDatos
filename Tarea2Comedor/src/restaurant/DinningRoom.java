package restaurant;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DinningRoom {
	public static void showOptions() {
		System.out.println("/////////////");
		System.out.println("1. Order a  set meal (2 dishes).");
		System.out.println("2. Show the table's orders.");
		System.out.println("3. Pay all the table's orders.");
		System.out.println("4. Exit.");
		System.out.println("/////////////");
	}

	public static void main(String[] args) {
		//sets a table number
		int tableNum = Utils.generateTableNumber();
		//all the table's orders
		Map<Integer, ArrayList<SetMeal>> tableOrders = new TreeMap<Integer, ArrayList<SetMeal>>();
		//one table's orders
		ArrayList<SetMeal> meals = new ArrayList<SetMeal>();
		//the whole menu
		Menu menu = new Menu();
		menu = menu.generateMenu();
		System.out.println("Your table number is: " + tableNum);
		SetMeal setMeal = null;
		System.out.println("/////MENU////");
		menu.printMenu();
		int option = 0;
		do {
			showOptions();
			option = Leer.pedirEntero("Please choose an option: ");
			switch (option) {
			case 1:
				Dish choosedDishes[] = new Dish[SetMeal.DISH_NUMBER];
				for (int i = 0; i < choosedDishes.length; i++) {
					int choice = Leer.pedirEntero("Insert the dish number: ");
					while(choice > 6 || choice < 1) {
						choice = Leer.pedirEntero("Insert a valid dish number: ");
					}
					choosedDishes[i] = menu.menu[choice-1];
				}
				setMeal = new SetMeal(choosedDishes);
				setMeal.calculateSetMealPrice();
				setMeal.printMeal();
				meals.add(setMeal);
				tableOrders.put(tableNum, meals);
				break;
			case 2:
				if(!tableOrders.isEmpty()) {
					showTableOrders(tableOrders);
				}else {
					System.out.println("There's no orders!");
				}
				break;
			case 3:
				if(!tableOrders.isEmpty()) {
					printOrdersTableTotalPrice(tableOrders);
					option = 4;
				}else {
					System.out.println("There's no orders to pay!");
				}
				break;
			}
		} while (option != 4);

	}
	
	public static void payOrder(float price) {
		float amountPayed = Leer.pedirFloat("Insert amount to pay: ");
		while(amountPayed < price) {
				System.out.println("The amount you inserted it's not correct.");
				amountPayed = Leer.pedirFloat("Insert THE CORRECT amount to pay: ");
		}
		if (amountPayed == price) {
			System.out.println("Thank you");
		
		}else if(amountPayed > price) {
			float change = amountPayed-price;
			float roundedFloat =  (float) ((float)Math.round(change* 100.0) / 100.0);
			System.out.println("Your change is: "+(roundedFloat));
			System.out.println("Thank you");
		}
	}
	
	public static void printOrdersTableTotalPrice(Map<Integer, ArrayList<SetMeal>> tableOrders) {
		float price = 0;
		for (Entry<Integer, ArrayList<SetMeal>> item : tableOrders.entrySet()) {
			ArrayList<SetMeal> values = item.getValue();
			for (SetMeal meal : values) {
				price += meal.getPrice();
			}
		}
		float roundedFloat =  (float) ((float)Math.round(price * 100.0) / 100.0);
		System.out.println("Price to pay: "+roundedFloat);
		payOrder(roundedFloat);
		
	
	}
	public static void showTableOrders(Map<Integer, ArrayList<SetMeal>> tableOrders) {
		for (Entry<Integer, ArrayList<SetMeal>> item : tableOrders.entrySet()) {
			ArrayList<SetMeal> values = item.getValue();
			for (SetMeal meal : values) {
				meal.printMeal();
			}
		}
	}
}
