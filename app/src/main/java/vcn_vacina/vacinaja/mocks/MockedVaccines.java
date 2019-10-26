package vcn_vacina.vacinaja.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vcn_vacina.vacinaja.Vaccines.Importancia;
import vcn_vacina.vacinaja.Vaccines.Vaccine;

public class MockedVaccines {
    public static List<Vaccine> mockedVaccine = new ArrayList<>(Arrays.asList(
            new Vaccine("BCG - ID", ".....", Importancia.Alta, 0, "Formas graves de tuberculose", 50 ,true),
            new Vaccine("Vacina contra hepatite B (1)", ".....", Importancia.Alta, 0, "Hepatite B",50 , false),
            new Vaccine("DTP (tríplice bacteriana", ".....", Importancia.Alta, 4, "Difteria, tétano e coqueluche", 50 ,false),
            new Vaccine("Influenza (5)", ".....", Importancia.Media, 60, "Contra Influenza ou Gripe",50 , false),
            new Vaccine("Vacina contra febre amarela", ".....", Importancia.Alta, 0, "Formas graves de tuberculose",50 , true),
            new Vaccine("BCG - ID", ".....", Importancia.Alta, 10, "Febre amarela",50 , true),
            new Vaccine("BCG - ID", ".....", Importancia.Alta, 0, "Formas graves de tuberculose",50 , false),
            new Vaccine("BCG - ID", ".....", Importancia.Alta, 0, "Formas graves de tuberculose",50 , false)

    ));

    public static List<Vaccine> getMockedVaccine() {
        return mockedVaccine;
    }

    public static void setMockedVaccine(List<Vaccine> mockedVaccine) {
        MockedVaccines.mockedVaccine = mockedVaccine;
    }
}
