package vcn_vacina.vacinaja.Vaccines;

public class Vaccine {
    String name;
    String description;
    Importancia importance; //todo criar classe especifica
    int minimunAge;
    String preventedDisease;
    float price;

    public Vaccine(String name, String description, Importancia importance, int minimunAge, String preventedDisease, float price) {
        this.name = name;
        this.description = description;
        this.importance = importance;
        this.minimunAge = minimunAge;
        this.preventedDisease = preventedDisease;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Importancia getImportance() {
        return importance;
    }

    public int getMinimunAge() {
        return minimunAge;
    }

    public String getPreventedDisease() {
        return preventedDisease;
    }

    @Override
    public String toString() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
