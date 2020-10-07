package restaurant;

import java.util.Random;

/**
 * @author Elena
 * 
 */
public class Ingredient {
	// attributes
	private String name;
	private float price;

	// constructors
	public Ingredient() {
	}

	public Ingredient(String name, float price) {
		this.name = name;
		this.price = price;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Ingredient generateIngredient() {
		Random rnd = new Random();
		String ingredient[] = { "pasta", "cheese", "tomatoes", "garlic", "eggs", "meat", "sausages", "bread", "fish",
		"chicken" };
		float price = (float) (Math.random() * 20 + 1);
		return new Ingredient(ingredient[(rnd.nextInt(ingredient.length))], price);
	}

	@Override
	public String toString() {
		return " " + name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if (obj != null && obj instanceof Ingredient) {
			isEqual = this.name.equals(((Ingredient) obj).getName());
		}
		return isEqual;
	}
}
