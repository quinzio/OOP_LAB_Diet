package diet;

public class RawMaterial implements NutritionalElement{
    private String name;
    private double kCal;
    private double proteins;
    private double carbs;
    private double fats;

    public RawMaterial(String name, double kCal, double proteins, double carbs, double fats) {
	super();
	this.name = name;
	this.kCal = kCal;
	this.proteins = proteins;
	this.carbs = carbs;
	this.fats = fats;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public double getCalories() {
	return kCal;
    }

    @Override
    public double getProteins() {
	return proteins;
    }

    @Override
    public double getCarbs() {
	return carbs;
    }

    @Override
    public double getFat() {
	return fats;
    }

    @Override
    public boolean per100g() {
	return true;
    }


}
