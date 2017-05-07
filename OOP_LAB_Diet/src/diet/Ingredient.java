package diet;

public class Ingredient {
    private NutritionalElement nutritional;
    private double quantity;
    public Ingredient(NutritionalElement rm, double quantity) {
	super();
	this.nutritional = rm;
	this.quantity = quantity;
    }
    public NutritionalElement getRawMaterial() {
        return nutritional;
    }
    public void setRawMaterial(NutritionalElement rawMaterial) {
        this.nutritional = rawMaterial;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    

}
