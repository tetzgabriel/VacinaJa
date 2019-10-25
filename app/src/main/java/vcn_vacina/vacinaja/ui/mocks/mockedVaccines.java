package vcn_vacina.vacinaja.ui.mocks;

import java.util.ArrayList;
import java.util.List;

public class mockedVaccines {
    public static List<Vaccine> mockedVaccine = new ArrayList<>();

    static {
        mockedVaccine.add(new Vaccine("BCG - ID", ".....", 3, 0, "Formas graves de tuberculose", true));
        mockedVaccine.add(new Vaccine("Vacina contra hepatite B (1)", ".....", 3, 0, "Hepatite B", false));
        mockedVaccine.add(new Vaccine("DTP (tríplice bacteriana", ".....", 3, 4, "Difteria, tétano e coqueluche", false));
        mockedVaccine.add(new Vaccine("Influenza (5)", ".....", 2, 60, "Contra Influenza ou Gripe", false));
        mockedVaccine.add(new Vaccine("Vacina contra febre amarela", ".....", 3, 0, "Formas graves de tuberculose", true));
        mockedVaccine.add(new Vaccine("BCG - ID", ".....", 3, 10, "Febre amarela", true));
        mockedVaccine.add(new Vaccine("BCG - ID", ".....", 3, 0, "Formas graves de tuberculose", false));
        mockedVaccine.add(new Vaccine("BCG - ID", ".....", 3, 0, "Formas graves de tuberculose", false));
    }
}
