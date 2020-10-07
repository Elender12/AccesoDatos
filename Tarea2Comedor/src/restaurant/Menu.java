package restaurant;

import java.text.DecimalFormat;

/*Mostrar la carta de cada día de un restaurante que se compondrá de 6 platos de la lista de
platos que elabora el restaurante. En cada plato se mostrarán los ingredientes que lo
componen y el precio de ese plato. */

public class Menu {
	final static int MENU_NUMBER= 6;
	//attribute
	Dish menu[];

	public Menu(Dish[] menu) {
		this.menu = menu;
	}
	public Menu() {
		this.menu = new Dish[MENU_NUMBER];
	}
	
	
	public  Menu generateMenu() {
		   Dish dish = new Dish();
		   Dish[] dishes = new Dish[MENU_NUMBER];
		   for (int i = 0; i < dishes.length; i++) {
			   dishes[i] = dish.generateDish();
			  
		}
		   
		return new Menu(dishes);
	}
	public void printMenu() {
		DecimalFormat df = new DecimalFormat("0.00");
		for (int i = 0; i < menu.length; i++) {
			System.out.println("Dish " + (i + 1) + " has " + menu[i].getIngredients() + " and costs "
					+ df.format(menu[i].calculateDishPrice()) + " €");
		}
	}
	
	
}
