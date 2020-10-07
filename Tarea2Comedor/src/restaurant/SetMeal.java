package restaurant;

import java.text.DecimalFormat;

public class SetMeal {
	final static int DISH_NUMBER = 2;
	// attributes
	Dish dishes[] = new Dish[2];
	private float price;

	// constructor
	public SetMeal(Dish[] dishes) {
		this.dishes = dishes;
	}

	public SetMeal() {
	}

	// getters and setters
	public Dish[] getDishes() {
		return dishes;
	}

	public void setDishes(Dish[] dishes) {
		this.dishes = dishes;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// methods
	public void calculateSetMealPrice() {
		for (Dish dish : this.dishes) {
			//this.price += dish.calculateDishPrice();
			this.price += dish.getPrice();
			
		}
		//return this.price;
	}

	public SetMeal generateSetMeal() {
		Dish dish = new Dish();
		Dish[] dishes = new Dish[DISH_NUMBER];
		for (int i = 0; i < dishes.length; i++) {
			dishes[i] = dish.generateDish();
		 
		}
		return new SetMeal(dishes);
	}

	public void printMeal() {
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < dishes.length; i++) {
			System.out.println("Dish " + (i + 1) + " has " + dishes[i].getIngredients() + " and costs "
					+ df.format(dishes[i].getPrice()) + "€");
		}
	}

}
