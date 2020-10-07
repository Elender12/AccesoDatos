package restaurant;

import java.util.Comparator;

public class CompareIngredients implements Comparator<Ingredient> {

	@Override
	public int compare(Ingredient ing1, Ingredient ing2) {
		return ing1.getName().compareToIgnoreCase(ing2.getName());
	}
}

//1 si es mayor, 0 si son iguales o -1 si es menor
//it must be called with Collections.sort(element that is an array list) -> compareTo
//Collections.sort(new CompareCustomClass());

