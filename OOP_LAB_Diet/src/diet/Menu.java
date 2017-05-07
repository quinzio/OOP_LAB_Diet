package diet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents a complete menu. It consist of packaged products and servings of
 * recipes.
 *
 */
public class Menu implements NutritionalElement {
    private String name;
    private Food food;
    List<String> products = new ArrayList<>();
    Map<String, Double> recipes = new TreeMap<>();

    /**
     * Menu constructor. The reference {@code food} of type {@link Food} must be
     * used to retrieve the information about recipes and products
     * 
     * @param nome
     *            unique name of the menu
     * @param food
     *            object containing the information about products and recipes
     */
    public Menu(String name, Food food) {
	this.name = name;
	this.food = food;
    }

    /**
     * Adds a given serving size of a recipe. The recipe is a name of a recipe
     * defined in the {@code food} argument of the constructor.
     * 
     * @param recipe
     *            the name of the recipe to be used as ingredient
     * @param quantity
     *            the amount in grams of the recipe to be used
     */
    public void addRecipe(String recipe, double quantity) {
	recipes.put(recipe, quantity);

    }

    /**
     * Adds a unit of a packaged product. The product is a name of a product
     * defined in the {@code food} argument of the constructor.
     * 
     * @param product
     *            the name of the product to be used as ingredient
     */
    public void addProduct(String product) {
	products.add(product);

    }

    public String getName() {
	return name;
    }

    public double getCalories() {
	double calories = 0;
	for (Map.Entry<String, Double> mesd : recipes.entrySet()) {
	    calories = food.getRecipe(mesd.getKey()).getCalories() * mesd.getValue();
	}
	for (String p : products) {
	    calories += food.getProduct(p).getCalories();
	}
	return calories;
    }

    public double getProteins() {
	double proteins = 0;
	for (Map.Entry<String, Double> mesd : recipes.entrySet()) {
	    proteins = food.getRecipe(mesd.getKey()).getProteins() * mesd.getValue();
	}
	for (String p : products) {
	    proteins += food.getProduct(p).getProteins();
	}
	return proteins;
    }

    public double getCarbs() {
	double carbs = 0;
	for (Map.Entry<String, Double> mesd : recipes.entrySet()) {
	    carbs = food.getRecipe(mesd.getKey()).getCarbs() * mesd.getValue();
	}
	for (String p : products) {
	    carbs += food.getProduct(p).getCarbs();
	}
	return carbs;
    }

    public double getFat() {
	double fat = 0;
	for (Map.Entry<String, Double> mesd : recipes.entrySet()) {
	    fat = food.getRecipe(mesd.getKey()).getFat() * mesd.getValue();
	}
	for (String p : products) {
	    fat += food.getProduct(p).getFat();
	}
	return fat;
    }

    public boolean per100g() {
	// nutritional values are provided for the whole menu.
	return false;
    }
}
