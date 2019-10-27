package vcn_vacina.vacinaja.mocks;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vcn_vacina.vacinaja.Vaccines.Importancia;
import vcn_vacina.vacinaja.Vaccines.Vaccine;

public class MockedVaccines {
    public static List<Vaccine> mockedVaccine = new ArrayList<>(Arrays.asList(
            new Vaccine("BCG - ID", ".....", Importancia.Alta, 0, "Formas graves de tuberculose", 50),
            new Vaccine("Vacina contra hepatite B (1)", ".....", Importancia.Alta, 0, "Hepatite B",50),
            new Vaccine("DTP (tríplice bacteriana", ".....", Importancia.Alta, 4, "Difteria, tétano e coqueluche", 50),
            new Vaccine("Influenza (5)", ".....", Importancia.Media, 60, "Contra Influenza ou Gripe",50),
            new Vaccine("Vacina contra febre amarela", ".....", Importancia.Alta, 0, "Formas graves de tuberculose",50)

    ));

    public static List<Vaccine> mockedVaccineTaken = new ArrayList<>();

    public static List<Vaccine> getMockedVaccine() {
        return mockedVaccine;
    }

    public static void setMockedVaccine(List<Vaccine> mockedVaccine) {
        MockedVaccines.mockedVaccine = mockedVaccine;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static float findPriceByName(String name){
        Vaccine vac = mockedVaccine.stream().filter(vaccine -> vaccine.getName().equals(name)).collect(Collectors.toList()).get(0);
        return vac.getPrice();
    }    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Vaccine findVaccineByName(String name){
        return mockedVaccine.stream().filter(vaccine -> vaccine.getName().equals(name)).collect(Collectors.toList()).get(0);
    }
}
