package diet;

import java.util.Map;
import java.util.TreeMap;

/**
 * Represent a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw
 * materials. The overall nutritional values of a recipe can be computed on the
 * basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {
	private String name;
	private Map<String, Ingredient> ingredients = new TreeMap<>();
	private Food food;

	/**
	 * Recipe constructor. The reference {@code food} of type {@link Food} must
	 * be used to retrieve the information about ingredients.
	 * 
	 * @param nome
	 *            unique name of the recipe
	 * @param food
	 *            object containing the information about ingredients
	 */
	public Recipe(String name, Food food) {
		this.name = name;
		this.food = food;
		this.food.recipes().add(this);
	}

	/**
	 * Adds a given quantity of an ingredient to the recipe. The ingredient is a
	 * raw material defined with the {@code food} argument of the constructor.
	 * 
	 * @param material
	 *            the name of the raw material to be used as ingredient
	 * @param quantity
	 *            the amount in grams of the raw material to be used
	 */
	public void addIngredient(String material, double quantity) {
		NutritionalElement rm = food.getRawMaterial(material);
		Ingredient i = new Ingredient(rm, quantity);
		ingredients.put(material, i);

	}

	public String getName() {
		return name;
	}

	public double getCalories() {
		double totweight = 0;
		double totkCal = 0;
		for (Ingredient i : ingredients.values()) {
			totweight += i.getQuantity();
			totkCal += i.getRawMaterial().getCalories();
		}
		return totkCal / totweight;
	}

	public double getProteins() {
		double totweight = 0;
		double totProteins = 0;
		for (Ingredient i : ingredients.values()) {
			totweight += i.getQuantity();
			totProteins += i.getRawMaterial().getProteins();
		}
		return totProteins / totweight;
	}

	public double getCarbs() {
		double totweight = 0;
		double totCarbs = 0;
		for (Ingredient i : ingredients.values()) {
			totweight += i.getQuantity();
			totCarbs += i.getRawMaterial().getCarbs();
		}
		return totCarbs / totweight;
	}

	public double getFat() {
		double totweight = 0;
		double totFat = 0;
		for (Ingredient i : ingredients.values()) {
			totweight += i.getQuantity();
			totFat += i.getRawMaterial().getFat();
		}
		return totFat / totweight;
	}

	public boolean per100g() {
		// a recipe expressed nutritional values per 100g
		return true;
	}

}
