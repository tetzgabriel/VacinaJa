package vcn_vacina.vacinaja.Vaccines;

public class Vaccine {
    String name;
    String description;
    Importancia importance; //todo criar classe especifica
    int minimunAge;
    String preventedDisease;
    float price;
    boolean status;

    public Vaccine(String name, String description, Importancia importance, int minimunAge, String preventedDisease, float price, boolean status) {
        this.name = name;
        this.description = description;
        this.importance = importance;
        this.minimunAge = minimunAge;
        this.preventedDisease = preventedDisease;
        this.price = price;
        this.status = status;
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

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
