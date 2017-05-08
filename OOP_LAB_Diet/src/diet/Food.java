package diet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Facade class for the diet management. It allows defining and retrieving raw
 * materials and products.
 *
 */
public class Food {
	private Map<String, NutritionalElement> nutritionals = new TreeMap<>();
	private Map<String, NutritionalElement> products = new TreeMap<>();
	private List<NutritionalElement> recipes = new ArrayList<>();

	/**
	 * Define a new raw material. The nutritional values are specified for a
	 * conventional 100g quantity
	 * 
	 * @param name
	 *            unique name of the raw material
	 * @param calories
	 *            calories per 100g
	 * @param proteins
	 *            proteins per 100g
	 * @param carbs
	 *            carbs per 100g
	 * @param fat
	 *            fats per 100g
	 */
	public void defineRawMaterial(String name, double calories, double proteins,
			double carbs, double fat) {
		RawMaterial rm = new RawMaterial(name, calories, proteins, carbs, fat);
		nutritionals.put(name, rm);

	}

	/**
	 * Retrieves the collection of all defined raw materials
	 * 
	 * @return collection of raw materials though the {@link NutritionalElement}
	 *         interface
	 */
	public Collection<NutritionalElement> rawMaterials() {
		Collection<NutritionalElement> pne = new ArrayList<>();
		pne = nutritionals.values();
		return pne;
	}

	/**
	 * Retrieves a specific raw material, given its name
	 * 
	 * @param name
	 *            name of the raw material
	 * @return a raw material though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRawMaterial(String name) {
		return nutritionals.get(name);
	}

	/**
	 * Define a new packaged product. The nutritional values are specified for a
	 * unit of the product
	 * 
	 * @param name
	 *            unique name of the product
	 * @param calories
	 *            calories for a product unit
	 * @param proteins
	 *            proteins for a product unit
	 * @param carbs
	 *            carbs for a product unit
	 * @param fat
	 *            fats for a product unit
	 */
	public void defineProduct(String name, double calories, double proteins,
			double carbs, double fat) {
		Product p = new Product(name, calories, proteins, carbs, fat);
		products.put(name, p);
	}

	/**
	 * Retrieves the collection of all defined products
	 * 
	 * @return collection of products though the {@link NutritionalElement}
	 *         interface
	 */
	public Collection<NutritionalElement> products() {
		Collection<NutritionalElement> cp = new ArrayList<>();
		cp = products.values();
		return cp;
	}

	/**
	 * Retrieves a specific product, given its name
	 * 
	 * @param name
	 *            name of the product
	 * @return a product though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getProduct(String name) {
		return products.get(name);
	}

	/**
	 * Retrieves the collection of all defined recipes
	 * 
	 * @return collection of recipes though the {@link NutritionalElement}
	 *         interface
	 */
	public Collection<NutritionalElement> recipes() {
		recipes.sort(Comparator.comparing(NutritionalElement::getName));
		return recipes;
	}

	/**
	 * Retrieves a specific recipe, given its name
	 * 
	 * @param name
	 *            name of the recipe
	 * @return a recipe though the {@link NutritionalElement} interface
	 */
	public NutritionalElement getRecipe(String name) {
		for (NutritionalElement r : recipes) {
			if (r.getName().equals(name))
				return r;
		}
		return null;
	}

}
