package vcn_vacina.vacinaja.ui.mocks;

public class Vaccine {
    String name;
    String description;
    int importance; //todo criar classe especifica
    int minimunAge;
    String preventedDisease;

    boolean status;

    public Vaccine(String name, String description, int importance, int minimunAge, String preventedDisease, boolean status) {
        this.name = name;
        this.description = description;
        this.importance = importance;
        this.minimunAge = minimunAge;
        this.preventedDisease = preventedDisease;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImportance() {
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
}
