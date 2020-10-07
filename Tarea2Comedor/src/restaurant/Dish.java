package restaurant;

import java.util.ArrayList;
import java.util.List;


public class Dish {
	
	static final  int EXPENSES = 1;
	//attributes
	private List<Ingredient> ingredients;

	private float price;
	
	public Dish() {
		this.ingredients  = new ArrayList<Ingredient>();
		this.price = 0;
	}

	public Dish(List<Ingredient> ingredients) {
		super();
		this.ingredients = ingredients;
	}
	
	//getters and setters
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	//methods
	public Dish generateDishOld() {
		int numIngredients = (int) (Math.random() * 3 + 1);
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		Ingredient newIngredient = new Ingredient();
		newIngredient = newIngredient.generateIngredient();
		ingredientList.add(newIngredient);
		for (int i = 0; i < numIngredients-1; i++) {
			newIngredient = newIngredient.generateIngredient();
			while(ingredientList.get(i).getName().equals(newIngredient.getName())) {
				newIngredient = newIngredient.generateIngredient();		
			}
			ingredientList.add(newIngredient);
		}
		return new Dish(ingredientList);
	}
	
	public Dish generateDish() {
		int numIngredients = (int) (Math.random() * 3 + 1);
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		Ingredient newIngredient = new Ingredient();
		newIngredient = newIngredient.generateIngredient();
		for (int i = 0; i < numIngredients; i++) {
			newIngredient = newIngredient.generateIngredient();
			if(!ingredientList.contains(newIngredient)) {
				ingredientList.add(newIngredient);
			}
		}
		return new Dish(ingredientList);
	}
	
	public float calculateDishPrice() {
		for(Ingredient ingredient: this.ingredients) {
			this.price+= ingredient.getPrice();
		}
		this.price += EXPENSES;
		return this.price;
	}

	public String ingredientsToString() {
		String data ="";
		for(Ingredient item: this.ingredients) {
			data += item.getName()+ " ";	
		}
		return data;
	}
}
